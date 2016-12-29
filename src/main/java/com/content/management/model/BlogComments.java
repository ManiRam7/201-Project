/**
 * 
 */
package com.mindtree.cms.model;

import javax.persistence.*;

/**
 * @author M1030563
 *
 */
@Entity
@Table(name = "BLOG_COMMENTS")
public class BlogComments {
	@Id
	@GeneratedValue
	@Column(name = "comment_id")
	private int commentId;

	@Column(name = "user_name")
	private String userName;

	@Lob
	@Column(name = "comment", length = 512)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="blog_id")
	private BlogContent blogContent;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BlogContent getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(BlogContent blogContent) {
		this.blogContent = blogContent;
	}

	public BlogComments() {
	}
	

}
