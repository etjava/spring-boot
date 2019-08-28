package com.etjava.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * spring boot 文件上传
 * @author asus
 *
 */
@RestController
public class FileUploadController {

	@RequestMapping("/fileUploadConteoller")
	public Map<String,Object> fileUpload(MultipartFile myfile) throws Exception {
		System.out.println(myfile.getOriginalFilename());
		myfile.transferTo(new File("d:/"+myfile.getOriginalFilename()));
		Map<String,Object> map = new HashMap<>();
		map.put("filename", myfile.getOriginalFilename());
		map.put("filepath", "d:/"+myfile.getOriginalFilename());
		return map;
	}
}
