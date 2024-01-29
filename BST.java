import java.util.ArrayList;

import static java.lang.Math.max;

public class BST {

    private class Node{
        private int value;
        private Node left, right;

        public Node(int input){
            value = input;
            left = right = null;
        }
    }
    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    private void insertNode(Node curr, int valToInsert){
        if(curr == null){
            return;
        }

        if(curr.value > valToInsert && curr.left == null){
            curr.left = new Node(valToInsert);
        }else if(curr.value < valToInsert && curr.right == null){
            curr.right = new Node(valToInsert);
        }
        else if(curr.value > valToInsert){
            insertNode(curr.left, valToInsert);
        }
        else if(curr.value < valToInsert)
        {
            insertNode(curr.right, valToInsert);
        }
    }

    private void travTree(Node curr){
        if(curr == null){
            return;
        }

        travTree(curr.left);
        System.out.print(curr.value + " ");
        travTree(curr.right);
    }

    private void goToLeaf(ArrayList<Integer> l, Node curr){
        if(curr == null){
            return;
        }

        if(curr.left == null && curr.right == null)
        {
            l.add(curr.value);
        }
        goToLeaf(l,curr.left);
        goToLeaf(l, curr.right);
    }

    public void addNode(int input){
        if(root != null){
            insertNode(root, input);
        }
        else
        {
            root = new Node(input);
        }
        size++;
    }
    public int getRoot(){
        return root.value;
    }

    private int depth(Node currNode){
        if(currNode == null)
        {
            return 0;
        }
        return max(depth(currNode.left), depth(currNode.right)+1);
    }

    public int getMaxHeight(){
        return depth(root);
    }

    public ArrayList<Integer> getLeafs(){
        ArrayList<Integer> l = new ArrayList<>();
        goToLeaf(l,root);

        return l;
    }


    public int getSize(){
        return size;
    }

    public void printTree(){
        if(size == 0){
            System.out.println("The tree is empty");
        }
        else
        {
            System.out.println("Current tree elements:");
            travTree(root);
        }
    }



}
