package utilities;

import java.rmi.AccessException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	
	//DataProviders
	@DataProvider(name="LoginData")
	public String[][]getData()throws Exception
	{
		String path=".\\testData\\Opencart_LoginData.xlsx"; //tacking xl file fron testdata
		
		ExcelUtility xlutil= new ExcelUtility(path); //Creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		
		String logindata[][]=new String[totalrows][totalcols]; //created for two dimension array which can store 
		
		for (int i=1;i<=totalrows;i++) //1//read the data from x1 storing in two deminsioal array
		{
			for(int j=0;j<totalrows;i++) //0 i is rows j is col
			{
				logindata[i-1][j]=xlutil.getCellData("sheet", i, j);
			}
		}
	return logindata;//retrun two dimension array
	}
	
		//DataProvider 2
	//DataProvider 3
	//DataProvider 4
	
	}
