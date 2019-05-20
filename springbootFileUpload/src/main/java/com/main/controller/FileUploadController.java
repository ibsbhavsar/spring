package com.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

	private static String UPLOAD_FOLDER = "D://Spring_STS";

	@GetMapping(path = "/")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile multipartFile,
			RedirectAttributes redirectAttributes) {
		if (multipartFile.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to Upload");
			return "redirect:uploadStatus";
		}
		try {
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + multipartFile.getOriginalFilename());
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("message", "Your file has successfully uploaded");
		} catch (IOException e) {
		}

		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";

	}
}
