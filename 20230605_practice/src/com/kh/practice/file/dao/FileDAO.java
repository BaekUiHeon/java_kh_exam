package com.kh.practice.file.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {
	public boolean checkName(String file){
		File f= new File(file);
		return f.isFile();
		}
	
	public void fileSave(String file,String s){
		File f= new File(file);
		try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try(FileWriter fw=new FileWriter(f);) {
			fw.write(s);
			}
		catch (IOException e) {
	        e.printStackTrace();
		}
	}
	
	public StringBuilder fileOpen(String file){
		StringBuilder sb= new StringBuilder();
		File f= new File(file);
		try(BufferedReader br=(new BufferedReader(new FileReader(f)));)
		{
			String line;
			while(((line=br.readLine())!=null))
				sb.append(line);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return sb;
	} 
	public void fileEdit(String file,String s){
		try(BufferedWriter wt=new BufferedWriter(new FileWriter(file,true)))
		{
			wt.write(s);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
