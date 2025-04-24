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

import com.example.nikhilbharatV3.model.Bihar;
import com.example.nikhilbharatV3.service.BiharService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@Controller
public class TypAnyThingControllerBihar {
	
	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private BiharService biharService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("typAnyThingBihar")
	public String typAnyThingBihar() {
		return "typAnyThingBihar";
	}


	
	@PostMapping("/bihar/saveImageDetails")
	public @ResponseBody ResponseEntity<?> createTypAnyThingBihar(@RequestParam("name") String name,@RequestParam("typ") String typ,
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
			Bihar imageGalleryBihar = new Bihar();
			imageGalleryBihar.setName(names[0]);
			imageGalleryBihar.setImage(imageData);
			imageGalleryBihar.setTyp(typ);
			imageGalleryBihar.setCreateDate(createDate);
			biharService.saveBihar(imageGalleryBihar);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>(" Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/typAnyThing/displayBihar/{id}")
	@ResponseBody
	void showImageBihar(@PathVariable("id") Long id, HttpServletResponse response, Optional<Bihar> imageGalleryBihar)
			throws ServletException, IOException {
		log.info("Id :: " + id);
		imageGalleryBihar = biharService.getImageByIdBihar(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//		response.setContentType("image/jpeg");
		response.getOutputStream().write(imageGalleryBihar.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/typAnyThing/imageDetailsBihar")
	String showProductDetailsBihar(@RequestParam("id") Long id, Optional<Bihar> imageGalleryBihar, Model model) {
		try {
			log.info("Id :: " + id);
			if (id != 0) {
				imageGalleryBihar = biharService.getImageByIdBihar(id);
			
				log.info("products :: " + imageGalleryBihar);
				if (imageGalleryBihar.isPresent()) {
					model.addAttribute("id", imageGalleryBihar.get().getId());
					model.addAttribute("name", imageGalleryBihar.get().getName());
					model.addAttribute("typ", imageGalleryBihar.get().getTyp()); 

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

	@GetMapping("/typAnyThingBihar/show")
	String typAnyThingShowBihar(Model map) {
		List<Bihar> images = biharService.getAllActiveImagesBihar();
		map.addAttribute("images", images);
		return "typAnyThingBihar";
	}
	
	
	@GetMapping("/typAnyThingBiharJoblist/show")
	String typAnyThingShowJolisgBihar(Model map) {
		List<Bihar> images = biharService.getAllActiveImagesBihar();
		map.addAttribute("images", images);
		return "joblistBihar";
	}
	

	
	@RequestMapping("/editBihar/{id}")
	public ModelAndView showEditProductFormBihar(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("typAnyThingEdit");
		
		Bihar images = biharService.getBihar(id);
		mav.addObject("images", images);
		
		return mav;
	}	
	
	
	
	@GetMapping("/joblistBihar")
	String joblistAndamanAndNicobarIslands(Model map) {
		List<Bihar> images = biharService.getAllActiveImagesBihar();
		map.addAttribute("images", images);
		return "joblistBihar";
	}
	
//	
//	@GetMapping("/joblist")
//	String joblistShow(Model map) {
//		List<TypAnyThing> images = imageGalleryService.getAllActiveImages();
//		map.addAttribute("images", images);
//		return "joblist";
//	}
//	
	@GetMapping("/bihar")
	String adminShow(Model map) {
		List<Bihar> images = biharService.getAllActiveImagesBihar();
		map.addAttribute("images", images);
		return "bihar";
	}
	
	
	@RequestMapping("/deleteBihar/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		biharService.deleteBihar(id);
		
		return "redirect:/joblistBihar";
	}
	
	

	

}	

