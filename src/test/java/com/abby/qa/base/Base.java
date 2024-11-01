package com.abby.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.abby.qa.utils.Utilities;

public class Base {

	// Base calss details

	WebDriver driver;
	public Properties prop;
	public Properties dataprop;


	public Base() {
		prop = new Properties();
		dataprop = new Properties();

		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\abby\\qa\\config\\config.properties");
		File dataPropFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\abby\\qa\\testdata\\testdata.properties");

		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);

			FileInputStream dataFis = new FileInputStream(dataPropFile);
			dataprop.load(dataFis);
		}


		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public WebDriver inisalizeBrowserOpenUrl(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.impl_Wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoad_Timeout));
		driver.get(prop.getProperty("url"));

		return driver;
	}

}
