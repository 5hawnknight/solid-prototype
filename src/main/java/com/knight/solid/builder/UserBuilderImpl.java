package com.knight.solid.builder;

import com.knight.solid.dataobjects.UserImpl;
import com.knight.solid.interfaces.User;
import com.knight.solid.interfaces.UserBuilder;

public class UserBuilderImpl implements UserBuilder 
{
	private String username = "";
	private String password = "";
	
	@Override
	public User build() 
	{
		return new UserImpl(username, password);
	}
	public UserBuilderImpl withUsername(String username)
	{
		this.username = username;
		return this;
	}
	public UserBuilderImpl withPassword(String password)
	{
		this.password = password;
		return this;
	}
}
