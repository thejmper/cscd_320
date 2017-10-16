
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class Tree implements GenTree {

    
    //==Member Fields==//
    private GTNode root;
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GTNode root() {
        return root;
    }

    @Override
    public GTNode newroot(Object value) {
        this.root = new Node(value);
        return root;
    }

    @Override
    public void breadthFirstTraversal() {
        Queue<GTNode> queue = new LinkedList<>();
        if(this.root == null)
            return;
        
        System.out.print("{");
        
        queue.add(root);
        while(!queue.isEmpty()){
            GTNode node = queue.remove();
            System.out.print(node.value() + " ");
            
            for(GTNode child : node.children()){
                queue.add(child);
            }
        }
        System.out.println("}");
        
    }
    
}
