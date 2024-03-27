package entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class name {
	String fname;
	String lname;
	String mname;
	public name(String fname, String lname, String mname) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mname = mname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}

	
}
