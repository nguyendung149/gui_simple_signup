package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.SignUPListener;
import model.SignUpModel;

public class SignUpUIView extends JFrame {
	private SignUpModel model;
	private JTextField JTusername;
	private JPasswordField JTpassword;
	private JTextField alert;
	private JOptionPane dialog = new JOptionPane();

	public SignUpUIView() {
		model = new SignUpModel();
		this.init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init() {
		this.setTitle("Lab_8");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		Font font = new Font("Arial", Font.BOLD, 20);
		ActionListener ac = new SignUPListener(this);
		JLabel info = new JLabel("Lạc Hải Sơn 20200328" + " " + "Nguyễn Dũng 20200121"); // i chỉ nhận text nên +"" để
		info.setFont(font);

		JPanel JPinfo = new JPanel();
		JPinfo.setLayout(new GridLayout(1, 1));
		JPinfo.add(info);

		JLabel username = new JLabel("Tên đăng nhập");
		username.setFont(font);
		JTusername = new JTextField(50);
		JTusername.setFont(font);

		JLabel password = new JLabel("Mật Khẩu");
		password.setFont(font);
		JTpassword = new JPasswordField(50);
		JTpassword.setFont(font);

		JPanel JPname = new JPanel();
		JPname.setLayout(new GridLayout(3, 3));
		JPname.add(username);
		JPname.add(JTusername);
		JPname.add(password);
		JPname.add(JTpassword);

		JButton login = new JButton("Đăng nhập");
		JButton regiter = new JButton("Đăng ký");
		JPanel log = new JPanel();
		log.setLayout(new FlowLayout());
		log.add(login);
		log.add(regiter);
		login.addActionListener(ac);
		regiter.addActionListener(ac);

		alert = new JTextField(100);
		alert.setFont(font);

		this.setLayout(new GridLayout(4, 4));
		this.add(JPinfo);
		this.add(JPname);
		this.add(log);
		this.add(alert);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SignUpUIView();
	}

	public void kiemTraDangNhap() {
		// TODO Auto-generated method stub
		String tenTaiKhoan = JTusername.getText();
		String matKhau = JTpassword.getText();
		Map<String, String> taiKhoan = this.model.getTaiKhoan();
		if (this.model.timKiem(tenTaiKhoan)) {
			if (taiKhoan.get(tenTaiKhoan).equals(matKhau)) {
				alert.setText("Đăng nhập thành công");
				dialog.showMessageDialog(this, "Đăng nhập thành công!", "Message", JOptionPane.INFORMATION_MESSAGE);

			} else {
				alert.setText("Sai tên đăng nhập hoặc mật khẩu");
				dialog.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!", "Message",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			alert.setText("Tài Khoản chưa được đăng ký");
			dialog.showMessageDialog(this, "Tài Khoản chưa được đăng ký", "Message", JOptionPane.WARNING_MESSAGE);
		}

	}

	public void dangKyMoi() {
		// TODO Auto-generated method stub
		String tenTaiKhoan = JTusername.getText();
		String matKhau = JTpassword.getText();
		if (this.model.timKiem(tenTaiKhoan)) {
			alert.setText("Tên đăng khoản đã có. Vui lòng nhập lại tên tài khoản");
			dialog.showMessageDialog(this, "Tên đăng khoản đã có. Vui lòng nhập lại tên tài khoản", "Message",
					JOptionPane.WARNING_MESSAGE);
		} else {
			this.model.themTaiKhoan(tenTaiKhoan, matKhau);
			alert.setText("Đăng ký thành công");
			dialog.showMessageDialog(this, "Đăng ký thành công!", "Message", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
