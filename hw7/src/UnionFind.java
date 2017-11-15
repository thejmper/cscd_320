/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class UnionFind {
    
    private subset[] subsets;
    
    public UnionFind(int v){
        this.subsets = new subset[v];
        for(int i = 0; i < v; i++){
            subsets[i] = new subset();
            
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
    }
    
    public int find(int i){
        if(subsets[i].parent != i)
            subsets[i].parent = find(subsets[i].parent);
        
        return subsets[i].parent;
    }    
    
    public void union(int x, int y){
        int xroot = find(x);
        int yroot = find(y);
        
        if(subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if(subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    
    class subset{
        int parent, rank;
    }
}
