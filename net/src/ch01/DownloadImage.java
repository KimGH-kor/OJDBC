package ch01;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownloadImage {
	public static void main(String[] args) throws Exception {
		String site = "http://www.k-hrd.kr/DATA/DEFAULT/dfaa826b2bba8a33b28b2404ba2099dd0.jpg";
		System.out.println(site + "를 다운로드 합니다.");
		
		URL url = new URL(site);
		byte[] buffer = new byte[2048];
		
		InputStream in = url.openStream();
		OutputStream out = new FileOutputStream("down.jpg");
		
		int length;
		
		while((length = in.read(buffer)) != -1) {
			System.out.println(length + "바이트 다운로드 중!");
			out.write(buffer, 0, length);
		}
		
		in.close();
		out.close();
	}
}
