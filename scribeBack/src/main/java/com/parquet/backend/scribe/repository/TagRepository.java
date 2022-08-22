package com.parquet.backend.scribe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.parquet.backend.scribe.model.Tag;

/**
 * Execute queries against tag table in sqlite
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

	@Query("SELECT * FROM file_tags WHERE file_id = :fileId")
	public List<Tag> findAllByFileId(@Param("fileId") long fileId);

}