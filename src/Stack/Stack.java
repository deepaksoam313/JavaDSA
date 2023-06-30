package Stack;

import java.util.PriorityQueue;
import java.util.Queue;

public class Stack {
    public static int minElement = 0;
    Integer min;
    static class Node{
        int data;
        Node next;

        Node(int d){
            this.data = d;
            next = null;
        }
    }

    public static Node head = null;

    public static void push(int data){
        Node nodeObj = new Node(data);

        if(head == null){
            head = nodeObj;
            //minElement = data;
            return;
        }

        nodeObj.next = head;
        head = nodeObj;
    }

    public static void pop(){
        if(head == null){
            System.out.println("stack is Empty");
            return;
        }


        head = head.next;
    }

    public static void peek(){
        int peekValue = 0;

        Node current = head;
        peekValue = current.data;

        System.out.println("Peek value is : "+peekValue);
    }
    public static void display(){
        if(head == null)
            System.out.println("Stack is Empty");


        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }


    public static void main(String[] args) {
        //Queue<Integer> q = new PriorityQueue<>();



        push(10);
        push(20);
        push(30);
        //display();
        pop();
        display();
        peek();

    }
}
