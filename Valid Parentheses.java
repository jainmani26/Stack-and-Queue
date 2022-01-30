public boolean isValid(String s) 
    {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            
            if(ch == ')'){
                if(stk.isEmpty()) return false;
                if(s.charAt(stk.peek()) == '(')
                    stk.pop();
                else return false;
            }
            else if (ch == '}'){
                if(stk.isEmpty()) return false;
                if(s.charAt(stk.peek()) == '{')
                    stk.pop();
                else return false;
            }
            else if(ch == ']'){
                if(stk.isEmpty()) return false;
                if(s.charAt(stk.peek()) == '[')
                    stk.pop();
                else return false;
            }
            else{
               stk.push(i); 
            }
        }
        if(stk.size() == 0)
            return true;
        return false;
    }
