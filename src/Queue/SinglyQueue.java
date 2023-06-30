package Queue;

public class SinglyQueue {
    static class Queue{
        int data;
        Queue next;

        Queue(int d){
            this.data = d;
            next = null;
        }
    }

    static Queue front = null;
    static Queue rear = null;

    //Push Operation
    public static void push(int data){
        Queue newNode = new Queue(data);
        if(front == null && rear == null){
            front = rear= newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    //Pop operation
    public static void pop(){
        if(front == null && rear == null){
            System.out.println("Queue is underflow");
            return;
        }

        front = front.next;
    }

    //Display Operation
    public static void display(){
        if(front == null && rear == null){
            System.out.println("Queue is Empty");
            return;
        }

        Queue current = front;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {


        push(10);
        push(20);
        push(15);
        push(30);
        display();
        System.out.println("pop operation");
        pop();

        display();

    }
}
