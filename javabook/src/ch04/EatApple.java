package ch04;

public class EatApple implements IEatFruit{
	public void wash() {
		System.out.println("wash an Apple");
	}
	public void cut() {
		System.out.println("cut an Apple");
	}
	public void eat() {
		System.out.println("eat an Apple");
	}
	public void finish() {
		System.out.println("finish\n\n");
	}
}
