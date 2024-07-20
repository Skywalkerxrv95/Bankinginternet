package com.bankinternet.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtiis {

  @SuppressWarnings("unused")
private FileInputStream fis;
  private XSSFWorkbook wk;
  private XSSFSheet sh;
  
 
  
  public XLUtiis(String filePath, String sheetName) throws IOException {
      FileInputStream fis = new FileInputStream(filePath);
      wk = new XSSFWorkbook(fis);
      sh = wk.getSheet(sheetName);
      fis.close();
  }

	/*
	 * public XLUtiis() throws IOException { fis = new
	 * FileInputStream("./test.xlsx"); wk = new XSSFWorkbook(fis); sh =
	 * wk.getSheet("sheet2"); }
	 */

  public int getNumberofColoums() {
    Row row = sh.getRow(0);
    if (row != null) {
      return row.getLastCellNum();
    }
    return 0;
  }

  public List<List<String>> readData() {
    List<List<String>> data = new ArrayList<>();
    int numOfColumns = getNumberofColoums();

    for (Row row : sh) {
      List<String> rowData = new ArrayList<>();
      for (int cn = 0; cn < numOfColumns; cn++) {
        Cell cell = row.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        if (cell == null) {
          rowData.add("");
        } else {
          rowData.add(cell.toString());
        }
      }
      data.add(rowData);
    }

    return data;
  }

  public void close() throws IOException {
    if (wk != null) {
      wk.close();
    }
  }
}
