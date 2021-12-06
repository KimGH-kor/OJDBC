package ch06;

public class AttrDTO {
	int code;
	String name;
	double greed;
	public AttrDTO(int code, String name, double greed) {
		this.code = code;
		this.name = name;
		this.greed = greed;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGreed() {
		return greed;
	}
	public void setGreed(double greed) {
		this.greed = greed;
	}
}
