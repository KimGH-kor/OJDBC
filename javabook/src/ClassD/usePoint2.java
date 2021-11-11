package ClassD;

public class usePoint2 {
	public static void main(String[] args) {
		Point2 p = new Point2();
		int[][] arr = new int[2][2];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[1][0] = 3;
		arr[1][1] = 4;
		
		
		arr = p.swap(arr, 1, 2);
		System.out.println(arr[0][0]);
	}
}
