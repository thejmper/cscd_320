/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class EdgeAdjMat implements Edge{
    
    private int vert1;
    private int vert2;
    
    public EdgeAdjMat(int v1, int v2){
        this.vert1 = v1;
        this.vert2 = v2;
    }
    
    public int v1(){return this.vert1;}
    public int v2(){return this.vert2;}
}
