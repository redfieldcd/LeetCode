class MyStack {
    // Push element x onto stack.
    
    Queue<Integer> q = new LinkedList();
    
    public void push(int x) {
        q.offer(x);
        for(int i = 1; i < q.size(); i++) {
            q.add(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!q.isEmpty()) {
           q.poll(); 
        }
        
    }

    // Get the top element.
    public int top() {
        q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.size() == 0;
    }
}