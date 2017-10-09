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
        BinarySearchTree myBst = new BinarySearchTree();
        
        myBst.insert(8);
        
        myBst.insert(3);
        myBst.insert(10);
        
        myBst.insert(1);
        myBst.insert(6);
        myBst.insert(14);
        
        myBst.insert(4);
        myBst.insert(7);
        myBst.insert(13);
        
        System.out.println("Testing printAllPath!");
        myBst.printAllPath();
        
        System.out.println("Testing printAllPath2!");
        myBst.printAllPath2();
    }
}

