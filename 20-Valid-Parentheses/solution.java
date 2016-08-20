//用Askii码或者hashmap
// public class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stk = new Stack<Character>();
//         for(int i = 0; i < s.length(); i++) {
//             if(!stk.isEmpty() && (s.charAt(i) - stk.peek() == 1 || s.charAt(i) - stk.peek() == 2)) {
//                 stk.pop();
//             } else {
//                 stk.push(s.charAt(i));
//             }
//         }
        
//         return stk.isEmpty();
//     }
// }

//利用hashmap
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character,Character>();
        
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ) {
                stk.push(s.charAt(i));
            } 
            
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if(stk.isEmpty() || s.charAt(i) != map.get(stk.pop())) {
                    return false;
                }
            }
        }
        
        return stk.isEmpty();
    }
}