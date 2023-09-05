class FrontMiddleBackQueue {
    class Node{
        Node next,prev;
        int val;
        Node(int val){
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }
    Node head,tail,mid;
    int sz;
    public FrontMiddleBackQueue() {
        this.head=new Node(-1);
        this.tail=new Node(-1);
        this.head.next=tail;
        this.tail.prev=head;
        this.mid=head;
        this.sz=0;
    }
    
    public void pushFront(int val) {
        Node node=new Node(val);
        node.next=head.next;
        node.next.prev=node;
        node.prev=head;
        head.next=node;
        if(sz==0){
            mid=node;
        }
        else if(sz%2==1){
            mid=mid.prev;
        }
        sz++;
    }
    
    public void pushMiddle(int val) {
        if(sz==0){
            pushFront(val);
        }
        else{
            Node node=new Node(val);
            if(sz%2==1){
                mid.prev.next=node;
                node.prev=mid.prev;
                node.next=mid;
                mid.prev=node;
            }
            else{
                node.next=mid.next;
                mid.next=node;
                node.prev=mid;
                node.next.prev=node;
            }
            mid=node;
            sz++;
        }

    }
    
    public void pushBack(int val) {
        if(sz==0){
            pushFront(val);
        }
        else{
            Node node=new Node(val);
            tail.prev.next=node;
            node.prev=tail.prev;
            node.next=tail;
            tail.prev=node;
            if(sz%2!=1){
                mid=mid.next;
            }
            sz++;
        }


    }
    public int popFront() {
        if(sz==0)return -1;
        int x=head.next.val;
        if(sz%2==0){
            mid=mid.next;
        }
        head.next=head.next.next;
        head.next.prev=head;
        sz--;
        return x;
    }
    
    public int popMiddle() {
        if(sz==0)return -1;
        int m=mid.val;
        Node temp=mid;
        if(sz%2==1){
            mid=mid.prev;
        }
        else{
            mid=mid.next;
        }
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        sz--;
        return m;
    }
    
    public int popBack() {
        if(sz==0)return -1;
        int x=tail.prev.val;
        if(sz%2!=0){
            mid=mid.prev;
        }
        tail.prev=tail.prev.prev;
        tail.prev.next=tail;
        sz--;
        return x;
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