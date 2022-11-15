/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DisjointSet;

/**
 *
 * @author User
 */

//UnionFind Class
class UnionFind{
    public int parent[];
    public int rank[];
    public int size[];
    
    public UnionFind(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        size = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }    
    
    //Finding root-parent of a Node
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        //Path Compression
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    
    //Doing Union operation by Rank
    public void unionByRank(int u, int v){
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
    
    //Doing Union operation by Size    
    public void unionBySize(int u, int v){
        u = findParent(u);
        v = findParent(v);
        
        //Check if both node's parent are same
        if(u == v){
            System.out.println("Both nodes are in same component");
            return;
        }
        
        if(size[u] < size[v]){
            parent[u] = v;
            size[v]+=size[u];  //Update size of the component
        }
        else{
            parent[v] = u;
            size[u]+=size[v];  //Update size of the component 
        }
    }
    
    //Counting number of components
    int cnt = 0;
    public int countComponents(){        
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == i){
                cnt++;
            }
        }
        return cnt;
    }
}

public class UnionFindExample {
    public static void main(String[] args) {
        UnionFind un = new UnionFind(20);
        un.unionByRank(1, 2);
        un.unionByRank(2,3);
        un.unionByRank(1, 3);   //1 and 3 both are in same component
        un.unionByRank(4, 5);
        un.unionByRank(6, 7);
        un.unionByRank(4, 6);
        un.unionByRank(5, 7);   //5 and 7 both are in same component
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
