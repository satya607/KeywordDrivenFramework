package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility {
  private static int index;

public static XSSFSheet readexcel(String filepath) throws Exception {
	  FileInputStream fis = new FileInputStream(new File(filepath));
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	 XSSFSheet sheet = workbook.getSheetAt(index );
	 return sheet;
  }
}
