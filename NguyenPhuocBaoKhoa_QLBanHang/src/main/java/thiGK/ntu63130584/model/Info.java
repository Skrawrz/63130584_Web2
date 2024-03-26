package thiGK.ntu63130584.model;

public class Info {
	private String picture;
	private String name;
	private String ttin;
	public Info() {
		
	}
	public Info(String picture, String name, String ttin) {
		this.picture = picture;
		this.name = name;
		this.ttin = ttin;
	}
	public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTtin() {
        return ttin;
    }

    public void setTtin(String ttin) {
        this.ttin = ttin;
    }
}
