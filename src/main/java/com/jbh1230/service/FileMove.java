package com.jbh1230.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.jbh1230.domain.FileInfoInstance;
import com.jbh1230.util.DateUtil;
import com.jbh1230.util.StringUtil;

public class FileMove extends FileBase {
	
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
		int seq;
		
		String bfName;
		String afName;
		
		for(FileInfoInstance file : list) {
			//각각의 파일마다 새롭게 사용될 변수 초기화.
			sb = new StringBuilder();
			seq = 0;
			
			try {
				//파일이동 경로를 셋팅하는데 필요한 값들을 세팅.
				yyyy		= DateUtil.transDateToString(file.getCreateTimeToDate(), "yyyy");
				mm			= DateUtil.transDateToString(file.getCreateTimeToDate(), "MM");
				newFilename = DateUtil.transDateToString(file.getCreateTimeToDate(), "yyyyMMdd_HHmmss");

				//파일경로 문자열 조립.
				sb.append(super.targetFolder == null || super.targetFolder.equals("") ? file.getFolderPath() : super.targetFolder);
				sb.append("/");
				sb.append(yyyy);
				sb.append("/");
				sb.append(mm);
				sb.append("/");
				
				switch(file.getFileType()) {
				case IMAGE: sb.append("IMG_"); break;
				case VIDEO: sb.append("MOV_"); break;
				default	  : sb.append("NON_");
				}
				
				sb.append(newFilename)
				  .append("_");
				
				//동일한 파일명에 동일한 시퀀스가 이미 존재할 경우 반복문을 돌면서 시퀀스를 1씩 올림.
				do {
					newFile = new File(sb.toString() + StringUtil.lpad(seq++, 4) + "." + file.getExtension());
				} while(newFile.exists());
				
				bfName = file.getFileInstance().getPath();
				afName = newFile.getPath();
				
				//파일이동 시작
				file.moveTo(newFile);
				
				System.out.println(" > SUCCEED : " + afName + "  <<==  " + bfName);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("** Exception ** ");
				System.out.println("  |- File Name : " + file.getFileName());
				System.out.println("  |- File Path : " + file.getFolderPath());
			}
		}
		System.out.println("     -------- Move Finished --------     ");
	}
}
