class FrontMiddleBackQueue {
    LinkedList<Integer>queue;
    public FrontMiddleBackQueue() {
        queue = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        queue.add(0,val);
    }
    
    public void pushMiddle(int val) {
        int n = queue.size();
        int mid = (n) / 2;
        queue.add(mid , val);     
    }
    
    public void pushBack(int val) {
        queue.addLast(val);
    }
    
    public int popFront() {
        if(queue.isEmpty())
        {
            return -1;
        }
        return queue.removeFirst();
    }
    
    public int popMiddle() {
        if(queue.isEmpty())
        {
            return -1;
        }
        int n = queue.size();
        int mid = (n - 1) / 2;
        int pm = queue.remove(mid);
        return pm;
    }
    
    public int popBack() {
         if(queue.isEmpty())
        {
            return -1;
        }
       int pb =  queue.removeLast();
       return pb;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */