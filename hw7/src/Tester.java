
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
    
    private static final int VISITED = 1000;
    private static final int UNVISITED = 0;

    
    public static void main(String[] args){
        
        //--setup graph--//
        Graph g = buildGraph();
        
        Kruskal(g);
    }
    
    private static void Kruskal(Graph g){
        //setup
        int e = 0;
        int V = g.vertexCount();

        Edge[] mst = new Edge[V];
        Edge[] edges = g.sortedEdges();
        UnionFind unionFind = new UnionFind(V);
        
        int i = 0 ;
        while(e < V-1){
            Edge nextEdge = edges[i++];
            
            int x = unionFind.find(nextEdge.v1());
            int y = unionFind.find(nextEdge.v2());
                       
            if(x != y){
                
                mst[e++] = nextEdge;
                unionFind.union(x, y);
            }
        }     
                
        System.out.println("The MST contains the following edges!");
        for(int j = 0; j < e; j++){
            System.out.println(mst[j]);
        }
    }
    
    private static Graph buildGraph(){
        Graph g = new GraphAdjMat(8);

        g.setEdge(0,1,4);
        g.setEdge(0,2,6);
        g.setEdge(0,3,16);
        g.setEdge(1,7,24);
        g.setEdge(2,7,23);
        g.setEdge(2,5,5);
        g.setEdge(2,3,8);
        g.setEdge(3,5,10);
        g.setEdge(3,4,21);
        g.setEdge(5,4,14);
        g.setEdge(5,6,11);
        g.setEdge(5,7,18);
        g.setEdge(6,7,9);
        g.setEdge(6,4,7);
        
        return g;
    }
    
}
