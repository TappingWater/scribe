package com.parquet.backend.scribe.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a folder that get scanned for files.
 * Folders will have a label that gets assigned by profile.
 */
@Entity
@Table(name="folders")
@Getter
@Setter
@ToString
public class Folder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
   	@JoinColumn(name = "profile_id", nullable = false)
	private Profile profile;

	@Column(name="label", nullable=false)
	private String label;

	@Column(name="path", nullable=false)
	private String path;

	@OneToMany(mappedBy="folder", fetch=FetchType.LAZY, 
		cascade=CascadeType.ALL) 
	private Set<File> files;
}
