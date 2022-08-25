package com.parquet.backend.scribe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parquet.backend.scribe.controller.util.ResponseEntityWrapper;
import com.parquet.backend.scribe.model.File;
import com.parquet.backend.scribe.model.Tag;
import com.parquet.backend.scribe.service.TagService;

import lombok.AllArgsConstructor;

/**
 * Class that maps and handles incoming requests to the application
 * that are related to tags.
 */
@RestController
@RequestMapping("/tags")
@AllArgsConstructor
public class TagController {

	private final TagService tagService;

	/**
	 * Add and create a new tag in the application.
	 */
	@PostMapping("")
	public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
		ResponseEntityWrapper<Tag> createdTag = new ResponseEntityWrapper<>(tagService.createTag(tag), HttpStatus.OK);
		return createdTag.getResponseEntity();
	}

	/**
	 * Get all tags
	 **/	
	@GetMapping("")
	public ResponseEntity<List<Tag>> getAllTags() {
		ResponseEntityWrapper<List<Tag>> tagList = new ResponseEntityWrapper<>(tagService.getAllTags(), HttpStatus.OK);
		return tagList.getResponseEntity();
	}
}
