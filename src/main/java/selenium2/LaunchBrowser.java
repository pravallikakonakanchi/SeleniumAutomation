package selenium2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("C:\\Users\\skona\\OneDrive\\Desktop\\abc1.txt");
		BufferedReader br = new BufferedReader(fr);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String strCurrentLine;
		while ((strCurrentLine = br.readLine()) != null) {
			driver.get(strCurrentLine); 
			Thread.sleep(5000);
		}
		br.close();
		driver.close();
	}

}
