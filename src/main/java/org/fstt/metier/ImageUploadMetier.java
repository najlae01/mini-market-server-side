package org.fstt.metier;


import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadMetier {
	public String uploadImage(MultipartFile file) throws Exception;
	
	
}