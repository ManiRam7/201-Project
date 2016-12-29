/**
 * 
 */
package com.content.management.controller;

import com.content.management.model.BlogCommentsVo;
import com.content.management.model.LoginVo;
import com.content.management.model.BlogVo;
import com.content.management.service.BlogService;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author M1029673
 *
 */
@Controller
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@RequestMapping(value = "/")
	public String loginPage(ModelMap model) {
		model.addAttribute("loginFo", new LoginVo());
		return "userSubmit";

	}

	

	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String userLogin(ModelMap model) {
		model.addAttribute("loginFo", new LoginVo());
		return "userSubmit";
	}

	@RequestMapping(value = "/viewBlog", method = RequestMethod.GET)
	public String viewBlog(Model model, @Valid @ModelAttribute LoginVo loginFo, BindingResult result,
			@RequestParam(value = "guestUserName", required = false) String guestUserName,
			@RequestParam(value = "blogId", defaultValue = "1", required = false) int blogId) {
		if (result.hasErrors()) {
			return "userSubmit";
		}
		BlogVo blogFo = blogService.findAllBlogVo(blogId);
			model.addAttribute("blogFo", blogFo);
			model.addAttribute("blogCommentsFo", new BlogCommentsVo());
			model.addAttribute("guestUserName", loginFo.getGuestUserName());
			if (blogFo != null) {
			model.addAttribute("blogId", blogFo.getBlogId());
		}
		return "viewblog";

	}

	@RequestMapping(value = "/saveBlogComments", method = RequestMethod.POST)
	public @ResponseBody List<BlogCommentsVo> saveBlogComments(@RequestBody BlogCommentsVo blogCommentsVo,
			HttpServletRequest request, HttpServletResponse response) {
		List<BlogCommentsVo>  blogCommentsVos=null;
		try{
		if(blogCommentsVo.getComment()!=null && !blogCommentsVo.getComment().isEmpty())
		blogService.saveBlogComments(blogCommentsVo);
		 blogCommentsVos=blogService.findAllBlogComments(blogCommentsVo.getBlogId());
		}
		catch(Exception ex){
			
		}
		return blogCommentsVos;

	}

	@RequestMapping(value = "/viewBlogForAdmin", method = RequestMethod.GET)
	public String viewBlogForAdmin(Model model, @ModelAttribute LoginVo loginFo,
			@RequestParam(value = "guestUserName", required = false) String guestUserName,
			@RequestParam(value = "blogId", required = false) int blogId) {
		BlogVo blogFo = blogService.findAllBlogVo(blogId);
		if (blogFo != null) {
			model.addAttribute("blogFo", blogFo);
			model.addAttribute("blogCommentsFo", new BlogCommentsVo());
			model.addAttribute("guestUserName", loginFo.getGuestUserName());
			model.addAttribute("blogId", blogFo.getBlogId());
		}
		return "viewblogadmin";

	}
}
