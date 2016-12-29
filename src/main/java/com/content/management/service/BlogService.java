/**
 * 
 */
package com.content.management.service;

import com.content.management.model.BlogCommentsVo;
import java.io.IOException;
import java.util.List;

import com.content.management.model.BlogVo;

/**
 * @author M1029673
 *
 */
public interface BlogService {
	public void saveBlog(BlogVo blogFo) throws IOException;

	public List<BlogVo> findAll();

	public List<BlogCommentsVo> findAllBlogComments(int blogId);

	public void saveBlogComments(BlogCommentsVo blogCommentsVo) throws Exception;

	public BlogVo findAllBlogVo(int blogId);
	
	

}
