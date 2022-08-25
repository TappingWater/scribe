package com.parquet.backend.scribe.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a profile object.
 * Scribe can have multiple profiles per application.
 * Profiles have a name and password and configurations 
 * for the views are attached to a  profile. 
 */
@Entity
@Table(name="profiles")
@Getter
@Setter
@ToString
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "profile_name", nullable = false, unique = true)	
    	private String profileName;

	@CreationTimestamp
    	@Column(name = "created_at", nullable = false)
    	private Date createdAt;

	@OneToMany(mappedBy =  "profile", fetch = FetchType.LAZY, orphanRemoval = true,
		cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Folder> folders;
}
