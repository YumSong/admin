package com.lames.admin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class FileUtil {
	
	public static Properties loadReasource(String path) {
		InputStream is = FileUtil.class.getClassLoader().getResourceAsStream(path);
		
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
