
import java.util.LinkedList;
import java.util.List;
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
public class Tester {
    
    private static final int VISITED = 1000;
    private static final int UNVISITED = 0;

    
    public static void main(String[] args){
        
        //--setup graph--//
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
        
        BFS(g,0);
    }
    
    private static void BFS(Graph g, int start){
        Queue q = new LinkedList<Integer>();
       
        List<Integer> path = new LinkedList<>();
        
        q.add(start);
        path.add(start);
        g.setMark(start, VISITED);
        
        //process each vertex in the queue
        while(!q.isEmpty()){
            int v = ((Integer)q.remove());
            
            PreVisit(g,v);
            
            for(Edge w = g.first(v); g.isEdge(w); w = g.next(w)){
                int next = w.v2();
                if(g.getMark(next) == UNVISITED){
                    g.setMark(next,VISITED);
                    q.add(next);
                    path.add(next);
                }
                PostVisit(g,v);                
            }
        }
        
        printPath(path);       
    }
    private static void printPath(List<Integer> path){
        
        System.out.println("The the result of the BFS traversal starting from vertex 0 is:");
        
        int i = 0;
        for(i = 0; i < path.size() -1; i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println(path.get(i));
    }
    
    private static void PreVisit(Graph g, int v){
    }
    private static void PostVisit(Graph g, int v){
    }
}
