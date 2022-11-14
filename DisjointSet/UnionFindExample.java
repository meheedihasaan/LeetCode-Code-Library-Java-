/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DisjointSet;

/**
 *
 * @author User
 */

class UnionFind{
    public int parent[];
    public int rank[];
    public UnionFind(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    
    public void union(int u, int v){
        u = findParent(u);
        v = findParent(v);
        
        //Check if both node's parent are same
        if(u == v){
            System.out.println("Both nodes are in same component");
            return;
        }
        
        if(rank[u] < rank[v]){
            parent[u] = v;
        }
        else if(rank[u] > rank[v]){
            parent[v] = u;
        }
        else{
            parent[v] = u;
            rank[u]++;
        }
    }
}

public class UnionFindExample {
    public static void main(String[] args) {
        UnionFind un = new UnionFind(20);
        un.union(1, 2);
        un.union(2,3);
        un.union(1, 3);   //1 and 3 both are in same component
        un.union(4, 5);
        un.union(6, 7);
        un.union(4, 6);
        un.union(5, 7);   //5 and 7 both are in same component
//        System.out.println(un.findParent(2));
//        System.out.println(un.findParent(3));
//        System.out.println(un.findParent(4));

        //Check if two nodes are in same component or not
        if(un.findParent(1) != un.findParent(10)){
            System.out.println("Different Component");
        }
        else{
            System.out.println("Same Component");
        }
    }
}
