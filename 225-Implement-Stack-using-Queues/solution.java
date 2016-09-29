class MyStack {
    // Push element x onto stack.
    
    Queue<Integer> q = new LinkedList();
    
    public void push(int x) {
        q.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!q.isEmpty()) {
           q.removeLast(); 
        }
        
    }

    // Get the top element.
    public int top() {
        q.peekLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.size() == 0;
    }
}