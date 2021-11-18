package ch11_11.DTO;

public class CustomerDTO {
	private int n_code;
	private String s_name;
	private String s_email;
	private String s_tel;
	private double d_weight;
	
	
	
	public CustomerDTO(int n_code, String s_name, String s_email, String s_tel, double d_weight) {
		this.n_code = n_code;
		this.s_name = s_name;
		this.s_email = s_email;
		this.s_tel = s_tel;
		this.d_weight = d_weight;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [n_code=" + n_code + ", s_name=" + s_name + ", s_email=" + s_email + ", s_tel=" + s_tel
				+ ", d_weight=" + d_weight + "]";
	}

	public int getN_code() {
		return n_code;
	}
	public void setN_code(int n_code) {
		this.n_code = n_code;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_tel() {
		return s_tel;
	}
	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}
	public double getD_weight() {
		return d_weight;
	}
	public void setD_weight(double d_weight) {
		this.d_weight = d_weight;
	}
}
