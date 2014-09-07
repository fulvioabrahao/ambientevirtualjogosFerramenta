/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Fulvio
 */
public class UnionFind {
    private int set[];
    
    public UnionFind(int n){
        set = new int [n];
        for(int i = 0;i<n;i++)set[i] = i;
    }
    
    public int find(int n){
        if(set[n] == n)return n;
        else return set[n] = find(set[n]);
    }
    public boolean isSameSet(int a,int b){
        return (find(a) == find(b));
    }
    
    public boolean setUnion(int a, int b){
        if(isSameSet(a, b))return false;
        else {
            set[find(a)] = find(b);
            return true;
        }
    }
}
