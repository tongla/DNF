package com.lyl.common.utils.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

/**
 * 实体对象导出类
 * @author Administrator
 */
public class EntityExport {
	
	public final int VAL = 1000;
	
	private HSSFSheet sheet;
	
	private boolean type;
	
	private List<?> entityList;
	
	private Object entity;
	
	private String[] columns;
	
	private String[] names;

	public EntityExport(String[] columns, String[] names, String sheetName) {
		this.columns = columns;
		this.names = names;
		sheet = new HSSFWorkbook().createSheet(sheetName);
	}
	
	/**
	 * 传入一个对象list集合，要导出的字段数组，对应的列名，表名
	 * 通过上述参数生成一个excel表
	 * @param entityList
	 * @param columns
	 * @param names
	 * @param sheetName
	 */
	public EntityExport(List<?> entityList, String[] columns, String[] names, String sheetName) {
		this(columns, names, sheetName);
		this.entityList = entityList;
		type = false;
	}
	
	public EntityExport(Object entity, String[] columns, String[] names, String sheetName) {
		this(columns, names, sheetName);
		this.entity = entity;
		type = true;
	}
	
	private void init(String[] names) {
		maxLengthList = new ArrayList<Integer>(names.length);
		for (int i = 0; i < names.length; i++) {
			maxLengthList.add(i, names[i].length() * VAL);
		}
		createHeadRow(names);
	}
	
	public HSSFWorkbook create() {
		init(names);
		if (type) {
			create(entity, columns);
		} else {
			for (Object entity : entityList) {
				create(entity, columns);
			}
		}
		return sheet.getWorkbook();
	}
	
	// 集合里每列最长的值
	private List<Integer> maxLengthList;
	
	private void create(Object entity, String[] columns) {
		HSSFRow newRow = createRow(sheet.getLastRowNum() + 1, null);
		
		for (int i = 0; i < columns.length; i++) {
			String column = columns[i];
			String value = getFieldValue(entity, column);
			
			if (value != null) {
				int maxLen = maxLengthList.get(i);
				int len = value.length() * (VAL / 2);
				if (len > maxLen) {
					maxLen = len;
					maxLengthList.set(i, maxLen);
					sheet.setColumnWidth(i, maxLen);
				}
			}
			createCell(newRow, null, i, value);
		}
	}
	
	private String getFieldValue(Object obj, String name) {
		try {
			Class<?> c = obj.getClass();
			Field field = c.getDeclaredField(name);
			field.setAccessible(true);
			Object value = field.get(obj);
			if (value != null) {
				if (value instanceof Date)
					return SimpleDateUtils.format((Date) value, "yyyy-MM-dd");
				return value.toString();
			}
		} catch (Exception e) {
			
		}
		return null;
	}
	
	/**
	 * 新建一行
	 * @param rownum
	 * @param style
	 * @return
	 */
	private HSSFRow createRow(int rownum, HSSFCellStyle style) {
		HSSFRow row = sheet.createRow(rownum);
		if(style != null)
			row.setRowStyle(style);
		return row;
	}
	
	/**
	 * 新建一列
	 * @param row 
	 * @param style
	 * @param column
	 * @param value
	 * @return
	 */
	private HSSFCell createCell(HSSFRow row, CellStyle style, int column, String value) {
		HSSFCell cell = row.createCell(column);
		cell.setCellValue(value);
		if (style != null) {
			cell.setCellStyle(style);
		} else {
			cell.setCellStyle(defaultStyle());
		}
		return cell;
	}
	
	/**
	 * 默认样式
	 */
	private HSSFCellStyle defaultStyle() {
		HSSFCellStyle style = sheet.getWorkbook().createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		return style;
	}
	
	/**
	 * 默认头部样式
	 */
	private HSSFCellStyle defaultHeadStyle() {
		HSSFCellStyle style = sheet.getWorkbook().createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);
		
		Font font = sheet.getWorkbook().createFont();
		font.setBoldweight(Short.MAX_VALUE);
		style.setFont(font);
		return style;
	}
	
	/**
	 * 生成表头
	 * @param columns
	 */
	private HSSFRow createHeadRow(String[] names) {
		HSSFRow headRow = sheet.createRow(0);
		for (int i = 0; i < names.length; i++) {
			createCell(headRow, defaultHeadStyle(), i, names[i]);
			sheet.setColumnWidth(i, maxLengthList.get(i));
		}
		return headRow;
	}
	
	/**
	 * 写出该excel
	 * @param output
	 * @throws IOException 
	 */
	public void write(OutputStream output) throws IOException {
		this.create().write(output);
	}
	
	public static void write(Object entity, String[] columns, String[] names, String sheetName, OutputStream output) throws IOException {
		new EntityExport(entity, columns, names, sheetName).create().write(output);
	}
	
	public static void write(List<Object> entityList, String[] columns, String[] names, String sheetName, OutputStream output) throws IOException {
		new EntityExport(entityList, columns, names, sheetName).create().write(output);
	}
	
}
