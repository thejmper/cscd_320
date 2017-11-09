/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public interface Graph {
 
    public int vertexCount();
    public int edgeCount();

    public Edge first(int v);   //get first edge having v as vertex v1
    public Edge next(Edge w);   //get the next edge having w.v1 as its start
    
    public boolean isEdge(Edge w); //true if edge
    public boolean isEdge(int i, int j);
    public int v1(Edge w);
    public int v2(Edge w);
    
    public void setEdge(int i, int j, int weight);
    public void setEdge(Edge w, int weight);
    
    public void delEdge(Edge w);
    public void delEdge(int i, int j);
    
    public int weight(Edge w);
    public int weight(int i, int j);
    
    public void setMark(int v, int val);
   
    public int getMark(int v);    
}


