package org.jss.entity;

public class book {
    private int book_id;
    private String title;
    private String author;
    private String publish;
    private int copies;
    private String category;
	
    public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
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
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public book(int book_id, String title, String author, String publish, int copies, String category) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.publish = publish;
		this.copies = copies;
		this.category = category;
	}
	public book(int book_id) {
		super();
		this.book_id = book_id;
	}
	
	
}
