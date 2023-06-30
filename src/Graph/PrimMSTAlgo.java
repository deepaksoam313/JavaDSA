package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimMSTAlgo {

    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest =d;
            this.wt =w;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int V){
        for(int i=0; i<V; i++)
            graph[i] =new ArrayList<Edge>();

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
        System.out.println("Graph has created");

    }

    //Prim' Method to calculate MST
    public static void PrimMST(ArrayList<Edge>[] graph, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        int mstValue =0;


        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!vis[curr.node]){
                vis[curr.node] = true;
                mstValue += curr.cost;

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);

                    if (!vis[e.dest])
                        pq.add(new Pair(e.dest, e.wt));
                }


            }
        }//while loop end

        System.out.println("MST value is " + mstValue);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph, V);

        PrimMST(graph,V);


    }
}

