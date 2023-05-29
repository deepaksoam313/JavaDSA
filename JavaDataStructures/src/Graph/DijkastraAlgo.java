package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkastraAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    //Create Graph Method
    public static void Graph(ArrayList<Edge>[] graph){
        //initializing graph elements null to edge
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }
    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }
    //Dijkastra Algorithm
    public static void Dijkastra(ArrayList<Edge>[] graph, int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[] dist = new int[V];

        for(int i=0; i<V; i++){
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }
        boolean[] vis = new boolean[V];

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove(); //shortest distance

            if(!vis[curr.node]){
                vis[curr.node] = true;
                //neighbour loop
                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);

                    int  u = e.src;
                    int v = e.dest;

                    //Relaxtation
                    if(dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for(int i=0; i<V; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];


        //Calling create method of graph
        Graph(graph);

        //calculating shortest path from Dijkastra Algorithm
        Dijkastra(graph,0, V);

    }
}
