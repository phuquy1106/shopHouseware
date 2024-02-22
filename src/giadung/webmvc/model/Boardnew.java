package giadung.webmvc.model;


public class Boardnew {
	private String id;
	private String title;
	private String content;
	private String image_link;
	private String created;
	
	public Boardnew() {
		super();
	}
	public Boardnew(String id, String title, String content,String image_link, String created) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.image_link = image_link;
		this.created = created;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Boardnew [id=" + id + ", title=" + title + ", content=" + content + ", image_link=" + image_link
				+ ", created=" + created + "]";
	}
	
}
