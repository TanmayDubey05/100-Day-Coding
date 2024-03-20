/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node nhead=new Node(head.val);
        Node tail=nhead,temp=head.next;
        HashMap<Node,Node> map=new HashMap<>();
        map.put(head,nhead);
        while(temp!=null){
            Node x=new Node(temp.val);
            tail.next=x;
            tail=x;
            map.put(temp,x);
            temp=temp.next;
        }
        Node t=nhead;
        while(head!=null){
            if(head.random!=null){
                t.random=map.get(head.random);
            }
            t=t.next;
            head=head.next;
        }
        return nhead;
    }
}