package com.amplify.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils {
	public static FileInputStream fis = null;
    public static FileOutputStream fos = null;
    public static XSSFWorkbook workbook = null;
    public static XSSFSheet sheet = null;
    public static XSSFRow row = null;
    public static  XSSFCell cell = null;

    public static boolean setCellData(int colNumber, int rowNum, String value,String testCaseName )
    {
        try
        {

        	 
        	String xlFilePath="C:\\Project\\TestData.xlsx";
        	File file =new File(xlFilePath);
            fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            fis.close();
 
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            if(row==null)
                row = sheet.createRow(rowNum);
 
            cell = row.getCell(colNumber);
            if(cell == null)
                cell = row.createCell(colNumber);
            
            
            /*-----------For Styling Purpose---------------------------*/
       	 	XSSFFont font = workbook.createFont();
       	 	XSSFCellStyle style = workbook.createCellStyle();
            font.setFontName("Comic Sans MS");
            font.setFontHeight(11.0);
            font.setBold(true);
            font.setColor(HSSFColor.WHITE.index);
     
            style.setFont(font);
            style.setFillForegroundColor(HSSFColor.GREEN.index);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
     
            //Write Test Result
            cell.setCellStyle(style);
            cell.setCellValue(value);
            
            //Write Test Case Name
            cell.setCellStyle(null);
            cell = row.getCell(1);
            if(cell == null)
                cell = row.createCell(1);
            cell.setCellValue(testCaseName);
            
            //Write Test Case Number
            cell = row.getCell(0);
            if(cell == null)
                cell = row.createCell(0);
            cell.setCellValue(rowNum);
            /*-------------------------------------------------------*/
            fos = new FileOutputStream(xlFilePath);
            workbook.write(fos);
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
    
    //Read Excel 
    

}
