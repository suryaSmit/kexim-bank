package utility;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	Excel excel = new Excel(".//resources/");
	@DataProvider(name="branch data")
	public Object[][] branchData(){
		return excel.getExcelContents("kexim data.xls", "branches");
	}
	
	@DataProvider(name="role data")
	public Object[][] roleData(){
		return excel.getExcelContents("kexim data.xls", "roles");
	}

}
