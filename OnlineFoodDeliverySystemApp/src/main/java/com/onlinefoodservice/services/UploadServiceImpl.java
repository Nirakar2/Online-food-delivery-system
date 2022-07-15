package com.onlinefoodservice.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService{

	@Override
	public void uploadImages(MultipartFile[] images) {
		
		File uploadDir = new File(UPLOAD_DIR);		
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		
		// prepare upload Files
		for(MultipartFile img : images) {
			

		try {
            Path copyLocation = Paths
                .get(UPLOAD_DIR + File.separator
                		+ StringUtils.cleanPath(img.getOriginalFilename()));
            Files.copy(img.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();

        }
		}		
	}
}
