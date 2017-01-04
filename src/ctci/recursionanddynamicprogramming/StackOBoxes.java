package ctci.recursionanddynamicprogramming;

import java.util.HashMap;

public class StackOBoxes {
	
	public static void main(String[] args) {
		StackOBoxes stack = new StackOBoxes();
		Box[] boxes = {stack.new Box(1, 1, 1), stack.new Box(1, 4, 2), stack.new Box(4, 5, 5), stack.new Box(2, 2, 3)};
		System.out.println(getMaxHeight(boxes));
	}
	
	private static int getMaxHeight(Box[] boxes) {
		HashMap<Box, Integer> heightsFound = new HashMap<>();
		int maxHeight = 0;
		for(int i = 0; i < boxes.length; i++){
			buildStack(boxes[i], boxes, heightsFound);
			maxHeight = Math.max(maxHeight, heightsFound.get(boxes[i]));
		}
		return maxHeight;
	}

	private static void buildStack(Box base, Box[] boxes, HashMap<Box, Integer> heightsFound) {
//		int baseW = base.w, baseH = base.h, baseD = base.d;
		int height = base.h;
		Box currBase = base;
		for(int i = 0; i < boxes.length; i++){
			Box currBox = boxes[i];
			if(currBase.isBigger(currBox) && heightsFound.containsKey(currBox)){
				height = Math.max(heightsFound.get(currBox) + base.h, height);
				continue;
			}
			if(currBase.isBigger(currBox)){
				height += currBox.h;
				currBase = currBox;
			}
		}
		heightsFound.put(base, height);
	}

	private class Box {
		int w, h, d;
		
		public Box(int w, int h, int d){
			this.w = w;
			this.h = h;
			this.d = d;
		}

		public boolean isBigger(Box currBox) {
			return this.w > currBox.w && this.h > currBox.h && this.d > currBox.d;
		}
		
		@Override
		public String toString(){
			return "w=" + this.w + " h=" + this.h + " d=" + this.d;
		}
	}
}
