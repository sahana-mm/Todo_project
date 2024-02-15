package todo;

public class Record {
    private String title;
    private String description;
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	@Override
    public String toString() {
       return "Record [title="+title+",description="+description+"]";
	}

}
