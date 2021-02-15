package com.jbh1230.main;

import java.io.File;
import java.io.FileNotFoundException;

import com.jbh1230.constants.FileTypeConst;
import com.jbh1230.domain.RoleSetInfo;
import com.jbh1230.service.FileMove;

public class Test {
	public static void main(String[] args) {
//		System.out.println(FileTypeConst.AUDIO);
//		StringBuilder sb = new StringBuilder();
//		sb.append(111);
//		sb.append("hihi");
//		sb.append(true);
//		System.out.println(sb.toString());
		try {
			FileMove fm = new FileMove("/Users/byunghakjang/Desktop/jpg", "/Users/byunghakjang/Desktop/jpg/backup");
//			fm.addRole(new RoleSetInfo().);
			fm.addFileType(FileTypeConst.IMAGE);
			fm.moveFileProc();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		File ss = new File("IMG_/Users/byunghakjang/Desktop/jpg/2019/07/20190731_234015_0000.jpg");
//		System.out.println(ss.exists());
		
	}
}
