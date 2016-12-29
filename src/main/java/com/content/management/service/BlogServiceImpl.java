/**
 * 
 */
package com.content.management.service;

import com.content.management.dao.BlogDao;
import com.content.management.model.BlogCommentsVo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.management.model.BlogVo;
import com.mindtree.cms.model.BlogComments;
import com.mindtree.cms.model.BlogContent;

/**
 * @author M1029673
 *
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDao blogDao;

	@Transactional
	public void saveBlog(BlogVo blogVo) throws IOException {
		BlogContent blogContent = new BlogContent();
		blogContent.setName(blogVo.getFile().getOriginalFilename());
		blogContent.setTittle(blogVo.getFile().getOriginalFilename().substring(0,
				blogVo.getFile().getOriginalFilename().indexOf(".")));
		blogContent.setContent(blogVo.getDescription());
		blogContent.setName(blogVo.getFile().getOriginalFilename());
		blogContent.setFile(blogVo.getFile().getBytes());
		blogContent.setUserName("test");
		blogContent.setType(blogVo.getFile().getContentType());
		blogDao.save(blogContent);

	}

	public List<BlogVo> findAll() {
		List<BlogVo> blogVos = new ArrayList();
		try {
			List<BlogContent> blogContents = blogDao.findAll();
			for (BlogContent blogContent : blogContents) {
				BlogVo blogVo = new BlogVo();
				blogVo.setTitle(blogContent.getTittle());
				blogVo.setDescription(blogContent.getContent());
				byte[] encodeBase64 = Base64.encodeBase64(blogContent.getFile());
				String imgBase64encoded = new String(encodeBase64, "UTF-8");
				blogVo.setImageSrc(imgBase64encoded);
				List<BlogCommentsVo> commentsVos = new ArrayList();
				for (BlogComments blogComments : blogContent.getBlogComments()) {
					BlogCommentsVo blogCommentsVo = new BlogCommentsVo();
					blogCommentsVo.setComment(blogComments.getComment());
					blogCommentsVo.setUserName(blogComments.getUserName());
					commentsVos.add(blogCommentsVo);
				}
				blogVo.setBlogCommentsVo(commentsVos);
				blogVos.add(blogVo);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return blogVos;
	}

        @Override
	public List<BlogCommentsVo> findAllBlogComments(int blogId) {
		List<BlogCommentsVo> commentsVos = new ArrayList();
		List<BlogVo> blogVos = new ArrayList();
		try {
			List<BlogComments> comments = blogDao.findAllBlogComments(blogId);

			for (BlogComments blogComments : comments) {
				BlogCommentsVo blogCommentsVo = new BlogCommentsVo();
				blogCommentsVo.setComment(blogComments.getComment());
				blogCommentsVo.setUserName(blogComments.getUserName());
				blogCommentsVo.setBlogId(blogComments.getBlogContent().getBlogId());
				commentsVos.add(blogCommentsVo);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return commentsVos;
	}

	@Transactional
	public void saveBlogComments(BlogVo blogVo) throws IOException {
		BlogContent blogContent = new BlogContent();
		blogContent.setName(blogVo.getFile().getOriginalFilename());
		blogContent.setTittle(blogVo.getFile().getOriginalFilename().substring(0,
				blogVo.getFile().getOriginalFilename().indexOf(".")));
		blogContent.setContent(blogVo.getComments());
		blogContent.setName(blogVo.getFile().getOriginalFilename());
		blogContent.setFile(blogVo.getFile().getBytes());
		blogContent.setUserName("test");
		blogContent.setType(blogVo.getFile().getContentType());
		blogDao.save(blogContent);

	}

	@Transactional
	public void saveBlogComments(BlogCommentsVo blogCommentsVo) throws Exception{
		BlogComments blogComments = new BlogComments();
		BlogContent blogContent=new BlogContent();
		blogContent.setBlogId(blogCommentsVo.getBlogId());
		blogComments.setBlogContent(blogContent);
		blogComments.setUserName(blogCommentsVo.getUserName());
		blogComments.setComment(blogCommentsVo.getComment());
		blogDao.saveBlogComments(blogComments);
	}

	public BlogVo findAllBlogVo(int blogId) {
		BlogVo blogVo = null;
		try {
			BlogContent comments = blogDao.findAllBlogContent(blogId);
			List<BlogContent> blogContents = blogDao.findAll();
			if (comments != null) {
				blogVo = new BlogVo();
				blogVo.setTitle(comments.getTittle());
				blogVo.setBlogId(comments.getBlogId());
				blogVo.setCount(blogContents.size());
				blogVo.setDescription(comments.getContent());
				byte[] encodeBase64 = Base64.encodeBase64(comments.getFile());
				String imgBase64encoded = new String(encodeBase64, "UTF-8");
				blogVo.setImageSrc(imgBase64encoded);
				List<BlogCommentsVo> commentsVos = new ArrayList<BlogCommentsVo>();
				for (BlogComments blogComments : comments.getBlogComments()) {
					BlogCommentsVo blogCommentsVo = new BlogCommentsVo();
					blogCommentsVo.setComment(blogComments.getComment());
					blogCommentsVo.setUserName(blogComments.getUserName());
					blogCommentsVo.setBlogId(comments.getBlogId());
					commentsVos.add(blogCommentsVo);
					blogVo.setBlogCommentsVo(commentsVos);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return blogVo;
	}

	
}
