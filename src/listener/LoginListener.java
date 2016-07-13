package listener;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import entities.Transportation;
import frame.ImageButton;
import frame.LoginFrame;
import frame.MainFrame;
import frame_2.MainFrame_2;

public class LoginListener extends MouseAdapter implements ActionListener {

	private JTextField jtfUserName;
	private JPasswordField jpfPassword;
	private ImageButton loginButton;
	private ImageButton closeButton;
	private JRadioButton jrdMal;
	private JRadioButton jrdFamel;
	
	public LoginListener(JTextField jtfUserName, JPasswordField jpfPassword,
			ImageButton loginButton, ImageButton closeButton,JRadioButton jrdMal,JRadioButton jrdFamel) {
		this.jtfUserName = jtfUserName;
		this.jpfPassword = jpfPassword;
		this.loginButton = loginButton;
		this.closeButton = closeButton;
		this.jrdFamel = jrdFamel;
		this.jrdMal = jrdMal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jtfUserName || e.getSource() == jpfPassword
				|| e.getSource() == loginButton) {
			if (jtfUserName.getText().equals("")
					|| jpfPassword.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "请输入用户名密码！", "提示",
						JOptionPane.ERROR_MESSAGE);

			} else
				try {
					if (true){						
						if(!(jrdFamel.isSelected()||jrdMal.isSelected())){
							JOptionPane.showMessageDialog(null, "请选择用户类别！", "提示",
									JOptionPane.ERROR_MESSAGE);
						}else{
							String sex=jrdFamel.isSelected()?"用户登录":"管理员登录";
							if(Transportation.instance().login(jtfUserName.getText(),
									String.valueOf(jpfPassword.getPassword()),sex)){
								if(sex.equalsIgnoreCase("用户登录")){								
									LoginFrame.instance().setVisible(false);
									MainFrame_2.instance().open();
								}
								else{
									System.out.println("this is 管理员！");
									LoginFrame.instance().setVisible(false);
									MainFrame.instance().open();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "用户名或密码错误！", "提示",
										JOptionPane.ERROR_MESSAGE);
							}												
						}
					} 
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} else if (e.getSource() == closeButton) {
			 System.exit(0);
		}
	}
}
