package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Excel {
	// data reading clases
	Workbook book;
	Sheet sh;
	// data writing classes
	WritableWorkbook wbook;
	WritableSheet wsh;

	String folderName;

	// constructor to set the filePath
	public Excel(String folderName) {
		this.folderName = folderName;
	}

	// set excel file to read data
	public void setExcel(String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(folderName + fileName);
			book = Workbook.getWorkbook(fis);
			sh = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// set excel file to write the data
	public void setExcelToWriteData(String ifileName, String ofileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(folderName + ifileName);
			book = Workbook.getWorkbook(fis);
			FileOutputStream fos = new FileOutputStream(folderName + ofileName);
			wbook = Workbook.createWorkbook(fos, book);
			wsh = wbook.getSheet(sheetName);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// get no of rows
	public int getRowCount() {
		int rc = sh.getRows();
		return rc;
	}

	// get no of columns
	public int getColumnCount() {
		int cc = sh.getColumns();
		return cc;
	}

	// read excel cell data
	public String readCell(int r, int c) {
		String data = sh.getCell(c, r).getContents();
		return data;
		// return sh.getCell(c, r).getContents();
	}

	// write data
	public void writeData(int r, int c, String data) {
		try {
			wsh.addCell(new Label(c, r, data));
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// save the excel file
	public void saveExcel() {
		try {
			wbook.write();
			wbook.close();
			book.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test(enabled=false)
	public void testExcel() {
		Excel excel = new Excel(".//resources/");
		excel.setExcel("kexim data.xls", "branches");
		int rcount= excel.getRowCount();
		int ccount = excel.getColumnCount();
		System.out.println("rows: "+rcount+"\t"+"columns: "+ccount);
		for(int r= 1; r<rcount;r++) {
			for(int c=0; c<ccount; c++) {
				String data = excel.readCell(r, c);
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		
		excel.setExcelToWriteData("kexim data.xls", "kexim data1.xls", "branches");
		System.out.println("rows: "+rcount+"\t"+"columns: "+ccount);
		for(int r=1; r<rcount; r++) {
				excel.writeData(r, ccount, "branch created");
		}
		
		excel.saveExcel();
		
	}
//	@DataProvider(name="dp")
	public Object[][] getExcelContents(String fileName, String sheetName){
		Excel excel = new Excel(folderName);
		excel.setExcel(fileName, sheetName);
		int rcount= excel.getRowCount();
		int ccount = excel.getColumnCount();
		String[][] data = new String[rcount-1][ccount];
		for(int r= 1; r<rcount;r++) {
			for(int c=0; c<ccount; c++) {
				data[r-1][c] = excel.readCell(r, c);
			}
		}
		return data;
	}
	
	@Test(dataProvider = "dp")
	public void printExcel(String branchName, String address1, String zcode, String country, String state, String city) {
		System.out.println(branchName +"\t"+address1+"\t"+zcode+"\t"+country+"\t"+state+"\t"+city);
	}
	

}
