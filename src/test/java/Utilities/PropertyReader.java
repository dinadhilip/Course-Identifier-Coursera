package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	Properties properties;
	   public PropertyReader() {
	      try {
	         FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.properties");
	         this.properties = new Properties();
	         this.properties.load(file);
	      } catch (Exception var2) {
	         var2.printStackTrace();
	      }

	   }

	   public String getBrowserType() {
	      return this.properties.getProperty("primary_browser");
	   }

	   public String getUrl() {
	      return this.properties.getProperty("initial_url");
	   }
	   public String getENV() {
		      return this.properties.getProperty("execution_env");
		   }
	   public String getOS() {
		      return this.properties.getProperty("os");
		   }
	   

	   public String getValue(String property) {
	      return this.properties.getProperty(property);
	   }
	   

}


