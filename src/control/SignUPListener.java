package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.SignUpUIView;

public class SignUPListener implements ActionListener {
	private SignUpUIView view;

	public SignUPListener(SignUpUIView view) {
		// TODO Auto-generated constructor stub
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cm = e.getActionCommand();
		if(cm.equals("Đăng nhập")) {
			this.view.kiemTraDangNhap();
		}else if(cm.equals("Đăng ký")) {
			this.view.dangKyMoi();
		}

	}

}
