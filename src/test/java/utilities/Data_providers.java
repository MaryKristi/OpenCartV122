package utilities;

import org.testng.annotations.DataProvider;

public class Data_providers {
	
	//DataProvider1
	
	@DataProvider(name="LoginData")//, indices= {0,2})
	Object loginData()
	{
		Object data[][]= {  {"laksh@yahoo.com",      "Lakshmi",  "Valid"},
				            {"jyothi797@gmail.com",  "jyothi@123", "Valid"},   // Object can read any data type int,string, boolean
				            //{"lakshmi@yahoo.com",    "Laxmi" ,   "Invalid"},
							//{"jyothi7979@gmail.com",    "jyothi@123", "valid"},
							{"abc123@gmail.com",     "test@123", "Valid"}
							};
		return data;
	
	}
	
	//public String [][] getData() throws IOException
//{
		//String path =".\\testData_XL\\OpenCard_loginData.xlsx\\"; //taking xl file from the xlfiles
//		
//		Utility_Excel_data xlutil = new Utility_Excel_data(path); //creating obj of Utility_Excel_data.java file
//		
//		int totalrows=Utility_Excel_data.getRowCount("Sheet1", path);
//		int totalcolumns=Utility_Excel_data.getCellCount("Sheet1",1);
//		
//		String logindata[][]=new String[totalrows][totalcolumns];
//		
//			for (int  i=1; i<=totalrows; i++)
//			{
//				for (int j=0; j<totalcolumns; j++)
//				{
//					logindata[i-1][j]= Utility_Excel_data.getCellData("Sheet1", i, j); // 1,0
//				}
//				
//			}
//			return logindata;  //returning two dimentional array
//	}	
	
	
	//DataProvider2
	
	
		
			 	
		 	 	
			 	
		 	 	
		 	 	

	//DataProvider3
	
	//DataProvider4
	

}
