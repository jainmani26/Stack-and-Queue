class MyStack {
    //using single queue
    Queue < Integer > q = new LinkedList < > (); 
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);//Push the element in the queue.
        for (int i = 0; i < q.size() - 1; i++) { //run a loop till size - 1
            q.add(q.remove()); //remove element from queue and again push back to the queue, hence the most recent element becomes the most former element and vice versa.
        }
    }
    
    public int pop() {
         return q.remove(); // remove the element from the queue.
    }
    
    public int top() {
        return q.peek(); //show the element at the top of the queue.
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
