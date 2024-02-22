package giadung.webmvc.model;

public class Banner {
	private String id;
	private String name;
	private String note;
	private String img;
	public Banner() {
		super();
	}
	public Banner(String id, String name, String note, String img) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.img = img;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Banner [id=" + id + ", name=" + name + ", note=" + note + ", img=" + img + "]";
	}

	
}
