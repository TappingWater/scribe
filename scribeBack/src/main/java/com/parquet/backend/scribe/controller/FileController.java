package com.parquet.backend.scribe.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.parquet.backend.scribe.controller.util.ResponseEntityWrapper;
import com.parquet.backend.scribe.model.File;
import com.parquet.backend.scribe.service.FileService;
import lombok.AllArgsConstructor;

/**
 * Class that maps and handles incoming requests to the application
 * that are related to files
 */
@RestController
@RequestMapping("/files")
@AllArgsConstructor
public class FileController {
	
	private final FileService fileService;

	/**
	 * Create and configure a new file for this file
	 * @param folderId
	 * 	Folder for which this file belongs to
	 */
	@PostMapping("")
	public ResponseEntity<File> createFile(@RequestBody File file) {
		ResponseEntityWrapper<File> fileRes = new ResponseEntityWrapper<>(fileService.createNewFile(file), HttpStatus.CREATED);
		return fileRes.getResponseEntity();
	}

	/**
	 * Get a list of files associated to a folder
	 */
	@GetMapping("/{id}")
	public ResponseEntity<List<File>> getAllFilesForFolder(@PathVariable("id") Long folderId) {
		ResponseEntityWrapper<List<File>> files = new ResponseEntityWrapper<>(fileService.getFilesForFolder(folderId), HttpStatus.OK);
		return files.getResponseEntity();
	}

	/**
	 * Add a tag to the file
	 */
	@PostMapping("/addTag")
	public ResponseEntity<Boolean> addTagToFile(@RequestParam("tagId") long tagId, @RequestParam("fileId") long fileId) {
		ResponseEntityWrapper<Boolean> addedTags = new ResponseEntityWrapper<>(fileService.addTagToFile(fileId, tagId), HttpStatus.OK);
		return addedTags.getResponseEntity();
	}
}
