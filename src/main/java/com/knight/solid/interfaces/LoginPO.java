package com.knight.solid.interfaces;


public interface LoginPO
{
	Dashboard loginAs(User user);
	Login loginWithFailure(User user);
	String getDisplayedErrorMessage();
	void isLoaded();
	public abstract String getTitle();
}
