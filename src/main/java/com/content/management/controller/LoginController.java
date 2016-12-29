/**
 * 
 */
package com.content.management.controller;

import com.content.management.model.BlogVo;
import com.content.management.service.BlogService;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author M1029673
 *
 */
@Controller
@RequestMapping("/secure")
public class LoginController {

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/home")
	public String homePage(ModelMap model) {
		model.addAttribute("blogFo", new BlogVo());
		return "main";
	}

	@RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
	public String saveBlog(ModelMap model,@Valid @ModelAttribute("blogFo") BlogVo blogFo, BindingResult result) {
		// Get the uploaded files and store them
		MultipartFile file = blogFo.getFile();
		if (result.hasErrors()) {
			return "main";
		}
		else if(file.isEmpty()){
			model.addAttribute("nofile","Please Upload the file.");
			return "main";
		}
		else if(!file.getContentType().equals("image/jpeg") &&
				!file.getContentType().equals("image/png")){
			model.addAttribute("nofile","Please Upload the JPEG OR PNG file.");
			return "main";
		}


		if (null != file) {
			String fileName = file.getOriginalFilename();
			List<BlogVo> list = null;
			try {
				blogService.saveBlog(blogFo);
				list = blogService.findAll();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("blogFo", list);
			model.addAttribute("blogFo", new BlogVo());
		}
		model.addAttribute("msg", "Added Successfully");
		return "main";

	}

}
