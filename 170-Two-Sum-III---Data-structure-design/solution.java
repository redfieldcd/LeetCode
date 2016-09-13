// public class TwoSum {
//     List<Integer> list = new ArrayList();
//     // Add the number to an internal data structure.
// 	public void add(int number) {
// 	   list.add(number);
// 	}

//     // Find if there exists any pair of numbers which sum is equal to the value.
// 	public boolean find(int value) {
// 	    Collections.sort(list);
// 	    int left = 0, right = list.size() - 1;
// 	    while(left < right) {
// 	        int sum = list.get(left) + list.get(right);
// 	        if(sum == value) {
// 	            return true;
// 	        } else if(sum < value) {
// 	            left++;
// 	        }  else {
// 	            right--;
// 	        }
// 	    }
	    
// 	    return false;
// 	}
// }

// time 有限制，要求O(n), 所以要牺牲一下空间,第一个数在list遍历，第二个数在hashmap中查找
public class TwoSum {
    List<Integer> list = new ArrayList();
    Map<Integer, Integer> map = new HashMap();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	   list.add(number);
	   if(map.containsKey(number)) {
	       map.put(number, map.get(number)+1);
	   } else {
	       map.put(number, 1);
	   }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(int i = 0; i < list.size(); i++) {
	        int num1 = list.get(i);
	        int num2 = value - num1;
	        if(((num1 == num2) && map.get(num1) > 1) || ((num1 != num2) && map.containsKey(num2))) {
	            return true;
	        }
	    }
	    return false;
	}
}



// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);