package Utilities;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
		import org.apache.poi.ss.usermodel.IndexedColors;
		import org.apache.poi.xssf.usermodel.XSSFCell;
		import org.apache.poi.xssf.usermodel.XSSFRow;
		import org.apache.poi.xssf.usermodel.XSSFSheet;
		import org.apache.poi.xssf.usermodel.XSSFWorkbook;

		public class XLutilities {
			public static FileInputStream fi;
			public static FileOutputStream fo;
			public static XSSFWorkbook wb;
			public static XSSFSheet ws;
			public static XSSFRow row;
			public static XSSFCell cell;
			public static CellStyle style; 
			static String file=System.getProperty("user.dir") + ".\\ExcelData\\CourseOutputData.xlsx";
			
			public static int getRowCount(String xlfile,String xlsheet) throws IOException 
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				int rowcount=ws.getLastRowNum();
				wb.close();
				fi.close();
				return rowcount;		
			}
			

			public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				row=ws.getRow(rownum);
				int cellcount=row.getLastCellNum();
				wb.close();
				fi.close();
				return cellcount;
			}
			
			
			public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				row=ws.getRow(rownum);
				cell=row.getCell(colnum);
			
				String data;
				try 
				{
					
					//data=cell.toString();
					
					DataFormatter formatter = new DataFormatter();
		            data = formatter.formatCellValue(cell);
		            return data;
				}
				catch (Exception e) 
				{
					data="";
				}
				
				wb.close();
				fi.close();
				return data;
			}
			
			

			public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				row=ws.getRow(rownum);
				cell=row.createCell(colnum);
				cell.setCellValue(data);
				fo=new FileOutputStream(xlfile);
				wb.write(fo);		
				wb.close();
				fi.close();
				fo.close();
						
			}
			public static void setcelldata(String Sheet,String text,int r,int c) throws IOException {
				fi=new FileInputStream(file);
				
				wb=new XSSFWorkbook(fi);  
				ws=wb.getSheet(Sheet);  
				if(ws.getRow(r) != null) {
			        row = ws.getRow(r);}
			    else {
			        row = ws.createRow(r);
			    }
				cell=row.createCell(c);
				cell.setCellValue(text);
				fo=new FileOutputStream(file);
				wb.write(fo);
				wb.close();
				fi.close();
				fo.close();
			}
			
			public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				row=ws.getRow(rownum);
				cell=row.getCell(colnum);
				
				style=wb.createCellStyle();
				
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
						
				cell.setCellStyle(style);
				fo=new FileOutputStream(xlfile);
				wb.write(fo);
				wb.close();
				fi.close();
				fo.close();
			}
			
			
			public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				row=ws.getRow(rownum);
				cell=row.getCell(colnum);
				
				style=wb.createCellStyle();
				
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
				
				cell.setCellStyle(style);		
				fo=new FileOutputStream(xlfile);
				wb.write(fo);
				wb.close();
				fi.close();
				fo.close();
			}
			
		}



