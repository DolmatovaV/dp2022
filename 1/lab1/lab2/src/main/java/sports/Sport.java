package sports;
import java.io.Serializable;

public class Sport implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private float price;
	private String desc;
	
	public Sport(String title, float price, String desc) {
		super();
		this.title = title;
		this.price = price;
		this.desc = desc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
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
		  return "{\"title\": \""+title+"\",\"price\": "+price+", \"desc\": \""+desc+"\"}";
	}
	
	
}