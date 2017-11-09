/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class GraphAdjMat implements Graph{
    
    private int[][] matrix; //the edge matrix
    private int numEdges;   //number of edges
    private int numVerts;
    public int[] markArray; //the mark array. Initially all zero.
    
    //--constructor--//
    public GraphAdjMat(int size){
        this.numVerts = size;
        
        this.markArray = new int[size];
        this.matrix = new int[size][size];
        this.numEdges = 0;
    }
    
    public int edgeCount(){
        return numEdges;
    }
    public int vertexCount(){
        return this.numVerts;
    }
    
    public Edge first(int v){
        for(int i = 0; i < markArray.length; i++){
            if(matrix[v][i] != 0)
                return new EdgeAdjMat(v,i);
        }
        return null;    //no edge for this vertex!
    }
    public Edge next(Edge w){
        if(w== null) 
            return null;
        
        for(int i = w.v2() + 1; i < markArray.length; i++){
            if (matrix[w.v1()][i] != 0)
                return new EdgeAdjMat(w.v1(), i);        
        }
        return null;    //no next edge.
    }    
    
    public boolean isEdge(Edge w){
        if(w==null) return false;
        else return matrix[w.v1()][w.v2()] != 0;
    }
    public boolean isEdge(int i, int j){
        return matrix[i][j] != 0;
    }

    public int v1(Edge w){return w.v1();}
    public int v2(Edge w){return w.v2();}
    
    public void setEdge(int i, int j, int weight){
        assert(weight > 0): "weight must be greater than zero!";
        if(matrix[i][j] == 0) 
            numEdges++;
        matrix[i][j] = weight;
    }
    public void setEdge(Edge w, int weight){
        if(w == null)
            return;
        
        this.setEdge(w.v1(), w.v2(), weight);
    }

    public void delEdge(Edge w){
        if(w != null){
            if(matrix[w.v1()][w.v2()] != 0){
                matrix[w.v1()][w.v2()] = 0;
                numEdges--;
            }
        }
    }
    public void delEdge(int i, int j) { // Delete (i, j)
        if (matrix[i][j] != 0)
        { 
            matrix[i][j] = 0; numEdges--; 
        }
    }

    public int weight(int i, int j) { // Return weight
        if (matrix[i][j] == 0)
            return Integer.MAX_VALUE;
        else
            return matrix[i][j];
    }
    public int weight(Edge w){
        assert(w != null): "can't take the weight of a null edge!";
        return this.weight(w.v1(), w.v2());
    }   
    
    public void setMark(int v, int val){
        this.markArray[v] = val;
    }
    public int getMark(int v){
        return this.markArray[v];
    }
}



