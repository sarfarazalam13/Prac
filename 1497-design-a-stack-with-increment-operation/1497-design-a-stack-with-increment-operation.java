class CustomStack {
    int[] stack;
    int currIndex;
    int maxSize;
    public CustomStack(int maxSize) {
        this.currIndex = 0;
        this.stack = new int[maxSize];
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (currIndex < maxSize) {
            stack[currIndex++] = x;
        }  
    }
    
    public int pop() {
        if (currIndex == 0) return -1;
        return stack[--currIndex];
    }
    
    public void increment(int k, int val) {
        k = Math.min(k, maxSize);
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */