package org.fstt.metier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadMetierImpl implements ImageUploadMetier{
	
	
	@Override
	public String uploadImage(MultipartFile file) throws Exception{
		
		String imageDirectory = new ClassPathResource("static/images/").getFile().getAbsolutePath();
		Files.copy(file.getInputStream(), 
				Paths.get(imageDirectory+File.separator+file.getOriginalFilename()), 
				StandardCopyOption.REPLACE_EXISTING);
		return "File uploaded";
	}
	
}
