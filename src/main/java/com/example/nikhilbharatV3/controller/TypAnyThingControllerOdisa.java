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

import com.example.nikhilbharatV3.model.Odisa;
import com.example.nikhilbharatV3.service.OdisaService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@Controller
public class TypAnyThingControllerOdisa {
	
	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private OdisaService odisaService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/typAnyThingOdisa/show")
	private String typAnyThingOdisa(Model map) {
		List<Odisa> imagesAandN = odisaService.getAllActiveImagesOdisa();
		map.addAttribute("images", imagesAandN);
		return "joblistOdisa";
	}
	
	
	@GetMapping("/typAnyThingOdisa")
	private String typAnyThingOdisa2(Model map) {
		List<Odisa> imagesAandN = odisaService.getAllActiveImagesOdisa();
		map.addAttribute("images", imagesAandN);
		return "typAnyThingOdisa";
	}
	
	@GetMapping("/joblistOdisa")
	private String joblistOdisa(Model map) {
		List<Odisa> imagesAandN = odisaService.getAllActiveImagesOdisa();
		map.addAttribute("images", imagesAandN);
		return "joblistOdisa";
	}

	@RequestMapping("/od")
	private  String odisa(Model map) {
		List<Odisa> images = odisaService.getAllActiveImagesOdisa();
		map.addAttribute("images", images);
		return "od";
	}


	
	@PostMapping("/odisa/saveImageDetails")
	private @ResponseBody ResponseEntity<?> createTypAnyThingOdisa(@RequestParam("name") String name,@RequestParam("typ") String typ,
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
			Odisa imageGalleryAandN = new Odisa();
			imageGalleryAandN.setName(names[0]);
			imageGalleryAandN.setImage(imageData);
			imageGalleryAandN.setTyp(typ);
			imageGalleryAandN.setCreateDate(createDate);
			odisaService.saveOdisa(imageGalleryAandN);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>(" Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/typAnyThingOdisa/display/{id}")
	@ResponseBody
	private void showImageOdisa(@PathVariable("id") Long id, HttpServletResponse response, Optional<Odisa> imageGalleryAandN)
			throws ServletException, IOException {
		log.info("Id :: " + id);
		imageGalleryAandN = odisaService.getImageByIdOdisa(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//		response.setContentType("image/jpeg");
		response.getOutputStream().write(imageGalleryAandN.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/typAnyThing/imageDetailsOdisa")
	private  String showProductDetailsOdisa(@RequestParam("id") Long id, Optional<Odisa> imageGalleryAandN, Model model) {
		try {
			log.info("Id :: " + id);
			if (id != 0) {
				imageGalleryAandN = odisaService.getImageByIdOdisa(id);
			
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

	
	@RequestMapping("/deleteOdisa/{id}")
	private  String deleteProductOdisa(@PathVariable(name = "id") Long id) {
		odisaService.deleteOdisa(id);
		
		return "redirect:/joblistOdisa";
	}
	
	
	



}	

