public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int Capacity;
    
    public LRUCache(int capacity) {
        this.Capacity =  capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        // if(map.contains(key)) return map.get(key);
        // else return -1;
        return map.getOrDefault(key, -1);
    }
    
    public void set(int key, int value) {
        map.put(key, value);
    }
}