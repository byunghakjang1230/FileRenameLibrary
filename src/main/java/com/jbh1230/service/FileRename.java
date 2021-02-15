package com.jbh1230.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jbh1230.constants.FileTypeConst;
import com.jbh1230.domain.FileInfoInstance;
import com.jbh1230.domain.RoleSetInfo;
import com.jbh1230.utils.DateTimeUtil;
import com.jbh1230.utils.StringUtil;

public class FileRename extends FileBase {

//	private String baseFolder;
//	private File baseFolderFile;
	private int seq = 0;
//	private Map<String, Integer> fileNameMap = new HashMap<>();
//	private List<RoleSetInfo> roleList;
//	private Map<FileTypeConst, Boolean> typeMap = new HashMap<>();
	
	public FileRename(String filePath) throws FileNotFoundException {
		super(filePath);
	}
	
	public void renameProc() {
		List<FileInfoInstance> list = readFileList();
		String newFilename;
		StringBuilder sb;
		for(FileInfoInstance file : list) {
			sb = new StringBuilder();
			switch(file.getFileType()) {
			case IMAGE: sb.append("IMG_"); break;
			case VIDEO: sb.append("MOV_"); break;
			default: sb.append("NON_");
			}
			
			try {
				newFilename = DateTimeUtil.transDateToString(file.getCreateTimeToDate(), "yyyyMMdd_HHmmss");
				seq 		= fileNameMap.containsKey(newFilename) ? fileNameMap.get(newFilename) + 1 : 0;
				fileNameMap.put(newFilename, seq);
				sb.append(newFilename)
				  .append("_")
				  .append(StringUtil.lpad(seq, 4))
				  .append(".")
				  .append(file.getExtension());
				
				//파일 이름 변경 수행.
				file.renameTo(sb.toString());
				//System.out.println(sb.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception");
			}
		}
		System.out.println("     -------- Rename Finished --------     ");
	}
}
