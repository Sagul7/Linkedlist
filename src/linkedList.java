class Node{
    public int data;
    public Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }

}
class ll {
    private Node head;
    private Node tail;
    private int length;

    public ll() {
        this.head = null;
        this.tail = null;
    }

    public void Append(int data) {
    Node newnode = new Node(data);
    if(length==0)
    {
        head = newnode;
        tail = newnode;
    }
    else{
        tail.next = newnode;
        tail = newnode;
    }
    length++;
    }

    public void prepend(int data)
    {
        Node newnode = new Node(data);
        if(length==0)
        {
            head = newnode;
            tail = newnode;
        }
        else{
            newnode.next = head;
            head = newnode;
        }
        length++;
    }
    public void  deleteFirst()
    {
        if(length==0)
        {
            System.out.println("No elements in list");
        }
        else {
            int val = head.data;
            head = head.next;
            length--;
        }
        System.out.println();
    }
    public void deleteLast()
    {
        if(length<=1) {
            deleteFirst();
        }
        else {
            Node temp = head;
            Node prev = head;
            if (length <= 1) {
                deleteFirst();
            }
            while(temp.next!=null)
            {
                prev = temp;
                temp = temp.next;
            }
            tail = prev;
            tail.next = null;
            length--;
        }
        System.out.println();
    }
    public int deleteIndex(int index)
    {
        if(index==0)
        {
            deleteFirst();
        }
        if(index==length-1)
        {
            deleteLast();
        }
        Node prev = getNode(index-1);
        int val = prev.next.data;
        prev.next = prev.next.next;
        length--;
        return val;

    }
    public Node getNode(int index)
    {
        if(index<0 || index>=length)
        {
            System.out.println("enter vaild index");

        }
        if (index == 0) {
            return head; // Special case when index is 0.
        }
        Node temp = head;
        for(int i=0;i<index-1;i++)
        {
            temp = temp.next;
        }

        return temp;
    }

    public void print()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+" -->");
            temp = temp.next;
        }
        System.out.print("end");
    }
}
public class linkedList {
    public static void main(String[] args) {
        ll list = new ll();

        list.prepend(80);
        list.prepend(58);
        list.prepend(8);
        list.Append(99);
        list.print();
        System.out.println();
        list.deleteIndex(2);
        list.print();
        System.out.println();
        Node x =list.getNode(2);
        System.out.println(x.data);
        list.deleteFirst();
        list.print();
        System.out.println();
        list.deleteLast();
        list.print();
        list.getNode(2);
    }
}
