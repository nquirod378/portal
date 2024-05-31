package com.portal.conector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.portal.constants.Constants;

import lombok.Getter;
import lombok.Setter;

public class Conector {
	@Setter
	@Getter
	Properties prop = new Properties();
 
	public Conector() {
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	public Connection getMySQL() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(prop.getProperty(Constants.DRIVER));
			
			
			try {
				return DriverManager.getConnection(getURL());
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
 
	private String getURL() {
		// jdbc:mysql://localhost:3306/schema?user=user&password=password&useSSL=false
		return new StringBuilder().append(prop.getProperty(Constants.URL_PREFIX))
				.append(prop.getProperty(Constants.URL_HOST)).append(":").append(prop.getProperty(Constants.URL_PORT))
				.append("/").append(prop.getProperty(Constants.URL_SCHEMA)).append("?user=")
				.append(prop.getProperty(Constants.USER)).append("&password=")
				.append(prop.getProperty(Constants.PASSWD)).toString();
		/*
		return new StringBuilder().append(prop.getProperty(Constants.URL_PREFIX))
				.append(prop.getProperty(Constants.URL_HOST)).append(":").append(prop.getProperty(Constants.URL_PORT))
				.append("/").append(prop.getProperty(Constants.URL_SCHEMA)).append("?user=")
				.append(prop.getProperty(Constants.USER)).append("&password=")
				.append(prop.getProperty(Constants.PASSWD)).append("&useSSL=")
				.append(prop.getProperty(Constants.URL_SSL)).toString();
	*/}
	
	
	
}
