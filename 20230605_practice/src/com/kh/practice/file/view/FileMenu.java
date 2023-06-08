package com.kh.practice.file.view;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	private Scanner sc=new Scanner(System.in);
	private FileController fc=new FileController();
	
	public void mainMenu(){
		String choice=null;
		int choose;
		
		System.out.println("***** My Note *****");
		System.out.println("1. 노트 새로 만들기 ➔ fileSave()");
		System.out.println("2. 노트 열기 ➔ fileOpen()");
		System.out.println("3. 노트 열어서 수정하기 ➔ fileEdit()");
		System.out.println("9. 끝내기 ➔ \"프로그램을 종료합니다.\" 출력 후 종료");
		System.out.print("메뉴 번호 : ");
		choice=sc.nextLine();
		choose=Integer.parseInt(choice);
		switch(choose) {
		case 1: fileSave(); break;
		case 2: fileOpen(); break;
		case 3: fileEdit(); break;
		case 9: System.out.println("프로그램을 종료합니다."); return;
		}
		
	}
	
	public void fileSave(){
		System.out.print("파일에 저장할 내용을 입력하세요.\n"
				+ "ex끝it 이라고 입력하면 종료됩니다.\n");
		String str="s";
		StringBuilder sb=new StringBuilder();
		while(true) {
			System.out.print("내용:");
			str=sc.nextLine();
			if(str.equals("ex끝it"))
				break;
			sb.append(str);
		}
		char tmp='0';
		while(true) {
		System.out.println("파일명을 입력하시오:");
		str=sc.nextLine();
		if(fc.checkName(str)) {
			while(tmp!='n'&&tmp!='y') {
			System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n):");
			tmp=sc.nextLine().charAt(0);
			if(tmp=='y') {
				fc.fileSave(str,sb);
				return;
			}
			else if(tmp=='n')
				continue;
			else {
				System.out.println("잘못된 값이 입력되었습니다.");
			}
			}
		}
		else {
			fc.fileSave(str, sb);
			return;}
		}	
	}
	public void fileOpen() {
		System.out.println("열 파일명:");
		String str=sc.nextLine();
		if(fc.checkName(str))
			System.out.println(fc.fileOpen(str));
		else
			System.out.println("존재하지 않는 파일입니다.");
	}
	public void fileEdit() {
		System.out.print("수정할 파일 명:");
		String file;
		String tmp=null;
		StringBuilder sb= new StringBuilder();
		if(!fc.checkName(file=sc.nextLine()))
			System.out.println("없는파일입니다.");
		else
			while(true) {
				System.out.print("추가할 내용을 문자입력:");
				tmp=sc.nextLine();
				if(tmp.equals("ex끝it"))
					break;
				sb.append(tmp);
			}
		fc.fileEdit(file,sb);
	}
}
