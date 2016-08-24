public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<String>();
        String[] parts = path.split("/");
        for(String part : parts){
            switch(part){
                case ".":
                case "" :
                    break;
                case "..":
                    if(!stk.isEmpty()){
                        stk.pop();
                    }
                    break;
                default:
                    stk.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stk.isEmpty()){
            return "/";
        }
        while(!stk.isEmpty()){
            sb.insert(0, "/"+stk.pop());
        }
        return sb.toString();
    }
}