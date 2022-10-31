package org.fstt.metier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadMetier {
	public String uploadImage(MultipartFile file) throws Exception;
	
	
}
