public class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new LinkedList();
        search(num, target, 1, num.charAt(0) + "", num.charAt(0) - '0', num.charAt(0) - '0');
        return res;
    }
    
    public void search(String num, int target, int index, String path, int value, int mul) {
        // System.out.println(path + " "  + value + " " + mul);
        if(index == num.length() && value == target) {
            res.add(path);
            return;
        }
        
        if(index >= num.length()) return;
        
        char c = num.charAt(index);
        int n = c - '0';
        int sum = value + n;
        int div = value - n;
        search(num, target, ++index, path + "+" + c, sum, n);
        index--;
        search(num, target, ++index, path + "-" + c, div, -n);
        index--;
        search(num, target, ++index, path + "*" + c, (value - mul) + mul * n, mul * n);
    }
}