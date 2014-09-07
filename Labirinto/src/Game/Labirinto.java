/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Fulvio
 */
public class Labirinto {
    private int n, m;
    boolean Maze[][][];

    public boolean getMaze(int i,int j, int k) {
        return Maze[i][j][k];
    }
    
    
    public Labirinto(int n){
        this.n = n;
        this.m = n;

        Maze = new boolean[n+1][m+1][2];
       
        Vector<PairOfPairs> V = new Vector<>();
        int dx[] = {-1,0};
        int dy[] = {0,-1};
     
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                for(int k = 0;k<2;k++){
                    Maze[i][j][k] = false;
                   if( (i+dx[k]<0) || (i+dx[k]>=n) || (j+dy[k]<0) || (j+dy[k]>=m) )
                       continue;
                   V.add(new PairOfPairs(i,j,i+dx[k],j+dy[k]));
                }
            }
        }
        
        UnionFind S = new UnionFind(n*m);
        
        while(!V.isEmpty()){
            int pos = (new Random()).nextInt(V.size());
             
            PairOfPairs aux = V.get(pos);
            V.remove(pos);
            if(!S.setUnion(( aux.getI1()* m) +aux.getJ1() ,( aux.getI2()* m) +aux.getJ2() )){
              int i1 = aux.getI1(),j1 = aux.getJ1(),i2 = aux.getI2(),j2 = aux.getJ2();
              // System.out.print(i1 + " " + j1 + " " + i2 + " " + j2 + "\n");
              if(i1 == i2){
                  Maze[i1][j1][1] = true;
              }else{
                  Maze[i1][j1][0] = true;
              }
            }
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public boolean[][][] getMaze() {
        return Maze;
    }

    public void setMaze(boolean[][][] Maze) {
        this.Maze = Maze;
    }
}
