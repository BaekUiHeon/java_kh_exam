package com.kh.practice.file.controller;

import com.kh.practice.file.dao.FileDAO;

public class FileController {
	private FileDAO fd=new FileDAO(); 
	public boolean checkName(String file) {return fd.checkName(file);}//TODO	
	public void fileSave(String file,StringBuilder sb){
		String tmp=sb.toString();
		fd.fileSave(file,tmp);
	}
	public StringBuilder fileOpen(String file){
		return fd.fileOpen(file);
	}
	
	public void fileEdit(String file,StringBuilder sb){
		String tmp=sb.toString();
		fd.fileEdit(file,tmp);
	}
}
