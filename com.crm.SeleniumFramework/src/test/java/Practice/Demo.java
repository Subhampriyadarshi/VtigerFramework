package Practice;
import org.apache.poi.ss.usermodel.Cell;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Demo {

	public static void main(String[] args) throws Throwable
	{
		
		FileInputStream fis=new FileInputStream("./Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		Row row=sh.getRow(0);
		Cell cell = row.getCell(0);
		String val = cell.getStringCellValue();
		System.out.println(val);
	}

}
