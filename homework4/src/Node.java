
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class Node implements GTNode {

    //==member fields==//
    private GTNode parent;
    private GTNode rightSibling;
    private Object data;
    private ArrayList<GTNode> children;
    
    //==================================
    public Node(Object data){
        this.data = data;
        this.children = new ArrayList<>();
    }
    //==================================
    
    @Override
    public Object value() {
        return this.data;
    }

    @Override
    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    @Override
    public GTNode parent() {
        return this.parent;
    }

    @Override 
    public List<GTNode> children(){
        return this.children;
    }
    
    @Override
    public GTNode leftmostChild() {
        if(this.children.isEmpty())
            return null;
        
        return this.children.get(0);
    }

    @Override
    public GTNode rightSibling() {
        return this.rightSibling;
    }

    @Override
    public void setValue(Object value) {
        this.data = value;
    }

    @Override
    public void setParent(GTNode par) {
        this.parent = par;
    }

    @Override
    public void setRightSibling(GTNode sib){
        this.rightSibling = sib;
    }
    
    @Override
    public void insertFirst(GTNode n) {
    
        if(this.isLeaf()){
            insertFirst(n);
            return;
        }
        
        this.children.set(0, n);
         n.setParent(this);
         
         if(this.children.size() > 1)
             n.setRightSibling(this.children.get(1));
    }

    @Override
    public void insertNext(GTNode n) {
        this.children.add(n);
        n.setParent(this);
        
        if(this.children.size() > 2){
            GTNode oldRight = this.children.get(this.children.size() -2);        
            oldRight.setRightSibling(n);
        }
    }
    
    @Override
    public void removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
