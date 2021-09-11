/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    
    static final int V=9;
    
    
    int minDistance(int[] dist, boolean[] sptSet){
        
        int min = Integer.MAX_VALUE;
        int min_value = -1;
        
        
        for (int v=0; v<V;v++){
            if(sptSet[v] == false && dist[v] <= min){
                min = dist[v];
                min_value = v;
            }
        }
        
        return min_value;
    }
    
    void printSolution(int[] dist,int n){
        
        System.out.println("*** Vertex distance form Source ***");
        
        for (int i=0;i<V;i++){
	        System.out.println(i+" to "+dist[i]);
        }
    }

    // Function that implements dijkstra's algorithm
    void dijkstra(int[][] graph, int source){
        
        int[] dist = new int[V];
        
        boolean[] sptSet = new boolean[V];
        
        // Initialize the Distance 
        for (int i=0;i<V;i++){
            
            dist[i] =  Integer.MAX_VALUE;
            sptSet[i] = false;
        } 
        
        //Distance from the source is 0
        dist[source] = 0;
        
        //Find the shortest path from all the vertices
        for (int i=0;i<V-1;i++){
            
            int u = minDistance(dist,sptSet);
            
            sptSet[u] = true;
            
            for (int v=0;v<V;v++){
                
                if (!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v];
                }
                
            }
        
            printSolution(dist, V);
        
        }
        
    }
    
	public static void main(String[] args) {
		
		int graph[][] = new int[][]{
		                        {0, 4, 0, 0, 0, 0, 0, 8, 0},
								{4, 0, 8, 0, 0, 0, 0, 11, 0},
								{0, 8, 0, 7, 0, 4, 0, 0, 2},
								{0, 0, 7, 0, 9, 14, 0, 0, 0},
								{0, 0, 0, 9, 0, 10, 0, 0, 0},
								{0, 0, 4, 14, 10, 0, 2, 0, 0},
								{0, 0, 0, 0, 0, 2, 0, 1, 6},
								{8, 11, 0, 0, 0, 0, 1, 0, 7},
								{0, 0, 2, 0, 0, 0, 6, 7, 0}
								};
	    
	    Main t = new Main();
		t.dijkstra(graph, 0);
	}
}
