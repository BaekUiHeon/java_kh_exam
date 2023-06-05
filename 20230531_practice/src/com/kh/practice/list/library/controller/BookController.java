package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.List;
import com.kh.practice.list.library.model.vo.Book;

public class BookController {
	private List<Book> list=new ArrayList<>();

	public BookController() {
		super();
		list.add(new Book("자바의 정석","남 궁 성","기타",20000));
		list.add(new Book("쉽게 배우는 알고리즘", "문병로", "기타", 15000));
		list.add(new Book("대화의 기술", "강보람", "인문", 17500));
		list.add(new Book("암 정복기", "박신우", "의료", 21000));
	}
	public void insertBook(Book bk) {
		list.add(bk);
	}
	public ArrayList selectList() {
		return (ArrayList)list;
	}
	public ArrayList<Book> searchBook(String keyword) { // 이름이 일치하는 북을, 선언한 ArrayList형 변수에 저장한후 그 변수를 반환.
		ArrayList<Book> k=new ArrayList<>();
		for(int i=0;;i++) {
			if(list.get(i)==null)
				break;
			if(list.get(i).getTitle().contains(keyword))
				k.add(list.get(i));
		}
		return k;               
	}
	public Book deleteBook(String title,String author) {
		Book A= new Book(title,author,null,0);
		Book B=null;
		int i=0;
		while(true) {
			if(list.get(i)==null)
				break;
			else if((list.get(i).compareTo(A))==1)
				return list.remove(i);
			i++;
			}	
		return null;
	}
	public int ascBook() {  
		return 1; //나중에 구현해보겠다.
	}
	
}
