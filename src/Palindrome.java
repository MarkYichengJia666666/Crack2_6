import javax.xml.soap.*;

/**
 * Created by jiayicheng on 17/7/21.
 */
public class Palindrome implements Node {
   class Node{
        int data;
        Node next;
       public Node(int d)
        {
            data=d;
        }
        void appendToTail(int d)
        {
            Node end=new Node(d);
            Node n=this;
            while(n.next!=null)
            {
                n=n.next;
            }
            n.next=end;
        }
    }

    class result{
        public Node next;
        public boolean result;
        void result(Node next,boolean result)
        {
            next =this.next;
            result=this.result;
        }
    }

    boolean isPalindrome(Node head)
    {
        int length=len(head);
        result res=recurse(head,length);
        return res.result;
    }

    result recurse(Node head,int length)   //首先找到中间元素，但要知道列表的长度。知道中间元素可以用来给每一个元素配对。
    {
        if(head==null||length<=0)
        {
            return new result(head,true);
        }
        else if(length==1)
        {
            return new result(head.next,true);   //为先进去再循环出来的方法，首当其冲是写到了最后的运算条件。
        }
         result res=recurse(head.next,length-2);//然后再写循环
        if(!res.result||res.next==null)//再写循环后自己要传给下面的运算。
        {//自己的运算也要注意终止条件！！！！！！！！
            return res;
        }
        res.result =(head.data==res.next.data);
        res.next=res.next.next;
        return res;
    }

    int len(Node n)
    {
        int len=0;
        while(n!=null)
        {
            len++;
            n=n.next;
        }
        return len;
    }
}
