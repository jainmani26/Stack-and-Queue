class MyQueue {

    Stack<Integer> Input = new Stack<>();
    Stack<Integer> Output = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        Input.push(x);//push element into input stack
    }
    
    public int pop() {
        if(!Output.isEmpty()){
            return Output.pop(); //if output stack is not empty return output's top 
        }
        else{
            while(!Input.isEmpty()){
                Output.push(Input.peek()); //insert element one by one from input to output stack
                Input.pop();//remove element from input stack after pushing into output stack
            }
            return Output.pop(); //now output stack is no more empty , return top of output stack
        }
        
    }
    
    public int peek() {
        if(!Output.isEmpty()){
            return Output.peek();
        }
        else{
            while(!Input.isEmpty()){
                Output.push(Input.peek());
                Input.pop();
            }
            return Output.peek();
        }
        
    }
    
    public boolean empty() {
        return Input.isEmpty() && Output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
