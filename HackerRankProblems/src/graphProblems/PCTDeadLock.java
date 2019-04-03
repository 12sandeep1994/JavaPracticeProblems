package graphProblems;

import java.util.ArrayList;
import java.util.Scanner;

class Neighbour{
	int vertexNum;
	Neighbour neighbour;
	public Neighbour(int vertexNum,Neighbour neighbour) {
		this.vertexNum = vertexNum;
		this.neighbour = neighbour;
	}
}


class Vertex{
	int name;
	Neighbour adjacentNode;
	public Vertex(int name, Neighbour adj) {
		this.name = name;
		this.adjacentNode = adj;
	}
}

public class PCTDeadLock {
	static int index=0;
	 int r1;
	static Vertex vertexlist[] = new Vertex[50];
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		scanner.nextLine();
		for(int i=0;i<total;i++) {
			String[] line = scanner.nextLine().split(" ");
			int r1;
			int r2;
			int pid=r1=r2=-1;
			Vertex process,resource1,resource2;
			int processVertexNum=-1,resource1Num = -1,resource2Num=-1;
			
			pid = Integer.parseInt(line[0]);
			if(Integer.parseInt(line[1])!=-1) {
				r1 = Integer.parseInt(line[1]);
			}
			if(Integer.parseInt(line[2])!=-1) {
				r2 = Integer.parseInt(line[2]);
			}	
			
			if(pid!=-1) {
				 int var = nameToIndex(pid);
				if(var == -1) {
					 process = new Vertex(pid, null);
					 vertexlist[index] = process;
					 index++;
				}
				processVertexNum = nameToIndex(pid);
			}
			if(r1!=-1) {
				int var = nameToIndex(r1);
				if(var == -1) {
					 resource1 = new Vertex(r1, null);
					 vertexlist[index] = resource1;
					 index++;
				}
				resource1Num = nameToIndex(r1);
			}
			if(r2!=-1) {
				int var = nameToIndex(r2);
				if(var == -1) {
					 resource2 = new Vertex(r2, null);
					 vertexlist[index] = resource2;
					 index++;
				}
				resource2Num = nameToIndex(r2);
			}
			
			if(r1 != -1) {
				vertexlist[resource1Num].adjacentNode = new Neighbour(processVertexNum, vertexlist[resource1Num].adjacentNode);
			}
			if(r2!=-1) {
				vertexlist[processVertexNum].adjacentNode = new Neighbour(resource2Num, vertexlist[processVertexNum].adjacentNode);

			}
			
			
		}
		System.out.println(hascycle());
	}
	
	
	private static boolean hascycle() {
		boolean result = false;
		ArrayList<Integer> whiteset = new ArrayList<>();
		ArrayList<Integer> greyset = new ArrayList<>();
		ArrayList<Integer> blackset = new ArrayList<>();
		for(int i=0;i<index;i++) {
			whiteset.add(vertexlist[i].name);
		}
		
		while(!whiteset.isEmpty()) {
			if(cycleUtil(whiteset.get(0),greyset,blackset,whiteset)) {
				return true;
			}
		}
		
		return result;
	}


	private static boolean cycleUtil(Integer integer, ArrayList<Integer> greyset, ArrayList<Integer> blackset,
			ArrayList<Integer> whiteset) {
		
		greyset.add(integer);
		whiteset.remove(integer);
		Vertex current = nameToVertex(integer);
		Neighbour neighbour = current.adjacentNode;
		while(neighbour!=null) {
			Integer vertexnum = vertexlist[neighbour.vertexNum].name;
			if(greyset.contains(vertexnum)) {
				return true;
			}
			if(blackset.contains(vertexnum)) {
				neighbour = neighbour.neighbour;
				continue;
			}
			if(cycleUtil(vertexnum, greyset, blackset, whiteset)) {
				return true;
			}
			neighbour = neighbour.neighbour;
		}
		greyset.remove(integer);
		blackset.add(integer);
		
		return false;
	}


	public static int nameToIndex(int name) {
		for(int i=0;i<vertexlist.length;i++) {
			if(vertexlist[i]!=null && vertexlist[i].name == name) {
				return i;
			}
		}
		return -1;
	}
	public static Vertex nameToVertex(int name) {
		for(int i=0;i<vertexlist.length;i++) {
			if(vertexlist[i].name == name) {
				return vertexlist[i];
			}
		}
		return null;
	}
}
