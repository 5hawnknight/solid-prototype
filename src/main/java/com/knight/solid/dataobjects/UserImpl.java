package com.knight.solid.dataobjects;

import com.knight.solid.interfaces.User;

public class UserImpl implements User 
{
	private String username;
	private String password;
	
	@Override
	public String getUsername() 
	{
		return username;
	}
	@Override
	public String getPassword() 
	{
		return password;
	}
	public UserImpl(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
}