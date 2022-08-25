package com.parquet.backend.scribe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parquet.backend.scribe.model.Folder;
import com.parquet.backend.scribe.repository.FolderRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service class that is used to handle the business logic related to
 * folder objects within this application.
 */
@Service
@RequiredArgsConstructor
public class FolderService {
	
	private final FolderRepository folderRepository;

	/**
	 * Get all the folders within the application for a profile.
	 * @return
	 * 	The list of all folders within the application for a particular
	 * profile.
	 */
	public List<Folder> getAllFoldersForProfile(Long profileId) {
		return folderRepository.findAllByProfile(profileId);
	}

	/**
	 * Create a new folder permanently and add it to the configuration
	 * for a particular profile
	 * @return
	 * 	the newly created folder
	 */
	
	public Folder createNewFolder(Folder folder) {
		return folderRepository.save(folder);
	}

	/**
	 * Updates a folder for a particular profile and its configuration
	 * 
	 * @return
	 * 	True if we successfully updated our folder or false otherwise
	 */
	public boolean updateFolder(Folder folder) {
		if (folderRepository.existsById(folder.getId())) {
			folderRepository.save(folder);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deletes a folder permanently and its internal configuration
	 * 
	 * @return
	 * 	True if we successfully deleted our folder or false otherwise
	 */
	public boolean deleteFolder(long folderId) {
		if (folderRepository.existsById(folderId)) {
			folderRepository.deleteById(folderId);
			return true;
		} else {
			return false;
		}
	}

}
