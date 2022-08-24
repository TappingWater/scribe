package com.parquet.backend.scribe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.parquet.backend.scribe.model.Profile;

/**
 * Execute queries against profile table in sqlite
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {}