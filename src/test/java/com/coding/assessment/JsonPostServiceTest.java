package com.coding.assessment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestClientTest(JsonPostService.class)
class JsonPostServiceTest {
	
	@Autowired
	MockRestServiceServer server;
	
	@Autowired
	JsonPostService jsonPostService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	String API_URI = "https://jsonplaceholder.typicode.com/posts";
	
	@Test
	void shouldGetJsonPosts() throws JsonProcessingException {
		// given
		List<JsonPost> jsonPosts = List.of(
			new JsonPost(1, 1, "Title 1", "Body 1"),
			new JsonPost(1, 2, "Title 2", "Body 2"),
			new JsonPost(2, 3, "Title 3", "Body 3")
		);
		
		// when
		server.expect(requestTo(API_URI))
			  .andRespond(withSuccess(objectMapper.writeValueAsString(jsonPosts), MediaType.APPLICATION_JSON));
		
		// then
		List<JsonPost> result = jsonPostService.getJsonPosts();
		assertThat(result).isNotNull();
		assertEquals(3, result.size());
	}
	
	@Test
	void shouldGetLongestTitle() throws JsonProcessingException {
		// given
		JsonPost longestTitlePost = new JsonPost(1, 1, "Very very very looooooooooooooong titleeeee aaaaaahhhhhhhhhh!", "Body 1");
		
		// when
		server.expect(requestTo(API_URI))
			  .andRespond(withSuccess(objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
					  							  .writeValueAsString(longestTitlePost), MediaType.APPLICATION_JSON));
		
		// then
		JsonPost result = jsonPostService.getLongestTitlePost();
		assertThat(result).isNotNull();
		assertThat(result.title().length()).isGreaterThan(60);
	}

	@Test
	void shouldGetLongestTitleUsingStandardComparator() throws JsonProcessingException {
		// given
		JsonPost longestTitleByComparator = new JsonPost(1, 1, "Very very very looooooooooooooong titleeeee using standard comparator wowww!", "Body 2");
		
		// when
		server.expect(requestTo(API_URI))
			  .andRespond(withSuccess(objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
					       						  .writeValueAsString(longestTitleByComparator), MediaType.APPLICATION_JSON));
		
		// then
		JsonPost result = jsonPostService.getLongestTitleUsingStandardComparator();
		assertThat(result).isNotNull();
		assertThat(result.title().length()).isGreaterThan(70);
	}

	@Test
	void shouldGetLongestTitleUsingIgnoreCaseComparator() throws JsonProcessingException {
		// given
		JsonPost longestTitleByComparator = new JsonPost(1, 1, "Very very very looooooooooooooong titleeeee using ignore case comparator wowww!", "Body 3");
		
		// when
		server.expect(requestTo(API_URI))
			  .andRespond(withSuccess(objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
					       						  .writeValueAsString(longestTitleByComparator), MediaType.APPLICATION_JSON));
		
		// then
		JsonPost result = jsonPostService.getLongestTitleUsingIgnoreCaseComparator();
		assertThat(result).isNotNull();
		assertThat(result.title().length()).isGreaterThan(70);
	}
	
	@Test
	void shouldGetModifiedJsonPosts() throws JsonProcessingException {
		// given
		List<JsonPostDto> modifiedPosts = List.of(
				new JsonPostDto(1, 1, "Title 1", "Body 1", 7),
				new JsonPostDto(1, 2, "Title 2 is longer", "Body 2", 17),
				new JsonPostDto(2, 3, "Title 3 is even longerrrr", "Body 3", 25)
		);
		
		// when
		server.expect(requestTo(API_URI))
			  .andRespond(withSuccess(objectMapper.writeValueAsString(modifiedPosts), MediaType.APPLICATION_JSON));
		
		// then
		List<JsonPostDto> result = jsonPostService.getModifiedJsonPosts();
		assertThat(result).isNotNull();
		assertEquals(25, result.get(2).getTitleLength());
	}
}
