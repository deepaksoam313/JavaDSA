package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversals {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
               return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root){
        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root){
        if(root == null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrderTraversal(Node root){
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }

            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null)
                    q.add(currNode.left);
                if(currNode.right != null)
                    q.add(currNode.right);
            }
        }
    }

    // method for count fo nodes for a tree
    public static int countOfNodes(Node root){
        if(root == null)
            return 0;

        int countOfLeftSubTree = countOfNodes(root.left);
        int countOfRightSubTree = countOfNodes(root.right);

        return countOfLeftSubTree + countOfRightSubTree + 1;
    }

    //method to calculate sum of the nodes
    public static int sumOfNodes(Node root){
        if(root == null)
            return 0;

        int sumOfLeftSubTree = sumOfNodes(root.left);
        int sumOfRightSubTree = sumOfNodes(root.right);

        return sumOfLeftSubTree + sumOfRightSubTree + root.data;
    }

    public static void level(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr =  q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else{
                System.out.print(curr.data + " ");
                if(curr.left != null)
                    q.add(root.left);
                if(curr.right != null)
                     q.add(curr.right);
            }

        }
    }

    //method to calculate height of the tree
    public static int heightOfTree(Node root){
        if(root == null)
            return 0;

        int heightOfLeftSubTree = heightOfTree(root.left);
        int heightOfRightSubTree = heightOfTree(root.right);
        int height = Math.max(heightOfLeftSubTree, heightOfRightSubTree) + 1;

        return height;
    }

    //Diameter of Tree
    public static int diameterOfTree(Node root){
        if(root == null)
            return 0;

        int diameter1 = diameterOfTree(root.left);
        int diameter2 = diameterOfTree(root.right);
        int diameter3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diameter3, Math.max(diameter2, diameter1));
    }


    public static void main(String[] args) {

        int[] nodes = new int[] {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        //System.out.println(root.data);

        System.out.println("-----PreOrder--------");
        preOrderTraversal(root);
        System.out.println("\n-----InOrder--------");
        inOrderTraversal(root);
        System.out.println("\n-----PostOrder--------");
        postOrderTraversal(root);
        System.out.println("\n-----LevelOrder--------");
        levelOrderTraversal(root);

        System.out.println("\n -------Count of Nodes in the tree---------");
        System.out.println(countOfNodes(root));

        System.out.println("\n -------Sum of Nodes in the tree---------");
        System.out.println(sumOfNodes(root));

        System.out.println("\n -------Height of the tree---------");
        System.out.println(heightOfTree(root));

        System.out.println("\n -------Diameter of the tree---------");
        System.out.println(diameterOfTree(root));
    }
}
