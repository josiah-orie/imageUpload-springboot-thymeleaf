package com.jovine360.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jovine360.entity.FileData;
import com.jovine360.repositories.FileDataRepository;

@Service
public class FileDataService {

	@Autowired
	private FileDataRepository fileDataRepository;

	public String uploadImageToSystem(MultipartFile multipartFile) throws IOException {
		String file_path = "/Users/josiah/Desktop/imagefiles/" + multipartFile.getOriginalFilename();
		String filedir = "/Users/josiah/Desktop/imagefiles/";

		FileData saveInput = FileData.builder().name(multipartFile.getOriginalFilename())
				.type(multipartFile.getContentType()).filepath(file_path).build();

		Path uploadPath = Paths.get(filedir);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		InputStream inputStream = multipartFile.getInputStream();
		Path filePath = uploadPath.resolve(multipartFile.getOriginalFilename());
		Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//		multipartFile.transferTo(new File(filepath)); // another option if you don't want to use the inputStream object

		FileData fileData = fileDataRepository.save(saveInput);

		if (fileData != null) {
			return "image uploaded successfully";
		}
		return null;
	}
}
