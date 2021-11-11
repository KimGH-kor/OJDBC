package ClassD;

public class Point2 {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int[][] swap(int[][] arr, int x, int y) {
		this.x = x;
		this.y = y;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == x) {
					arr[i][j] = this.y;
				}else if(arr[i][j] == y) {
					arr[i][j] = this.x;
				}
			}
		}
		return arr;
		
		
	}
}
