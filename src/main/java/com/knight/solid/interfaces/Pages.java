package com.knight.solid.interfaces;

import org.seleniumhq.jetty7.security.LoginService;

public interface Pages {

	LoginService login();
	DashboardPO dashboard();

}
