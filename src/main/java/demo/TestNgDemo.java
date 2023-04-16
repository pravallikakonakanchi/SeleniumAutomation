package demo;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import constants.FileConstants;
import file.utils.PropertiesFileutils;

public class TestNgDemo {
	
	@Test(priority = 3)
	public void login1() throws IOException {
		System.out.println("home page ... ");
		
		String sUsername = PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username");
	}
	
	@Test(priority = 2)
	public void login2() {
		System.out.println("login page .... ");
	}
	
	@Test (priority = 3)
	public void accounts() {
		System.out.println("accounts page.... ");
	}
	
}
