package com.pivotal.q1.model;

// Generated Oct 13, 2014 2:28:43 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Song generated by hbm2java
 */
@Entity
@Table(name = "song", catalog = "rmcdb", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Song implements java.io.Serializable {

	private Integer id;
	@Size(min=5)
	private String name;
	@Min(10)
	private int duration;
	private Set<Album> albums = new HashSet<Album>(0);

	public Song() {
	}

	public Song(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}

	public Song(String name, int duration, Set<Album> albums) {
		this.name = name;
		this.duration = duration;
		this.albums = albums;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "duration", nullable = false)
	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "album_song", catalog = "rmcdb", joinColumns = { @JoinColumn(name = "songId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "albumId", nullable = false, updatable = false) })
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}
