class MyLinkedList {

    /** Initialize your data structure here. */
    ListNode head;
    ListNode tail;
    int size;
    public MyLinkedList() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next=tail;
        tail.prev=head;
        size=0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < size) {
            ListNode p = head.next;
            while(index > 0) {
                p=p.next;
                index--;
            }
            return p.val;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        head.next.prev = node;
        node.next=head.next;
        head.next=node;
        node.prev=head;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        tail.prev.next=node;
        node.prev=tail.prev;
        tail.prev=node;
        node.next=tail;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index <= size) {
            ListNode p = head.next;
            while(index > 0) {
                p=p.next;
                index--;
            }
            ListNode node = new ListNode(val);
            p.prev.next=node;
            node.prev=p.prev;
            p.prev=node;
            node.next=p;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < size) {
            ListNode p = head.next;
            while(index > 0) {
                p=p.next;
                index--;
            }
            p.prev.next=p.next;
            p.next.prev=p.prev;
            size--;
        }
    }
    
    class ListNode {
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
