package ctci.ood.callcenter;

public class Call {
	String customerName;
	String subject;
	
	public Call(String name, String subject){
		customerName = name;
		this.subject = subject;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
