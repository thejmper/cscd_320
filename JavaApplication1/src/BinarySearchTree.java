
import java.util.ArrayList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class BinarySearchTree {
    /*--member fields--*/
    private Node rootNode;
    
    public BinarySearchTree(){
        this.rootNode = null;
    }
    
    
    /**
     * inserts a new item into the BST
     */
    public void insert(Comparable item){
        if(this.rootNode == null)
            this.rootNode = new Node(item);
        else
            this.rootNode.add(item);

    }
    /**
     * Prints each path recursivly.
     */
    public void printAllPath(){
        if(rootNode == null){
            System.out.println("BST is empty!");
            return;
        }

        printAllPathInner(rootNode, new ArrayList());
    }
    public void printAllPathInner(Node node, ArrayList path){
        if(node == null)
            return;

        path.add(node.data);
        if(node.left == null && node.right == null){
            System.out.println(path); 
            return;
        }
        else {
            printAllPathInner(node.left, new ArrayList(path));
            printAllPathInner(node.right, new ArrayList(path));
        }
    }
    /**
     * Prints each path non-recursivly.
     */
    public void printAllPath2(){
        if(rootNode == null){
            System.out.println("BST is empty!");
            return;
        }
        
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> visited = new ArrayList<>();
       
        stack.push(rootNode);
        
        while(!stack.isEmpty()){
            Node curr = stack.peek();
            visited.add(curr);
            
            
            if(curr.left != null && !visited.contains(curr.left)){
                stack.push(curr.left);
            }
            else if(curr.right != null && !visited.contains(curr.right)){
                stack.push(curr.right);
            }
            else if((curr.right != null && visited.contains(curr.right)) ||(curr.left != null && visited.contains(curr.left)))
            {
                stack.pop();
            }
            else{
                System.out.println(stack);
                stack.pop();     
            }
            
        }        
    }
    
    
    /**
     * internal node class
    */
    private class Node{
        //data living on this node
        public Comparable data;
        //left (smaller) node
        public Node left;
        //right (greater) node.
        public Node right;
        
        public Node(Comparable data){
            this.data = data;
        }
        
        public void add(Comparable data){
            //are we thie item?
            if(data == this. data)
                return;
            //is the item smaller than us?
            else if (data.compareTo(this.data) < 0){
                if(left != null)
                    left.add(data);
                else
                    left = new Node(data);
            }
            //is the item greater than us?
            else if (data.compareTo(this.data) > 0){
                if(right != null)
                    right.add(data);
                else 
                    right = new Node(data);
            }
        }
    
        @Override
        public String toString(){
            return this.data.toString();
        }
    }
}
