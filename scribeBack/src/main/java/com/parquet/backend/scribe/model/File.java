package com.parquet.backend.scribe.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A file represents a file on the host. It contains various properties
 * that can be configured such as tags. It has a many to many relationship
 * with tags.
 */
@Entity
@Table(name="files")
@Getter
@Setter
@ToString
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="file_name", nullable=false)
	private String name;	

	@Column(name="file_path", nullable=false)
	private String path;

	@Column(name="file_type", nullable=false)
	private String type;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="folder_id", nullable = false)
	private Folder folder;	

	@ManyToMany
	@JoinTable(
		name = "file_tags",
		joinColumns = @JoinColumn(name="file_id"),
		inverseJoinColumns = @JoinColumn(name="tag_id")
	)
	private Set<Tag> tags;
}
