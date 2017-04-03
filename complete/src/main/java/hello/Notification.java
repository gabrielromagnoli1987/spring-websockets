package hello;

public class Notification {
	
	private String name;
    private String content;
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Notification() {
    }

    public Notification(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
