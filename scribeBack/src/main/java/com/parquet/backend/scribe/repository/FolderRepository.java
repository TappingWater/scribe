package com.parquet.backend.scribe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.parquet.backend.scribe.model.Folder;

/**
 * Execute queries against folder table in sqlite
 */
@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

	@Query("SELECT * FROM folders f WHERE f.profile_id = :profileId")
	public List<Folder> findAllByProfile(@Param("profileId") long profileId);
	
}