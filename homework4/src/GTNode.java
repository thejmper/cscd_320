/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public interface GTNode {
  public Object value();
  public boolean isLeaf();
  public GTNode parent();
  public GTNode leftmostChild();
  public GTNode rightSibling();
  public void setValue(Object value);
  public void setParent(GTNode par);
  public void insertFirst(GTNode n);
  public void insertNext(GTNode n);
  public void removeFirst(); // remove first child
  public void removeNext();  // remove right sibling
} 
