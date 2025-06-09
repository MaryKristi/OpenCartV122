package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility_Excel_data {
	
		
		public static FileInputStream fi; 
		public static FileOutputStream fo; 
		public static XSSFWorkbook wb; 
		public static  XSSFSheet sheet; 
		public static  XSSFRow row; 
		public static  XSSFCell cell; 
		public static  CellStyle style;
		static String path; 
	 
//		public Utility_Excel_data(String path) 
//		{ 
//			this.path=path; 
//			
//		} 
		public static int getRowCount(String path ,String sheetName) throws IOException 
			{ 
				fi=new FileInputStream(path); 
				wb=new XSSFWorkbook(fi); 
				sheet=wb.getSheet(sheetName); 
				int rowcount=sheet.getLastRowNum(); 
				wb.close(); 
				fi.close();
				return rowcount;
			}
	     public static int getCellCount(String sheetName,int rownum) throws IOException 
	     { 
		     fi=new FileInputStream(path); 
		     wb=new XSSFWorkbook(fi); 
		     sheet=wb.getSheet(sheetName); 
		     row=sheet.getRow(rownum); 
		     int cellcount=row.getLastCellNum(); 
		     wb.close(); 
		     fi.close(); 
		     return cellcount; 
			} 
			public static String getCellData (String sheetName, int rownum, int colnum) throws IOException 
			{ 
				fi=new FileInputStream(path); 
				wb=new XSSFWorkbook(fi); 
				sheet=wb.getSheet(sheetName); 
				row=sheet.getRow(rownum); 
				cell=row.getCell(colnum); 
				DataFormatter formatter = new DataFormatter(); 
				String data; 
			try 
			{ 
				//data=cell.toString(); 
			 data=formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String rega 
			} 
			 	catch(Exception e) 
			{ 
			 	data=""; 
			} 
			
			wb.close();
			fi.close();
			return data;
			
			}			
		public static void setCellData (String sheetName, int rownum, int colnum, String data) throws IOException 
			{ 
			  File xlfile=new File(path); 
			  if(!xlfile.exists()) 
			    // If file not exists then create new file 
			   { 
				wb=new XSSFWorkbook(); 
				fo=new FileOutputStream(path); 
				wb.write(fo); 
			   } 
				fi=new FileInputStream(path); 
				wb=new XSSFWorkbook(fi); 
				
				if(wb.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet 
				wb.createSheet(sheetName); 
				sheet=wb.getSheet(sheetName); 
				
				if(sheet.getRow(rownum)==null) // If row not exists then create new Row 
				sheet.createRow(rownum); 
				row=sheet.getRow(rownum); 
				
				cell=row.createCell(colnum); 
				cell.setCellValue(data); 
				fo=new FileOutputStream (path); 
				
				wb.write(fo); 
				wb.close(); 
				
				fi.close(); 
				fo.close();
		}
			
		public static void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException 
			{ 
				fi=new FileInputStream(path); 
				wb=new XSSFWorkbook(fi); 
				sheet=wb.getSheet(sheetName); 
				row=sheet.getRow(rownum); 
				
				cell=row.getCell(colnum); 
				style=wb.createCellStyle(); 
				
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); 
				style.setFillPattern (FillPatternType.SOLID_FOREGROUND); 
				cell.setCellStyle(style); 
				//fo=new FileOutputStream(xlfile); 
				
				wb.write(fo); 
				wb.close(); 
				fi.close(); 
				fo.close(); 
				
			}
	    public static void fillRedColor(String sheetName, int rownum, int colnum) throws IOException 
	    {
			    fi = new FileInputStream(path);
			    wb = new XSSFWorkbook(fi);
			    sheet = wb.getSheet(sheetName);
			    row =sheet.getRow(rownum);
			    cell = row.getCell(colnum);

			    style = wb.createCellStyle();
			    style.setFillForegroundColor(IndexedColors.RED.getIndex());
			    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			    cell.setCellStyle(style);

			   // fo = new FileOutputStream(xlfile);
			    wb.write(fo);
			    wb.close();
			    fi.close();
			    fo.close();
			}
		
		
	
}
