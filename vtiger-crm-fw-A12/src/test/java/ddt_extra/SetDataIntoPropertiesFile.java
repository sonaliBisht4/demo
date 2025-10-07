package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetDataIntoPropertiesFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		
	}
}
