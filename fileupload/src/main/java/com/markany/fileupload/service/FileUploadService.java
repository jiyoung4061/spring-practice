package com.markany.fileupload.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	public String restore(MultipartFile multipartFile) {
		String url = "";

		try {
			String originFilename = multipartFile.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf('.')+1); // ex. profile.20210107.jpg이면 마지막 .을 찾는다!
			String saveFilename = genSaveFilename(extName);
			Long fileSize = multipartFile.getSize();

			System.out.println("--->" + originFilename);
			System.out.println("--->" + saveFilename);
			System.out.println("--->" + fileSize);

			byte[] fileData = multipartFile.getBytes();
			 
			
		} catch (IOException e) {
			throw new RuntimeException("file upload error:"+ e);
		}

		return url;
	}

	private String genSaveFilename(String extName) {
		String filename = "";
		
		
		filename += ("."+extName);
		return filename;
	}

}
