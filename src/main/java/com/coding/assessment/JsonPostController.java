package com.coding.assessment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/json")
public class JsonPostController {
	
	@Autowired
	JsonPostService jsonPostService;
	
	@GetMapping("/longest")
	public ResponseEntity<JsonPost> getLongestTitlePost() {
		JsonPost jsonPost = jsonPostService.getLongestTitlePost();
		
		return ResponseEntity.ok(jsonPost);
	}
	
	@GetMapping("")
	public ResponseEntity<List<JsonPost>> getJsonPosts() {
		List<JsonPost> jsonPosts = jsonPostService.getJsonPosts();

		return ResponseEntity.ok(jsonPosts);
	}
	
	@GetMapping("/modified")
	public ResponseEntity<List<JsonPostDto>> getModifiedJsonPosts() {
		List<JsonPostDto> jsonPosts = jsonPostService.getModifiedJsonPosts();
		
		return ResponseEntity.ok(jsonPosts);
	}
	
	@GetMapping("/comparator/standard")
	public ResponseEntity<JsonPost> getLongestTitleUsingStandardComparator() {
		JsonPost jsonPost = jsonPostService.getLongestTitleUsingStandardComparator();
		
		return ResponseEntity.ok(jsonPost);
	}
	@GetMapping("/comparator/ignorecase")
	public ResponseEntity<JsonPost> getLongestTitleUsingIgnoreCaseComparator() {
		JsonPost jsonPost = jsonPostService.getLongestTitleUsingIgnoreCaseComparator();
		
		return ResponseEntity.ok(jsonPost);
	}
	
}
