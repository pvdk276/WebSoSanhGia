package com.webss.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectDB {
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectDB.class);
	private Connection conn = null;
	private Statement stm;
	private ResultSet rs;
	private String driver 	= null;		//driver jdbc
	private String url		= null;		//string to connect to mysql
	private String username = null;		//username login to mysql server
	private String password = null;		//password  login to mysql server
	
	public ConnectDB () {
		Properties properties = new Properties();
		try {
			//load file DBconnect.properties to get database configuration
			properties.load(this.getClass().getClassLoader().
					getResourceAsStream("DBconnect.properties"));
			logger.info("get database configuration");
			//Set information
			driver 	= properties.getProperty("jdbc.driver");
			url 	= properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
		} catch (IOException e) {
			logger.error("cannot get database configuration");
			e.printStackTrace();
		}
	}
	public Connection openConnect(){
    	Connection conn = null;
    	try {
            try {
				Class.forName(driver).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            // connect to mySql
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        this.conn = conn;
        return conn;    		
    }
	public void closeConnect(){
		if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
	}
	
	public ResultSet getResult(String sql){
		openConnect();
		try{
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
		}catch(Exception ex){
			
		}
		closeConnect();
		return rs;
	}

}
