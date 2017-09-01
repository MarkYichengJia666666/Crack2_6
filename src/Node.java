/**
 * Created by jiayicheng on 17/7/21.
 */
public interface Node{
    class node{
    int data;
    node next;
    public node(int d)
    {
        data=d;
    }
    void appendToTail(int d)
    {
        node end=new node(d);
        node n=this;
        while(n.next!=null)
        {
            n=n.next;
        }
        n.next=end;
    }
}
}
