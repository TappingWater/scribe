package com.parquet.backend.scribe.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A tag is a string label that can be attached to a file for querying
 * purposes. Tags and Files in this application have a many to many relationship
 * with one another
 */
@Entity
@Table(name="tags")
@Getter
@Setter
@ToString
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="tag_name", nullable=false)
	private String name;	

	@ManyToMany
	private Set<File> files;
}
