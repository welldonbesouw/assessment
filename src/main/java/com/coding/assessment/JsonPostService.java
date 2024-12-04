package com.coding.assessment;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class JsonPostService {

	private final RestClient restClient;
	
	private String API_URL = "https://jsonplaceholder.typicode.com";

	JsonPostService(RestClient.Builder restClientBuilder) {
		this.restClient = restClientBuilder.baseUrl(API_URL).build();
	}

	// getting the longest title from json placeholder api
	public JsonPost getLongestTitlePost() {

		List<JsonPost> jsonPosts = getJsonPosts();

		int currentLength = 0;
		int longestTitleId = 0;
		int longest = Integer.MIN_VALUE;

		for (JsonPost post : jsonPosts) {
			currentLength = post.title().length();
			if (currentLength > longest) {
				longest = currentLength;
				longestTitleId = post.id();
			}
		}

		JsonPost longestTitlePost = findById(jsonPosts, longestTitleId);
		System.out.println("\nLongest Title is: " + longestTitlePost.title());
		System.out.println("Body: " + longestTitlePost.body());

		return longestTitlePost;
	}

	private JsonPost findById(List<JsonPost> jsonPosts, int id) {

		for (JsonPost post : jsonPosts) {
			if (post.id() == id) {
				return post;
			}
		}

		return null;
	}

	// getting all posts from json placeholder api
	public List<JsonPost> getJsonPosts() {
		return restClient.get().uri("/posts").retrieve().body(new ParameterizedTypeReference<>() {});
	}

	// modifying the json response by adding titleLength field
	public List<JsonPostDto> getModifiedJsonPosts() {

		List<JsonPost> originalPost = restClient.get().uri("/posts").retrieve()
				.body(new ParameterizedTypeReference<>() {
				});
		List<JsonPostDto> modifiedPost = originalPost.stream().map(
				post -> new JsonPostDto(post.id(), post.userId(), post.title(), post.body(), post.title().length()))
				.collect(Collectors.toList());

		return modifiedPost;
	}

	// getting the longest title from json placeholder api by using standard comparator
	public JsonPost getLongestTitleUsingStandardComparator() {

		TitleLengthComparator comparator = new StandardComparator();
		List<JsonPost> jsonPosts = getJsonPosts();
		JsonPost longestTitlePost = findLongestTitle(jsonPosts, comparator);

		return longestTitlePost;
	}

	// getting the longest title from json placeholder api by using ignore case comparator
	public JsonPost getLongestTitleUsingIgnoreCaseComparator() {

		TitleLengthComparator comparator = new IgnoreCaseComparator();
		List<JsonPost> jsonPosts = getJsonPosts();
		JsonPost longestTitlePost = findLongestTitle(jsonPosts, comparator);

		return longestTitlePost;
	}

	private JsonPost findLongestTitle(List<JsonPost> jsonPosts, TitleLengthComparator comparator) {

		if (jsonPosts.isEmpty()) {
			return null;
		}

		JsonPost longestTitlePost = jsonPosts.get(0);
		for (JsonPost post : jsonPosts) {
			if (comparator.isLonger(post.title(), longestTitlePost.title())) {
				longestTitlePost = post;
			}
		}

		return longestTitlePost;
	}
}