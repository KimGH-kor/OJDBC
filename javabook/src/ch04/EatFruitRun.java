package ch04;

public class EatFruitRun {
	public static void main(String[] args) {
		IEatFruit tt = null;		
		tt = new EatTomato();
		tt.wash();
		tt.cut();
		tt.eat();
		tt.finish();
		
		tt = new EatApple();
		tt.wash();
		tt.cut();
		tt.eat();
		tt.finish();
		
	}
}
