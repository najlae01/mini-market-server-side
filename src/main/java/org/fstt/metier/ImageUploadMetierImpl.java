package org.fstt.metier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadMetierImpl implements ImageUploadMetier{
	
	public static String uploadDirectory = System.getProperty("user.dir")+ "/src/main/resources/static/images/";
	
	@Override
	public String uploadImage(MultipartFile file) throws Exception{
		
		//Date date = new Date();
		//String filename = file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
		String filename = file.getOriginalFilename();
		System.out.println(file.getOriginalFilename());
		Path filenameAndPath = Paths.get(uploadDirectory, filename);
		try {
			Files.write(filenameAndPath, file.getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
	
}