public class MinStack {
    Stack<Integer> s;
    Stack<Integer> minS;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack();
        minS = new Stack();
    }
    
    public void push(int x) {
        s.push(x);
        if(minS.isEmpty() || x <= minS.peek()) {
            minS.push(x);
        }
    }
    
    public void pop() {
       int num = s.pop();
       if(!minS.isEmpty() || minS.peek() == num) {
           minS.pop();
       }
    }
    
    public int top() {
        if(!s.isEmpty()) {
            return s.peek();
        } else {
            return 0;
        }
    }
    
    public int getMin() {
        if(!minS.isEmpty()) {
            return minS.peek();
        } else {
            return 0;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */