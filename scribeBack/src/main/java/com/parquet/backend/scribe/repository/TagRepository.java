package com.parquet.backend.scribe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parquet.backend.scribe.model.File;
import com.parquet.backend.scribe.model.Tag;

/**
 * Execute queries against tag table in sqlite
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

	@Query("SELECT t FROM File f join f.tags t WHERE f.id = :fileId")
	public List<Tag> findAllTagsByFileId(@Param("fileId") long fileId);

	@Query("Select f FROM File f join f.tags t where t.id = :tagId")
	public List<File> findAllFilesByTagId(@Param("tagId") long tagId);

}