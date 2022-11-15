/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DisjointSet;

/**
 *
 * @author User
 */
public class NumberOfOperationsToMakeNetworksConnected {
    public int makeConnected(int n, int[][] connections){
        //Initializing UnionFind
        UnionFind un = new UnionFind(n);
        
        int extra = 0;
        for(int arr[] : connections){
            int a = arr[0];
            int b = arr[1];
            if(un.findParent(a) == un.findParent(b)){
                extra++;   //If a and b already connected then this cable is extra
            }
            else{
                un.unionByRank(a, b); //We can use both Union by Rank or by Size
            }
        }
        
        int need = un.countComponents()-1;
        if(extra < need){
            return -1;
        }
        return need;
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
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    //Finding root-parnt of a Node
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
        
        //If their parent are same then they are in same component
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
    
    //Counting total number of components
    int cnt = 0;
    public int countComponents(){
        for(int i = 0; i < 0; i++){
            if(parent[i] == i){
                cnt++;
            }
        }
        return cnt;
    }
}
