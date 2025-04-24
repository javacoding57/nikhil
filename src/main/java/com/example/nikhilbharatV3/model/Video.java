package com.example.nikhilbharatV3.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="video")
public class Video {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//	@Column(name="title")
    private String title;

    @Lob
    @Column(name = "content", length = Integer.MAX_VALUE, nullable = true)
    private byte[] content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", content=" + Arrays.toString(content) + "]";
	}

    // Getters and Setters
    
    
}
