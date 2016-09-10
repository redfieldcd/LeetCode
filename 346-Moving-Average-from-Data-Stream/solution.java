public class MovingAverage {
    List<Integer> list;
    int n;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        list = new LinkedList();
        n = size;
    }
    
    public double next(int val) {
        list.add(val);
        if(list.size() < n) {
            int sum = 0;
            for(int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            
            return (double)sum / (double)list.size();
        } else {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sum += list.get(list.size()-1- i);
            }
            
            return (double)sum / (double)n;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */