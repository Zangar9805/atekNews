
public class Articles {
	private String title;
	private String date;
	private String url;
	
	public Articles(String title, String date, String url) {
		super();
		this.title = title;
		this.date = date;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	@Override
	public String toString() {
		return title + ";" + date + ";" + url + ";";
	}
	
	

}
