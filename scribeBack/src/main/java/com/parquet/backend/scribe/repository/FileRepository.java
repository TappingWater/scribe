package com.parquet.backend.scribe.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.parquet.backend.scribe.model.File;

/**
 * Execute queries against file table in sqlite
 */
@Repository
public interface FileRepository extends JpaRepository<File, Long> {

	@Query("select f from File f WHERE f.folder.id = :folderId")
	public List<File> findAllByFolderId(@Param("folderId") long folderId);
	
}