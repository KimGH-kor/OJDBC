

public class Tutor {
	public static void main(String[] args) {
		int[][] arr = { { 2, 1, 290 }, { 2, 7, 280 },{ 3, 7, 380 }, { 8, 9, 260 }, { 9, 7, 270 }, { 9, 9, 260 } };
		int total = 0; 
		int temp = 0; int cScore =0;
		System.out.println("반\t 번\t 총점");

		for (int i = 0; i < arr.length; i++) {  //  배열의 갯수만큼 
			
				if (arr[i][0] != temp )      // 배열 i행 0번(반 번호)와 기존의 반번호를 저장하는 temp값을 비교
				{
					if(temp != 0)  // 최초의 0반 출력을 막기위한 if문
					{
						System.out.println(temp + "반 총점 " + cScore);  //반이 바뀌었으므로 기존반의 총점을 표시
					}
					temp = arr[i][0];  //반 번호가 달랐기 때문에 현제 반번호로 temp값을 변환
					cScore=0;          //총점을 표시했으므로 0으로 초기화
			
				}
				cScore += arr[i][2];
				total += arr[i][2];
				System.out.println(arr[i][0] + "\t" + arr[i][1] + "\t" + arr[i][2]);
				//한 행이 끝났기에 현제 행의 반 번 총점 을 표시
			}
		     System.out.println(temp + "반 총점 " + cScore);  //for문이 끝나면 마지막 반의 점수를 표시하지 않았으므로 표시
		     System.out.println("전체 총점 " + total);  //for문이 끝나 모든 내용이 나왔으므로 마지막 총점 표시
	}    

}