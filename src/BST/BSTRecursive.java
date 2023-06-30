package BST;

import java.util.ArrayList;

public class BSTRecursive {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int d){
            this.data = d;
            left = right = null;
        }
    }

    public static Node BSTcreate(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(root.data > value){
            //left subtree
            root.left = BSTcreate(root.left, value);
        }
        else{
            //right subtree
            root.right = BSTcreate(root.right, value);
        }
        return root;
    }

    //Inorder traversal
    public static void inorder(Node root){
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    //search
    public static Boolean search(Node root, int value){
        if(root == null){
            return false;
        }
        if(value < root.data){
            return search(root.left, value);
        }
        else if( value == root.data){
            return true;
        }
        else{
            return search(root.right, value);
        }
    }

    public static Node deleteNode(Node root , int val){
        if(root.data > val){
            root.left = deleteNode(root.left, val);
        }
        else if(root.data < val ){
            root.right = deleteNode(root.right, val);
        }
        else{//(root.data == val)

            //Case 1
            if(root.left == null && root.right == null){
                return null;
            }

            // Case 2
            if(root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);

        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int X, int Y){
        if(root == null){
            return;
        }

        //1st condition
        if(root.data >= X && root.data <= Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data +" ");
            printInRange(root.right, X, Y);
        }
        // 2nd condition
        else if(root.data >= Y){
            printInRange(root.left, X, Y);
        }
        else{
            printInRange(root.right, X, Y);
        }
    }

    public static void root2LeafPath(Node root, ArrayList<Integer> path){
        if(root == null)
            return;

        path.add(root.data);
        //Leaf condition
        if(root.left == null && root.right == null){
            printPath(path);
        }else{//Non leaf
            root2LeafPath(root.left, path);
            root2LeafPath(root.right, path);
        }
        path.remove(path.size() -1);
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};
        Node root = null;
        for(int i=0; i<values.length; i++){
            root = BSTcreate(root, values[i]);
        }

        inorder(root);
        System.out.println();

//        if(search(root,8))
//            System.out.println("value found");
//        else
//            System.out.println("value not found");

//        deleteNode(root, 7);
//        inorder(root);
        //printInRange(root, 2,4);

        root2LeafPath(root, new ArrayList<>());

    }
}
