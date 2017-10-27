/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public interface GenTree {
  public void clear();
  public GTNode root();
  public GTNode newroot(Object value);
  public void breadthFirstTraversal();
}
