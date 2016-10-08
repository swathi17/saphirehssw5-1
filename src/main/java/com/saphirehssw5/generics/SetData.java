package com.saphirehssw5.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetData
{
	public static void toExcel(String fileName, String sheetName, int rIndex,
			int cIndex, String data)
	{
		try
		{
			File f = new File("./data/"+fileName);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rIndex);
			Cell c = r.createCell(cIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e)
		{
			
		}
	}
	public static void toProperties(String fileName, String key, String value)
	{
		try
		{
			File f = new File("./configdata/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos, "");
		}
		catch(Exception e)
		{
			
		}
	}
}