package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SignUpModel {
	private Map<String, String> taiKhoan;
	private static final String pathName = "C:\\Users\\ASUS\\eclipse-workspace\\UI_SignUP\\TaiKhoan.txt";

	public SignUpModel() {
		// TODO Auto-generated constructor stub\
		taiKhoan = new TreeMap<String, String>();
		try {
			File file = new File(pathName);
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			while (true) {
				String text = br.readLine();
				if (text == null) {
					break;
				}
				StringTokenizer token = new StringTokenizer(text, ",");
				String tenTaiKhoan = token.nextToken();
				tenTaiKhoan = tenTaiKhoan.trim();
				String matKhau = token.nextToken();
				matKhau = matKhau.trim();
				taiKhoan.put(tenTaiKhoan, matKhau);
			}
			br.close();
			reader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the taiKhoan
	 */
	public Map<String, String> getTaiKhoan() {
		return taiKhoan;
	}

	/**
	 * @param taiKhoan the taiKhoan to set
	 */
	public void setTaiKhoan(Map<String, String> taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public void themTaiKhoan(String tenTaiKhoan, String matKhau) {
		this.taiKhoan.put(tenTaiKhoan, matKhau);

		try {
			FileOutputStream fos = new FileOutputStream(new File(pathName),true);
			PrintWriter fw = new PrintWriter(fos);
			fw.print("\n"+tenTaiKhoan + ", " + matKhau);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void xoaTaiKhoan(String tenTaiKhoan, String matKhau) {
		this.taiKhoan.remove(tenTaiKhoan, matKhau);
	}

	public boolean timKiem(String tenTaiKhoan) {
		return this.taiKhoan.containsKey(tenTaiKhoan);
	}

}
