package lab5.sport;

import java.io.Serializable;

public class Sport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String title;
	private int price;
	private String desc;
	
	public Sport(int id,String title, int f, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.price = f;
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "{\"id\": \""+id+"\",\"title\":\""+title+"\",\"price\":"+price+", \"desc\":\""+desc+"\"}";
	}
}
