package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qapitol.keyengine.keyengine;

public class Login_Test {
 public keyengine keyengine;
// public WebDriver driver;
 public final static Logger logger=LogManager.getLogger(Login_Test.class);
 @BeforeTest
 public void setup() {
	 keyengine = new keyengine();
 }
 @Test
 public void Logintest() throws Exception {
	 String filepath="C:\\Users\\Qapitol QA\\Downloads\\instagram.xlsx";
	 logger.debug("execute Logintest");
	 keyengine.service(filepath);
 }
 @AfterTest
 public void close() {
	 keyengine.tearDown();
 }
 
}
