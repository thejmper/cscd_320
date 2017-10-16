/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class Tester {
    
    public static void main(String[] args){
        
        //first construct a tree that looks like this
        //      r
        //    /    \
        //    a     b
        //  / | \
        //  c d e
        
        GenTree myTree = new Tree();
        GTNode root = myTree.newroot("r");
        
        //create child nodes
        GTNode aNode = new Node("a");
        GTNode bNode = new Node("b");
        GTNode cNode = new Node("c");
        GTNode dNode = new Node("d");
        GTNode eNode = new Node("e");
        GTNode fNode = new Node("f");
        
        //link up subtree!
        aNode.insertNext(cNode);
        aNode.insertNext(dNode);
        aNode.insertNext(eNode);
        
        bNode.insertNext(fNode);
        
        //link up to main tree!
        root.insertNext(aNode);
        root.insertNext(bNode);
        
        //print off breadth-first traversal!
        myTree.breadthFirstTraversal();
        
        
        
    }
}
