package com.example.nikhilbharatV3.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.nikhilbharatV3.model.MP;
import com.example.nikhilbharatV3.service.MadhyaPradeshService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@Controller
public class TypAnyThingControllerMadhyaPradesh {
	
	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private MadhyaPradeshService madhyaPradeshService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/typAnyThingMadhyaPradesh/show")
	private String typAnyThingMadhyaPradesh(Model map) {
		List<MP> imagesAandN = madhyaPradeshService.getAllActiveImagesMadhyaPradesh();
		map.addAttribute("images", imagesAandN);
		return "joblistMadhyaPradesh";
	}
	
	
	@GetMapping("/typAnyThingMadhyaPradesh")
	private String typAnyThingMadhyaPradesh2(Model map) {
		List<MP> imagesAandN = madhyaPradeshService.getAllActiveImagesMadhyaPradesh();
		map.addAttribute("images", imagesAandN);
		return "typAnyThingMadhyaPradesh";
	}
	
	@GetMapping("/joblistMadhyaPradesh")
	private String joblistMadhyaPradesh(Model map) {
		List<MP> imagesAandN = madhyaPradeshService.getAllActiveImagesMadhyaPradesh();
		map.addAttribute("images", imagesAandN);
		return "joblistMadhyaPradesh";
	}

	@RequestMapping("/mp")
	private  String madhyaPradesh(Model map) {
		List<MP> images = madhyaPradeshService.getAllActiveImagesMadhyaPradesh();
		map.addAttribute("images", images);
		return "mp";
	}


	
	@PostMapping("/mp/saveImageDetails")
	private @ResponseBody ResponseEntity<?> createTypAnyThingMadhyaPradesh(@RequestParam("name") String name,@RequestParam("typ") String typ,
			 Model model, HttpServletRequest request
			,final @RequestParam("image") MultipartFile file) {
		try {
			//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			log.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			log.info("FileName: " + file.getOriginalFilename());
			if (fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			String[] names = name.split(",");
/*			String[] descriptions = description.split(","); */
			Date createDate = new Date();
			log.info("Name: " + names[0]+" "+filePath);
	/*		log.info("description: " + descriptions[0]); */

	/*		log.info("price: " + price); */
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			MP imageGalleryAandN = new MP();
			imageGalleryAandN.setName(names[0]);
			imageGalleryAandN.setImage(imageData);
			imageGalleryAandN.setTyp(typ);
			imageGalleryAandN.setCreateDate(createDate);
			madhyaPradeshService.saveMadhyaPradesh(imageGalleryAandN);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>(" Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/typAnyThingMadhyaPradesh/display/{id}")
	@ResponseBody
	private void showImageMadhyaPradesh(@PathVariable("id") Long id, HttpServletResponse response, Optional<MP> imageGalleryAandN)
			throws ServletException, IOException {
		log.info("Id :: " + id);
		imageGalleryAandN = madhyaPradeshService.getImageByIdMadhyaPradesh(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//		response.setContentType("image/jpeg");
		response.getOutputStream().write(imageGalleryAandN.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/typAnyThing/imageDetailsMadhyaPradesh")
	private  String showProductDetailsMadhyaPradesh(@RequestParam("id") Long id, Optional<MP> imageGalleryAandN, Model model) {
		try {
			log.info("Id :: " + id);
			if (id != 0) {
				imageGalleryAandN = madhyaPradeshService.getImageByIdMadhyaPradesh(id);
			
				log.info("products :: " + imageGalleryAandN);
				if (imageGalleryAandN.isPresent()) {
					model.addAttribute("id", imageGalleryAandN.get().getId());
					model.addAttribute("name", imageGalleryAandN.get().getName());
					model.addAttribute("typ", imageGalleryAandN.get().getTyp()); 

					return "imagedetails";
				}
				return "redirect:/icard";
			}
		return "redirect:/icard";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/icard";
		}	
	}

	
	@RequestMapping("/deleteMadhyaPradesh/{id}")
	private  String deleteProductMadhyaPradesh(@PathVariable(name = "id") Long id) {
		madhyaPradeshService.deleteMadhyaPradesh(id);
		
		return "redirect:/joblistMadhyaPradesh";
	}
	
	
	



}	

