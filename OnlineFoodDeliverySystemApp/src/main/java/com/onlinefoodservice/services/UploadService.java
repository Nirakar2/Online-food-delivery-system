package com.onlinefoodservice.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	
	public static final String UPLOAD_DIR = "//users//stim//desktop//images_uploads";
	
	
	public void uploadImages(MultipartFile[] images);
	
	

}
