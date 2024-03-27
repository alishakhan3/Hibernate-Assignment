package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private long empID;

	private String empName;
	private String empEmail;
	public long getEmpID() {
		return empID;
	}
	public void setEmpID(long empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	@Override
	public String toString() {
		return "employee [empID=" + empID + ", empName=" + empName + ", empEmail=" + empEmail + "]";
	}
	

}
