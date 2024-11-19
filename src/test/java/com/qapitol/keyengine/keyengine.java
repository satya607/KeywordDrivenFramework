package com.qapitol.keyengine;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.utility;

public class keyengine {
public WebDriver driver;
 
 
  public void service(String filepath) throws Exception {
	  XSSFSheet sheet = utility.readexcel(filepath);
	  for(Row row:sheet) {
		String  keyword=row.getCell(0).getStringCellValue();
		System.out.println("keywod"+keyword);
		String  LocatorType=row.getCell(1).getStringCellValue();
		String  LocatorValue=row.getCell(2).getStringCellValue();
		String  data=row.getCell(3).getStringCellValue();
		switch (keyword) {

        case "openbrowser":
            if (data.equalsIgnoreCase("FireFox")) {
                driver = new FirefoxDriver();
            } else {
            	System.out.println("Entered");
                driver = new ChromeDriver();
            }
            break;
        case "navigate":
            System.out.println("Navigate to" + data);
            driver.get(data);
            driver.manage().window().maximize();
            break;
        case "enterEmail":
            getElement(LocatorType, LocatorValue).sendKeys(data);
            break;
        case "enterPassword":
            getElement(LocatorType, LocatorValue).sendKeys(data);
            break;
        case "submit":
            getElement(LocatorType, LocatorValue).click();
            break;
        case "NA":
        	break;
        default:
            System.out.println("Invalid keyword: " + keyword);


    }

}
  }

public  WebElement getElement (String locatorType, String locatorVal){
WebElement element = null;

switch (locatorType) {
    case "xpath":
        element = driver.findElement(By.xpath(locatorVal));
        break;
    case "id":
        element = driver.findElement(By.id(locatorVal));
        break;
    case "name":
        element = driver.findElement(By.name(locatorVal));
        break;
    case "NA":
        break;
    default:
        System.out.println("Invalid locator Type" + locatorType);
}
return element;
}

public void tearDown(){
driver.quit();
}
	  
  
}

