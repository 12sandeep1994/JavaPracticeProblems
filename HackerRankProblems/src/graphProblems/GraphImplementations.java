package graphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


class Node{
	int nodeName;
	int weight;
	Node(int nodeName, int weight){
		this.nodeName = nodeName;
		this.weight = weight;
	}
}
class Graph{

	List<Node> g[];
	
	int n=0;
	Graph(int n){
		 g = new LinkedList[n];
		this.n=n;
		for(int i=0;i<n;i++) {
			g[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int s,int e,int w) {
		Node node = new Node(e, w);
		//Node node1 = new Node(s, w);
		g[s].add(0,node);
		//g[e].add(0,node1);
	}
	
	public String toString() {
		String result = "";
		for(int i=0;i<n;i++) {
			for(Node n : g[i]) {
				result+= "["+i+"]"+"["+n.nodeName+","+n.weight+"]->";
			}
			result +="\n";
		}
		return result;
	}
	
	public void bfs() {
		ArrayList<Integer> queue = new ArrayList<>();
		Boolean[] visited = new Boolean[n];
		Arrays.fill(visited, false);
		int i=0;
		//queue.add(0);
		queue.add(i);
		while(true) {
			if(queue.size()!=0) {
			if(!visited[queue.get(0)]) {
				for(Node n : g[queue.get(0)]) {
					queue.add(n.nodeName);
				}
				visited[queue.get(0)] = true;
				
				System.out.println(queue.remove(0));
			}
			else {
				queue.remove(0);
			}
			}
			else {
				break;
			}
			
		}
	}
	public void topologicalSort() {
		Stack<Integer > stack = new Stack<>();
		Boolean[] visited = new Boolean[n];
		Arrays.fill(visited, false);
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				toputil(visited,i,stack);
			}
		}
				
			for(int i=0;i<n;i++) {
				System.out.println(stack.pop());
			}
	}
	
	private void toputil(Boolean[] visited, int i, Stack<Integer> stack) {
		visited[i]=true;
		for(Node node : g[i]) {
			if(!visited[node.nodeName]) {
				toputil(visited, node.nodeName,stack);
			}
		}
		stack.push(i);
	}
	public void dfsCycleDetection() {
		Boolean[] visited = new Boolean[n];
		int[] parent = new int[n];
		Arrays.fill(visited, false);
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
	
				dfsutilCycle(visited,i,parent);
			}
		}
	}
	
	private void dfsutilCycle(Boolean[] visited, int i,int[] parent) {
		visited[i] = true;
		for(Node node : g[i]) {
			if(!visited[node.nodeName] && parent[node.nodeName]!=i) {
				parent[node.nodeName] = i;
				dfsutilCycle(visited,node.nodeName,parent);
			}else if(visited[node.nodeName] && parent[node.nodeName]!=i) {
				System.out.println("Cycle");
			}
		}
	}

	public void dfs() {
		Boolean[] visited = new Boolean[n];
		Arrays.fill(visited, false);
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
	
				dfsutil(visited,i);
			}
		}
	}

	private void dfsutil(Boolean[] visited,int i) {
		
		visited[i] = true;
		System.out.println(i);
		for(Node node : g[i]) {
			if(!visited[node.nodeName]) {
				dfsutil(visited, node.nodeName);
			}
		}
		
	}
}


public class GraphImplementations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  
		Graph g = new Graph(4); 
		  
        g.addEdge(0, 1,0); 
        g.addEdge(0, 2,0); 
        g.addEdge(1, 2,0); 
        g.addEdge(2, 0,0); 
        g.addEdge(2, 3,0); 
        g.addEdge(3, 3,0); 
  
        System.out.println("Following is Depth First Traversal"); 
  
        g.dfs(); 
		System.out.println(g);
		System.out.println("-------------");
		g.bfs();
		
	}
}
