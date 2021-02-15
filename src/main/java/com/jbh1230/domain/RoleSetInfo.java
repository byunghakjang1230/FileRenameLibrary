package com.jbh1230.domain;

import java.text.ParseException;
import java.util.Date;

import com.jbh1230.constants.FileTypeConst;
import com.jbh1230.utils.DateTimeUtil;

public class RoleSetInfo {

	private FileTypeConst fileTypeConst;
	private String format;
	private Date startDate;
	private String fileNameFormat;
	
	
	public RoleSetInfo() {
		this.fileTypeConst 	= null;
		this.startDate 		= null;
		this.format 		= "";
		this.fileNameFormat = "";
	}
	
	public RoleSetInfo(FileTypeConst ftc) {
		this.fileTypeConst = ftc;
	}
	
	private RoleSetInfo setFileType(FileTypeConst ftc) {
		this.fileTypeConst = ftc;
		return this;
	}
	
	public RoleSetInfo setFormat(String format) {
		this.format = format;
		return this;
	}
	
	public RoleSetInfo setStartDate(String yyyyMMddHHmmss) {
		try {
			this.startDate = DateTimeUtil.transStringToDate(yyyyMMddHHmmss, "yyyyMMddHHmmss");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	
	public RoleSetInfo setFileNmaeFormat(String fileNameFormat) {
		this.fileNameFormat = fileNameFormat;
		return this;
	}
	
	public FileTypeConst getFileTypeConst() {
		return this.fileTypeConst;
	}
	
	
}
