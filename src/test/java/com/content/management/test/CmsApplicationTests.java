package com.content.management.test;

import com.content.management.model.BlogCommentsVo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.content.management.model.BlogVo;
import com.content.management.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsApplicationTests {
	
	@Autowired
	BlogService blogService;


	@Test
	public void findAll(){
		List<BlogVo> list=blogService.findAll();
		assertEquals(list.size(),0);
		
	}

	@Test
	public void findAllBlogFo() {
		BlogVo blogFo= blogService.findAllBlogVo(15);
		assertNull(blogFo);
	}
	
	 @Test(expected = Exception.class)
	public void  saveBlogComments() throws Exception{
		 BlogCommentsVo blogCommentsVo=new BlogCommentsVo();
		 blogCommentsVo.setBlogId(50);
		 blogCommentsVo.setUserName("test");
		 blogCommentsVo.setComment("test");
		 blogService.saveBlogComments(blogCommentsVo);
		
	}
	



}
