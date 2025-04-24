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

import com.example.nikhilbharatV3.model.TypAnyThingAndamanAndNicobarIslands;
import com.example.nikhilbharatV3.service.TypAnyThingAndamanAndNicobarIslandsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@Controller
public class TypAnyThingControllerAndamanAndNicobarIslands {
	
	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private TypAnyThingAndamanAndNicobarIslandsService imageGalleryService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("typAnyThingAndamanAndNicobar")
	public String typAnyThingAndamanAndNicobar() {
		return "typAnyThingAndamanAndNicobar";
	}


	
	@PostMapping("/typAnyThing/saveImageDetailsAndamanAndNicobarIslands")
	public @ResponseBody ResponseEntity<?> createTypAnyThingAndamanAndNicobarIslands(@RequestParam("name") String name,@RequestParam("typ") String typ,
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
			TypAnyThingAndamanAndNicobarIslands imageGallery = new TypAnyThingAndamanAndNicobarIslands();
			imageGallery.setName(names[0]);
			imageGallery.setImage(imageData);
			imageGallery.setTyp(typ);
			imageGallery.setCreateDate(createDate);
			imageGalleryService.saveTypAnyThingAndamanAndNicobarIslands(imageGallery);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>(" Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/typAnyThing/displayAndamanAndNicobarIslands/{id}")
	@ResponseBody
	void showImageAndamanAndNicobarIslands(@PathVariable("id") Long id, HttpServletResponse response, Optional<TypAnyThingAndamanAndNicobarIslands> imageGallery)
			throws ServletException, IOException {
		log.info("Id :: " + id);
		imageGallery = imageGalleryService.getImageById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//		response.setContentType("image/jpeg");
		response.getOutputStream().write(imageGallery.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/typAnyThing/imageDetailsAndamanAndNicobarIslands")
	String showProductDetailsAndamanAndNicobarIslands(@RequestParam("id") Long id, Optional<TypAnyThingAndamanAndNicobarIslands> imageGallery, Model model) {
		try {
			log.info("Id :: " + id);
			if (id != 0) {
				imageGallery = imageGalleryService.getImageById(id);
			
				log.info("products :: " + imageGallery);
				if (imageGallery.isPresent()) {
					model.addAttribute("id", imageGallery.get().getId());
					model.addAttribute("name", imageGallery.get().getName());
					model.addAttribute("typ", imageGallery.get().getTyp()); 

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

	@GetMapping("/typAnyThingAndamanAndNicobarIslands/show")
	String typAnyThingShow(Model map) {
		List<TypAnyThingAndamanAndNicobarIslands> images = imageGalleryService.getAllActiveImages();
		map.addAttribute("images", images);
		return "typAnyThingAndamanAndNicobar";
	}
	
	
	@GetMapping("/typAnyThingAndamanAndNicobarIslandsJoblist/show")
	String typAnyThingShowJolisg(Model map) {
		List<TypAnyThingAndamanAndNicobarIslands> images = imageGalleryService.getAllActiveImages();
		map.addAttribute("images", images);
		return "joblistAndamanAndNicobarIslands";
	}
	

	
	@RequestMapping("/editAndamanAndNicobarIslands/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("typAnyThingEdit");
		
		TypAnyThingAndamanAndNicobarIslands images = imageGalleryService.get(id);
		mav.addObject("images", images);
		
		return mav;
	}	
	
	
	
	@GetMapping("/joblistAndamanAndNicobarIslands")
	String joblistAndamanAndNicobarIslands(Model map) {
		List<TypAnyThingAndamanAndNicobarIslands> images = imageGalleryService.getAllActiveImages();
		map.addAttribute("images", images);
		return "joblistAndamanAndNicobarIslands";
	}
	
//	
//	@GetMapping("/joblist")
//	String joblistShow(Model map) {
//		List<TypAnyThing> images = imageGalleryService.getAllActiveImages();
//		map.addAttribute("images", images);
//		return "joblist";
//	}
//	
	@GetMapping("/an")
	String adminShow(Model map) {
		List<TypAnyThingAndamanAndNicobarIslands> images = imageGalleryService.getAllActiveImages();
		map.addAttribute("images", images);
		return "an";
	}
	
	
	@RequestMapping("/deleteAndamanAndNicobarIslands/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		imageGalleryService.delete(id);
		
		return "redirect:/joblistAndamanAndNicobarIslands";
	}
	
	

	

}	

