/**
 * 
 */
package com.mindtree.cms.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author M1030563
 *
 */
@Entity
@Table(name = "BLOG")
public class BlogContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_id")
	private int blogId;

	@Column(name = "title")
	private String tittle;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "type", length = 100, nullable = false)
	private String type;

	@Lob
	@Column(name = "CONTENT", length = 512)
	private String content;

	@Lob
	@Column(name = "FILEIMAGE", length = 100000)
	private byte[] file;

	@Column(name = "user_name")
	private String userName;

	@OneToMany(mappedBy = "blogContent")
	private List<BlogComments> blogComments;

	public BlogContent() {
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public List<BlogComments> getBlogComments() {
		return blogComments;
	}

	public void setBlogComments(List<BlogComments> blogComments) {
		this.blogComments = blogComments;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}