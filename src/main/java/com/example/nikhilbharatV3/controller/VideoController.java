package com.example.nikhilbharatV3.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.nikhilbharatV3.model.Video;

import jakarta.servlet.http.HttpServletResponse;
//import reactor.core.publisher.Mono;


//import reactor.core.publisher.Mono;


@Controller
public class VideoController {
	
    @Autowired
    private com.example.nikhilbharatV3.service.StreamingService service;


//    @GetMapping(value = "videos/{title}", produces = "video/mp4")
//    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
//        System.out.println("range in bytes() : " + range);
//        return service.getVideo(title);
//    }
//    
//	@GetMapping("/indexVideoUpload")
//	public String indexVideoUpload() {
//		return "indexVideoUpload";
//	}
	
	
	@Autowired
    private com.example.nikhilbharatV3.service.VideoService videoService;

    @GetMapping("/indexVideoUpload")
    public String listVideos(Model model) {
        model.addAttribute("videos", videoService.getAllVideos());
        return "indexVideoUpload";
    }

    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("title") String title, @RequestParam("file") MultipartFile file) throws IOException {
        videoService.saveVideo(title, file.getBytes());
        return "redirect:/indexVideoUpload";
    }

    @GetMapping("/video/{id}")
    public void playVideo(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Video video = videoService.getVideo(id);
        if (video != null) {
            response.setContentType("video/mp4");
            response.getOutputStream().write(video.getContent());
        }
    }

}
