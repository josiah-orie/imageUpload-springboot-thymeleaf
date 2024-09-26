package com.jovine360.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jovine360.entity.FileData;
import com.jovine360.service.FileDataService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FileDataController {

	@Autowired
	private FileDataService fileDataService;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@PostMapping("/imageupload")
	public String getMethodName(@ModelAttribute("filedata") FileData fileData,
			@RequestParam("image") MultipartFile multipartFile, Model model, HttpServletRequest request)
			throws IOException {

		String status = fileDataService.uploadImageToSystem(multipartFile);
		if (status == null) {
			status = "image upload failed.";
		}

		model.addAttribute("status", status);
		return "index";
	}

}
