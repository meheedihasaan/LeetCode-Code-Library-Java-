/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DisjointSet;

/**
 *
 * @author User
 */
public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind un = new UnionFind(n); //Initializing UnionFind
        
        //Do Union operation between two stones only if their row or column matches
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int stone1[] = stones[i];
                int stone2[] = stones[j];
                
                //Check if two stones are in same row or same column
                if(stone1[0] == stone2[0] || stone1[1] == stone2[1]){
                    un.union(i, j);  //We can use both Union by Rank or by Size
                }
            }
        }
        
        int ans = n - un.countComponents();
        return ans;
    }
}

//UnionFind Class
class UnionFind{
    public int parent[];
    public int rank[];
    public int size[];
    
    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    //Finding the root-parent of a Node
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findParent(parent[node]); //Path Compression
        return parent[node];
    }
    
    //Doing Union operation of two Nodes
    public void union(int u, int v){
        u = findParent(u);
        v = findParent(v);
        
        //Check if both u and v are in same node
        if(u == v){
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
            rank[u] = u++;
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
    
    //Finding number of Components
    public int countComponents(){
        int cnt = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                cnt++;
            }
        }
        return cnt;
    }
}
