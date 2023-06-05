package com.kh.practice.list.library.model.vo;

public class Book {
	private String title;
	private String author;
	private String category;
	private int price;
	public Book() {
		super();
	}
	public Book(String title, String author, String category, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int hashCode() {
		return this.hashCode();
	}
	public boolean equals(Book A) {  // Book객체를 기준으로 두가지가 동일한지를 검사하는 메서드 
		if(this==A)
			return true;
		else 
			return false;
		}
	public int compareTo(Object o) {   //도서명과 작가이름이 같으면 같은 책으로 보고 1을반환, 아닐경우 0을 반환
		if((this.getTitle()==((Book)o).getTitle()) &&(this.getAuthor()==((Book)o).getAuthor()))
			return 1;
		else
			return 0;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price + "]";
	}
}
