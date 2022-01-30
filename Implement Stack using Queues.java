class MyStack {
    //using single queue
    Queue < Integer > q = new LinkedList < > (); 
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);//add element into queue
        for (int i = 0; i < q.size() - 1; i++) { //run a loop till size - 1
            q.add(q.remove()); //remove top element and add again in a queue
        }
    }
    
    public int pop() {
         return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
