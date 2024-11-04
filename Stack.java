package Task_01;

public class Stack<T> {
	
	private class Node{
		T data;
		Node next;
		
		Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node top = null;
	
	// add elements
	public void push(T value) {
		top = new Node(value, top);
	}
	
	// remove elements
	public T pop() {
		if(isEmpty()) {
			throw new IllegalStateException("stack is empty");
		}
		T value = top.data;
		top = top.next;
		return value;
	}
	
	//check if our stack is empty
	public boolean isEmpty() {
		return top == null;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("Popped: " + stack.pop()); // Очікуємо 30
        System.out.println("Popped: " + stack.pop()); // Очікуємо 20
        System.out.println("Popped: " + stack.pop()); // Очікуємо 10

        System.out.println("Is stack empty? " + stack.isEmpty());

        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

