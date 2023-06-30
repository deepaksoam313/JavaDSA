//1.  Design a stack that supports getMin() method.
package test;

import java.util.*;

public class test {

    public static int getMin(Stack<Integer> stack){
        int min = stack.pop();

        for(int i= 0; i<stack.size(); i++){
            int currentMin = stack.pop();
            if(currentMin < min){
                min = currentMin;
            }
        }


        return min;
    }


    public static void main(String[] args) {

//        Stack<Integer> stack = new Stack<Integer>();
//        Stack<Integer> emptyStack = new Stack<Integer>();
//        stack.push(2);
//        emptyStack.push(2);
//
//        stack.push(3);
//        emptyStack.push(3);
//
//        Collections.sort(emptyStack);
//        Collections.reverse(emptyStack);
//        int minEmptyStack = emptyStack.peek();
//
//        System.out.println(minEmptyStack);

        ArrayList<String> A = new ArrayList<>(){
            {
                add("ball");
                add("bat");
                //add("sticker");
                add("pen");
                //add("bat");
                add("books");
                add("FULL");
            }
        };

        String[] S1 = {"ball","bat","sticker"};
        int K = S1.length;
        String[] boxArray = new String[A.size()];

        for(int i=0; i<A.size(); i++){
            if(A.get(i) != "FULL"){
                boxArray[i] = A.get(i);
            }
            else
                break;
        }
        int count = 0;

        for (String s : S1) {

            for (String value : boxArray) {
                if (s == value)
                    count++;
            }
        }
        int result = (count*100)/K;

        System.out.println(result);
    }
}
