/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DisjointSet;

/**
 *
 * @author User
 */
public class FindIfPathExistsInGraph {
    class UnionFind{
        int parent[];
        int rank[];
        UnionFind(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i = 1; i <= n; i++){
                parent[i] = i;
            }
        }

        public int findParent(int node){
            if(node == parent[node]){
                return node;
            }
            parent[node] = findParent(parent[node]);
            return parent[node];
        }

        public void unionByRank(int u, int v){
            u = findParent(u);
            v = findParent(v);

            //If u and v are already in same component
            if(u == v){
                //System.out.println("U and V are in same component");
            }

            if(rank[u] < rank[v]){
                parent[u] = v;
            }
            else if(rank[u] > rank[v]){
                parent[v] = u;
            }
            else{
                parent[u] = v;
                rank[v]++;
            }
        }

        //Check if source and destination are in same component or not
        //If source and destination are in same component then their has a path
        //Otherwise there has no path
        public boolean hasPath(int u, int v){
            u = findParent(u);
            v = findParent(v);

            return u == v;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind union = new UnionFind(n);

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            union.unionByRank(u, v);
        }

        return union.hasPath(source, destination);
    }
}
