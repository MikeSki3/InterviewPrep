package tutes.maths;

import java.util.Scanner;

public class FindThePoint {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++){
			int px = in.nextInt();
			int py = in.nextInt();
			int qx = in.nextInt();
			int qy = in.nextInt();
			
			Point p = new Point(px, py);
			Point q = new Point(qx, qy);
			
			System.out.println(calculateReflection(p, q));
		}
	}

	private static Point calculateReflection(Point p, Point q) {
		int rx = (q.x - p.x) + q.x;
		int ry = (q.y - p.y)+ q.y;
		return new Point(rx, ry);
	}
	
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
	
	
}