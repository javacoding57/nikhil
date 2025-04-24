package com.example.nikhilbharatV3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nikhilbharatV3.model.Video;
import com.example.nikhilbharatV3.repository.VideoRepository;


@Service
public class VideoService {

	 @Autowired
	    private VideoRepository videoRepository;

	    public void saveVideo(String title, byte[] content) {
	        Video video = new Video();
	        video.setTitle(title);
	        video.setContent(content);
	        videoRepository.save(video);
	    }

	    public List<Video> getAllVideos() {
	        return videoRepository.findAll();
	    }

	    public Video getVideo(Long id) {
	        return videoRepository.findById(id).orElse(null);
	    }
	
}
