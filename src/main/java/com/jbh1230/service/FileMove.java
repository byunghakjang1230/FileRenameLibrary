package com.jbh1230.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.jbh1230.domain.FileInfoInstance;
import com.jbh1230.utils.DateTimeUtil;
import com.jbh1230.utils.StringUtil;

public class FileMove extends FileBase {

	private int seq;
	
	public FileMove(String filePath) throws FileNotFoundException {
		super(filePath);
		// TODO Auto-generated constructor stub
	}
	
	public FileMove(String basePath, String targetPath) throws FileNotFoundException {
		super(basePath, targetPath);
	}

	public void moveFileProc() {
		List<FileInfoInstance> list = readFileList();
		String newFilename;
		StringBuilder sb;
		String yyyy;
		String mm;
		File newFile;
		File pathFile;
		for(FileInfoInstance file : list) {
			sb = new StringBuilder();
			seq = 0;
			try {
				yyyy		= DateTimeUtil.transDateToString(file.getCreateTimeToDate(), "yyyy");
				mm			= DateTimeUtil.transDateToString(file.getCreateTimeToDate(), "MM");
				newFilename = DateTimeUtil.transDateToString(file.getCreateTimeToDate(), "yyyyMMdd_HHmmss");
				fileNameMap.put(newFilename, seq);
				
				sb.append(super.targetFolder == null || super.targetFolder.equals("") ? file.getFolderPath() : super.targetFolder);
				sb.append("/");
				sb.append(yyyy);
				sb.append("/");
				sb.append(mm);
				
//				pathFile = new File(sb.toString());
//				if(!pathFile.exists()) {
//					pathFile.mkdirs();
//				}
				sb.append("/");
				
				switch(file.getFileType()) {
				case IMAGE: sb.append("IMG_"); break;
				case VIDEO: sb.append("MOV_"); break;
				default: sb.append("NON_");
				}
				
				sb.append(newFilename)
				  .append("_");
				do {
					newFile = new File(sb.toString() + StringUtil.lpad(seq++, 4) + "." + file.getExtension());
				} while(newFile.exists());
				
				System.out.println(newFile.getPath());
				file.moveTo(newFile);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception");
			}
		}
		System.out.println("     -------- Move Finished --------     ");
	}
}
