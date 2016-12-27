package ctci.stacksandqueues;

public class MinStack {
	
	StackNode[] stack;
	int top;
	
	public MinStack(int size) {
		stack = new StackNode[size];
		top = -1;
	}
	
	public void push(int data) throws Exception{
		if(top + 1 > stack.length - 1){
			throw new Exception("stack is full!");
		} else {
			StackNode min;
			StackNode curr = new StackNode(data);
			if(top >= 0){
				StackNode currTop = stack[top];
				min = (currTop.min.data < data) ? currTop.min : curr;
			} else {
				min = curr;
			}
			curr.min = min;
			stack[++top] = curr;
		}
	}
	
	public int pop() throws Exception{
		if(top < 0){
			throw new Exception("stack is empty");
		} else {
			StackNode result = stack[top];
			stack[top] = null;
			top--;
			return result.data;
		}
	}
	
	public int min(){
		return stack[top].min.data;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int currI = top;
		while(currI >= 0){
			sb.append(stack[currI--].data + " ");
		}
		
		return sb.toString();
	}




	class StackNode{
		int data;
		//min up to current node
		StackNode min;
		
		public StackNode(int data){
			this.data = data;
		}
		
		public StackNode(int data, StackNode min){
			this.data = data;
			this.min = min;
		}
		
		@Override
		public String toString(){
			return data + " - " + ((min != null) ? min.data + "" : "null");
		}
	}
}
