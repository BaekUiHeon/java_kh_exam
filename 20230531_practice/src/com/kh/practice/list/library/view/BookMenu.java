package com.kh.practice.list.library.view;

import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	private Scanner sc=new Scanner(System.in);
	private BookController bc= new BookController();
	
	public void mainMenu() { // 사용자가 직접 메인메뉴를 선택 할 수 있음. 종료전까지 반복실행, 각 메뉴를 누를시 해당메서드로 이동
		int choice=0;
	    while(true) {
		System.out.println("== Welcome KH Library ==");
		System.out.println("******* 메인 메뉴 *******");
		System.out.println("1. 새 도서 추가:");// insertBook () 실행"
		System.out.println("2. 도서 전체 조회: ");// selectList ()
		System.out.println("3. 도서 검색 조회: ");// searchBook ()
		System.out.println("4. 도서 삭제: ");// deleteBook ()
		System.out.println("5. 도서 명 오름차순 정렬: ");// ascBook()
		System.out.println("9. 종료: ");// “프로그램을 종료합니다.” 출력 후 main()으로 리턴
		System.out.print("메뉴 번호 선택: ");// 입력 받음
		choice=sc.nextInt();
		if(choice==1)
			insertBook();
		else if(choice==2)
			selectList();
		else if(choice==3)
			searchBook();
		else if(choice==4)
			deleteBook();
		else if(choice==5)
			ascBook();
		else if(choice==9) {
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		else
			System.out.println("잘못된 입력입니다. 다시 입력해주세요");
	    }
	}
	public void insertBook() { 
		String title,author;
		int category,price;
		sc.nextLine();
		System.out.print("도서명입력:");
		title=sc.nextLine();
		System.out.print("저자명입력:");
		author=sc.nextLine();
		System.out.print("장르입력:(1.인문 / 2.자연과학 / 3.의료 / 4.기타)");
		category=sc.nextInt();
		System.out.print("가격입력:");
		price=sc.nextInt();
		switch(category) {
		case 1:
			bc.insertBook(new Book(title,author,"인문",price));
			break;
		case 2:
			bc.insertBook(new Book(title,author,"자연과학",price));
			break;
		case 3:
			bc.insertBook(new Book(title,author,"의료",price));
			break;
		case 4:
			bc.insertBook(new Book(title,author,"기타",price));
			break;
		}
	}
	public void selectList() { //전체 도서 목록 출력 성공을 알리는 메서드, 구현완료 
		if(bc.selectList()!=null)
			System.out.println(bc.selectList());
		else
			System.out.println("존재하는 도서가 없습니다.");
	}
	public void searchBook() { // 특정도서 검색 결과를 보여주는 메서드, 구현완료 
		sc.nextLine();
		System.out.print("키워드를 입력하세요:");
		String keyword=sc.nextLine();
		List<Book> tmp=bc.searchBook(keyword);
		try {
		tmp.get(0);
		System.out.println(tmp);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("일치하는 도서가 없습니다.");
		}
	}
	public void deleteBook() { // 특정도서 삭제 성공을 알리는 메서드 , 구현완료 
		String title,author;
		sc.nextLine();
		System.out.print("삭제할 도서명:");
		title=sc.nextLine();
		System.out.print("저자명 입력:");
		author=sc.nextLine();
		Book tmp=bc.deleteBook(title,author);
		if(tmp==null)
			System.out.println("삭제할 책이 없습니다.");
		else
			System.out.println("책을 성공적으로 삭제하였습니다.");
	}
	public void ascBook() { //정렬 성공을 알리는메서드 추후에 구현한다.
		//TODO
	}
}
