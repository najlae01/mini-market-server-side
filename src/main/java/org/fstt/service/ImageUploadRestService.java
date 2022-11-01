package org.fstt.service;

import org.fstt.metier.ImageUploadMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageUploadRestService {

	@Autowired
	private ImageUploadMetier imageUploadMetier;
	
	@RequestMapping(value= "/upload", method = RequestMethod.POST)
	public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception{
		return imageUploadMetier.uploadImage(file);
	}
}