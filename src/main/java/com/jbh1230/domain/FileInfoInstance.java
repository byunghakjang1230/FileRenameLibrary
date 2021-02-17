package com.jbh1230.domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import com.jbh1230.constants.FileTypeConst;
import com.jbh1230.util.FileUtil;

public class FileInfoInstance {
	private File fileInstance;
	private FileTypeConst fileType;
	private String extesion;
	private String fileName;
	private String fileFullName;
	private String folderPath;
	private String fileFullPath;
	
	public FileInfoInstance(File file) {
		this.fileInstance = file;
		this.fileFullPath = file.getPath();
		this.fileFullName = file.getName();
		this.fileName	  = FileUtil.getNameWithoutExtention(file);
		this.extesion 	  = FileUtil.getExtension(file).toLowerCase();
		this.folderPath	  = FileUtil.getFolderPath(file);
		this.fileType	  = FileTypeConst.findType(extesion);
		
		
	}
	
	public boolean checkType(FileTypeConst type) {
		return this.fileType.equals(type);
	}
	
	public File getFileInstance() {
		return this.fileInstance;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public String getFileFullName() {
		return this.fileFullName;
	}
	
	public String getExtension() {
		return this.extesion;
	}
	
	public String getFolderPath() {
		return this.folderPath;
	}
	
	public String getFileFullPath() {
		return this.fileFullPath;
	}
	
	public FileTypeConst getFileType() {
		return this.fileType;
	}
	
	public boolean renameTo(String toFileName) throws IOException {
		return renameTo(new File(toFileName));
	}
	
	public boolean renameTo(File toFile) throws IOException {
		return this.fileInstance.renameTo(toFile);
	}
	
	public boolean moveTo(String toFileName) throws IOException {
		return moveTo(new File(toFileName));
	}
	
	public boolean moveTo(File toFile) throws IOException {
		File pathFile = new File(toFile.getParent());
		if(!pathFile.exists()) {
			pathFile.mkdirs();
		}
		return Files.move(this.fileInstance.toPath(), toFile.toPath()).toFile().exists();
	}
	
	public Date getCreateTimeToDate() throws IOException {
		return FileUtil.getCreateTime(this.fileInstance);
	}
	
	public Date getModifyTimeToDate() throws IOException {
		return FileUtil.getLastModifyTime(this.fileInstance);
	}
}
