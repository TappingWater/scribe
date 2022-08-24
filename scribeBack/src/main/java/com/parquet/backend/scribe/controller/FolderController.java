package com.parquet.backend.scribe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.parquet.backend.scribe.controller.util.ResponseEntityWrapper;
import com.parquet.backend.scribe.model.Folder;
import com.parquet.backend.scribe.service.FolderService;
import lombok.AllArgsConstructor;

/**
 * Class that maps and handles incoming requests to the application
 * that are related to folders.
 */
@RestController
@RequestMapping("/folders")
@AllArgsConstructor
public class FolderController {
	
	private final FolderService folderService;

	/**
	 * Get a list of folders associated to a profile
	 */
	@GetMapping("/{id}")
	public ResponseEntity<List<Folder>> getAllFolders(@PathVariable("id") String profileId) {
		ResponseEntityWrapper<List<Folder>> folders = new ResponseEntityWrapper<>(folderService.getAllFoldersForProfile(profileId), HttpStatus.OK);
		return folders.getResponseEntity();
	}

	/**
	 * Create and configure a new folder for a particular profile within the application
	 * 
	 * @RequestBody folder
	 * 	Folder to create passed in the request body
	 */
	@PostMapping("")
	public ResponseEntity<Folder> createNewFolder(@RequestBody Folder folder) {
		Folder newFolder = folderService.createNewFolder(folder);
		if (newFolder == null) {
			ResponseEntityWrapper<Folder> errorWrapper = new ResponseEntityWrapper<Folder>(null, HttpStatus.BAD_REQUEST);
			return errorWrapper.getResponseEntity();
		} else {
			ResponseEntityWrapper<Folder> createdWrapper = new ResponseEntityWrapper<Folder>(newFolder, HttpStatus.CREATED);
			return createdWrapper.getResponseEntity();
		}
	}

	/**
	 * Deletes a configured folder which cascades to all files within that particular folder
	 * as well as associated tags
	 */
	@DeleteMapping()
	public ResponseEntity<Boolean> deleteProfile(@PathVariable("id") long id) {
		boolean deleted = folderService.deleteFolder(id);
		if (deleted) {
			ResponseEntityWrapper<Boolean> deletedWrapper = new ResponseEntityWrapper<Boolean>(deleted, HttpStatus.OK);
			return deletedWrapper.getResponseEntity();
		} else {
			ResponseEntityWrapper<Boolean> deletedWrapper = new ResponseEntityWrapper<Boolean>(deleted, HttpStatus.BAD_REQUEST);
			return deletedWrapper.getResponseEntity();
		}
	}


}
