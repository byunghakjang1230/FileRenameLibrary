package com.jbh1230.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jbh1230.constants.FileTypeConst;
import com.jbh1230.domain.FileInfoInstance;
import com.jbh1230.domain.RoleSetInfo;

public class FileBase {

	String baseFolder;
	String targetFolder;
	Map<String, Integer> fileNameMap = new HashMap<>();
	File baseFolderFile;
	File targetFolderFile;
	private List<RoleSetInfo> roleList;
	private Map<FileTypeConst, Boolean> typeMap = new HashMap<>();
	
	public FileBase(String filePath) throws FileNotFoundException {
		this.baseFolder = filePath;
		this.baseFolderFile = new File(filePath);
		if(!this.baseFolderFile.isDirectory()) {
			throw new FileNotFoundException("폴더가 존재하지 않습니다.");
		}
	}
	
	public FileBase(String basePath, String targetPath) throws FileNotFoundException {
		this.baseFolder = basePath;
		this.baseFolderFile = new File(basePath);
		this.targetFolder = targetPath;
		this.targetFolderFile = new File(targetPath);
		if(!this.baseFolderFile.isDirectory())
			throw new FileNotFoundException("폴더가 존재하지 않습니다.");
		if(!this.targetFolderFile.exists()) 
			this.targetFolderFile.mkdirs();
	}
	
	public void addRole(RoleSetInfo role) {
		this.roleList.add(role);
		this.typeMap.put(role.getFileTypeConst(), true);
	}
	
	public void addFileType(FileTypeConst ftc) {
		this.typeMap.put(ftc, true);
	}
	
	public List<FileInfoInstance> readFileList() {
		List<FileInfoInstance> list = new ArrayList<>();
		FileInfoInstance fii;
		for(File file : this.baseFolderFile.listFiles()) {
			if(file.isDirectory())
				continue;
			fii = new FileInfoInstance(file);
			if(fii.checkType(FileTypeConst.EMPTY))
				continue;
			
			if(this.typeMap.containsKey(fii.getFileType()))
				list.add(fii);
		}
		return list;
	}
}
