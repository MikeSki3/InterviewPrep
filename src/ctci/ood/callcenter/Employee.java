package ctci.ood.callcenter;

public class Employee {
	Level level;
	Employee supervisor;
	String name;
	boolean available;
	boolean escalate;
	Call currentCall;
	
	public Employee(Level level, Employee supervisor, String name) {
		this.level = level;
		this.supervisor = supervisor;
		this.name = name;
		this.available = true;
		this.escalate = false;
	}
	
	public enum Level{
		RESPONDENT, MANAGER, DIRECTOR
	}
	
	public Employee getSupervisor(){
		return supervisor;
	}
	
	public boolean isAvailable(){
		return available;
	}
	
	public void setAvailablity(boolean available){
		this.available = available;
	}
	
	public void setCall(Call call){
		this.currentCall = call;
	}
	
	public Call getCall(){
		return currentCall;
	}
	
	public boolean shouldEscalate() {
		return escalate;
	}

	public void setEscalate(boolean escalate) {
		this.escalate = escalate;
	}
}
