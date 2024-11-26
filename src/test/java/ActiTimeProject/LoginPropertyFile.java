package ActiTimeProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LoginPropertyFile {
	
	public String loginActiTime(String key) throws IOException  {
		FileInputStream f = new FileInputStream("./TestData/commonProperty.properties");
		 Properties p = new Properties();
		 p.load(f);
		 
	 	String data = p.getProperty(key);
	 	
	 	return data;
	}
	
	public String DataFromExel(String sheet , int row, int cell) throws IOException {
		FileInputStream f = new FileInputStream("./TestData/testData.xlsx");
     Workbook wb = WorkbookFactory.create(f);
	String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
}
