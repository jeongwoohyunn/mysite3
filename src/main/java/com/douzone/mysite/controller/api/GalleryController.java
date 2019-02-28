package com.douzone.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.mysite.service.GalleryService;
import com.douzone.security.Auth;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	@Autowired
	private GalleryService galleryService;

	@RequestMapping("")
	public String index(Model model) {
		 //List list = galleryService.getGalleryList(multipartFile);
		// 리스트에 가져와서
		 //model.addAttribute("list", list);
		// 모델에 넣어줘
		return "gallery/index";
	}

	@Auth
	@RequestMapping("/upload")
	public String upload(@RequestParam(value = "upload-image") MultipartFile multipartFile, Model model) {
		String url = galleryService.restore(multipartFile);
		model.addAttribute("url", url);
		return "result";
	}
}
