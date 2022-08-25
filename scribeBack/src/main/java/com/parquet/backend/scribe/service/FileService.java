package com.parquet.backend.scribe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parquet.backend.scribe.model.File;
import com.parquet.backend.scribe.model.Folder;
import com.parquet.backend.scribe.repository.FileRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service class that handles business logic related to file objects stored 
 * in this application.
 */
@Service
@RequiredArgsConstructor
public class FileService {
	
	private final FileRepository fileRepository;

	/**
	 * Gets a list of files for a particular folder
	 */
	public List<File> getFilesForFolder(long folderId) {
		return fileRepository.findAllByFolderId(folderId);
	}

	/**
	 * Create a new file permanently and add it to the configuration
	 * for a particular profile
	 * @return
	 * 	the newly created file
	 */
	
	public File createNewFile(File file) {
		return fileRepository.save(file);
	}

	/**
	 * Updates a file for a particular configuration
	 * 
	 * @return
	 * 	True if we successfully updated our file or false otherwise
	 */
	public boolean updateFile(File file) {
		if (fileRepository.existsById(file.getId())) {
			fileRepository.save(file);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deletes a file permanently and its internal configuration
	 * 
	 * @return
	 * 	True if we successfully deleted our file or false otherwise
	 */
	public boolean deleteFile(File file) {
		if (fileRepository.existsById(file.getId())) {
			fileRepository.delete(file);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Associates a particular tag to a file
	 */
	public boolean addTagToFile(long fileId, long tagId) {
		fileRepository.addTagToFile(fileId, tagId);
		return true;
	}

}
