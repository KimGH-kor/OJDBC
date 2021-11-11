	public class Student {

		   public static void main(String[] args) {
		      int[][] stu = {{1,1,290},{1,7,280},{9,7,270},{9,9,260}};
		      int cScore = 0;
		      int total = 0;
		      
		      System.out.println("반    번  총점");
		      for(int i=0;i<stu.length;i++) {
		         
		      
		         if(i > 0 && stu[i][0] != stu[i-1][0]) {
		            System.out.println(stu[i-1][0]+"반 총점  "+cScore);
		            cScore = 0;
		         }
		         
		         System.out.println(stu[i][0]+"      "+stu[i][1]+"  "+stu[i][2]);
		         
		         cScore += stu[i][2];
		         total += stu[i][2];
		         
		         if(i==stu.length-1) {
		            System.out.println(stu[i-1][0]+"반 총점  "+cScore);
		         }
		      }
		      
		      System.out.println("전체 총점 "+total);
		   }

		}