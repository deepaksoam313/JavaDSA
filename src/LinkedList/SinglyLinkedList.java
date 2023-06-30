package LinkedList;

class List{
    int data;
    List next;

    List(int data){
        this.data = data;
        next = null;
    }
}

public class SinglyLinkedList {

    static public List head = null;

    public static void addNode(int val){
        List newNode = new List(val);
        if(head == null){
            head = newNode;
            return;
        }
        List current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public static void printlist(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        List current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void insertAt(int pos, int val){
        List newNode = new List(val);
        if(head == null){
            head = newNode;
            return;
        }

    }

    public static void deleteLastNode(){
        if(head == null){
            System.out.println("List has no nodes");
            return;
        }
        List current = head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
    }

    public static void deleteNode(int position)
    {
        if(position == 0){
            head = head.next;
            return;
        }
        List prev = head;
        for(int i = 0; i < position-1; i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    public static int size(){
        if(head == null){
            return 0;
        }

        List current = head;
        int count = 0;
        while(current != null){
            count ++;
            current = current.next;
        }
        return count;
    }




    public static void main(String[] args) {
        addNode(10);
        addNode(20);
        addNode(30);

        //printlist();
        //System.out.println(size());
        //deleteLastNode();
        deleteNode(0);
        printlist();

    }
}

