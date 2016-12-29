/**
 * 
 */
package com.content.management.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author M1029673
 *
 */
public class LoginVo {
	private String userName;
	private String password;
	private String guestUser;
	@NotEmpty(message = "Please enter your User Name.")
	private String guestUserName;
	private String adminUser;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGuestUser() {
		return guestUser;
	}

	public void setGuestUser(String guestUser) {
		this.guestUser = guestUser;
	}

	public String getGuestUserName() {
		return guestUserName;
	}

	public void setGuestUserName(String guestUserName) {
		this.guestUserName = guestUserName;
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

}
