package stringManipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class PCTIntersectingPoints {

	public static void main(String[] args) {
		int v,h;
		Scanner	 scanner = new Scanner(System.in);
		ArrayList<Line> VerticalLine =new ArrayList<>();
		ArrayList<Line> HorizontalLine =new ArrayList<>();
		int res=0;
		v=scanner.nextInt();
		h = scanner.nextInt();
		for(int i=0;i<v;i++) {
			int x=scanner.nextInt();
			int y1=scanner.nextInt();
			int y2=scanner.nextInt();
			Line line = new Line(x, y1, x, y2);
			VerticalLine.add(line);
		}
		for(int i=0;i<h;i++) {
			int y=scanner.nextInt();
			int x1=scanner.nextInt();
			int x2=scanner.nextInt();
			Line line = new Line(x1, y, x2, y);
			HorizontalLine.add(line);
		}
		for(Line verticalLine : VerticalLine) {
			for(Line horizontalLine : HorizontalLine) {
				if(verticalLine.x+horizontalLine.y==verticalLine.a+horizontalLine.b) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}

class Line{
	int x;
	int y;
	int a;
	int b;
	Line(int x,int y, int a,int b){
		this.x=x;
		this.y=y;
		this.a=a;
		this.b=b;
	}
}