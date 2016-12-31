package ctci.ood.callcenter;

import java.util.ArrayList;

public class CallCenter {
	ArrayList<Employee> respondents;

	public CallCenter() {
		respondents = new ArrayList<>();
	}

	public void dispatchCall(Call call) {
		Employee receiver = null;
		boolean notFoundRespondent = true;
		while (notFoundRespondent) {
			for (Employee curr : respondents) {
				if (curr.isAvailable()) {
					receiver = curr;
					receiver.setCall(call);
					receiver.setAvailablity(false);
					continue;
				}
			}
			notFoundRespondent = receiver == null;
		}
		if (receiver.shouldEscalate()) {
			receiver = escalateCall(receiver, call);
			if(receiver.shouldEscalate()){
				receiver = escalateCall(receiver, call);
			}
		}
	}

	private Employee escalateCall(Employee receiver, Call call) {
		receiver.setAvailablity(true);
		receiver.setCall(null);
		receiver = receiver.getSupervisor();
		receiver.setCall(call);		
		return receiver;
	}
}
