package com.parquet.backend.scribe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parquet.backend.scribe.model.File;
import com.parquet.backend.scribe.model.Tag;
import com.parquet.backend.scribe.repository.TagRepository;

import lombok.AllArgsConstructor;

/**
 * Service class that handles the business logic related to
 * tag objects.
 */
@Service
@AllArgsConstructor
public class TagService {
	
	private final TagRepository tagRepository;

	/**
	 * Gets a list of tags associated to a particular file
	 * @param file
	 * 	The file for which we need to search for tags for
	 * @return
	 * 	The list of tags associated to the file
	 */
	public List<Tag> getTagsForFile(File file) {
		return tagRepository.findAllTagsByFileId(file.getId());
	}

	/**
	 * Create a new tag object
	 * @return
	 * 	The newly created tag object
	 */
	public Tag createTag(Tag tag) {
		return tagRepository.save(tag);
	}

	/**
	 * Updates a tag for a particular configuration
	 * 
	 * @return
	 * 	True if we succesfully updated our tag or false otherwise
	 */
	public boolean updateTag(Tag tag) {
		if (tagRepository.existsById(tag.getId())) {
			tagRepository.save(tag);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deletes a tag permanently and its internal configuration
	 * 
	 * @return
	 * 	True if we succesfully deleted our tag or false otherwise
	 */
	public boolean deleteTag(Tag tag) {
		if (tagRepository.existsById(tag.getId())) {
			tagRepository.delete(tag);
			return true;
		} else {
			return false;
		}
	}

}

