package Day17;

public class StackUsingArray<T> {
//	top 9
// [1 2 3 4 5 6 7 8 9 12] temp
//	
	
	private int data[];
	private int top;
	
	public StackUsingArray() {
		data = new int[10];
		top = -1;
	}
	
	public StackUsingArray(int capacity) {
		data = new int[capacity];
		top =-1;
	}
	
	public  boolean isEmpty() {
		return (top == -1); 
	}
	
	public int size() {
		return top + 1;
	}
	
	public int top() throws StackEmptyException   {
		if(size() == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		return data[top];
	}
	
	
	
	private void doubleCapacity() {
		int temp[] = data;
		
		data = new int[data.length*2];
		for(int i=0;i<=top;i++) {
			data[i]=temp[i];
		}
	}
	 
	
	public void push(int elem)  {
		if(size()== data.length) {
			doubleCapacity();
		}
		
		top++;
		data[top]= elem;
		
	}
	
	public int pop() throws StackEmptyException {
		if(size() == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		int temp = data[top];
		top--;
		return temp;
	}

}
