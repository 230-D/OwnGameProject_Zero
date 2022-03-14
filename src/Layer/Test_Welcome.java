package Layer;

import javax.swing.*;
import java.awt.event.*;

public class Test_Welcome extends WindowAdapter{

	static JFrame f;		

	public Test_Welcome()
	{
		f = new JFrame();	
		//f.addWindowListener(this);
		//f.setSize(300,300);
		//f.setLayout(null);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		JOptionPane.showMessageDialog(f, "Willkommen Abenteurer...drücke 'OK' um fortzufahren");
		JOptionPane.showMessageDialog(f, "... deine Reise beginnt in kürze... ");
	}

	public static void windowClose()
	{
		String name = JOptionPane.showInputDialog(f, "Gebe dein Avatarname ein:");
		int a = JOptionPane.showConfirmDialog(f, "Bist du sicher dass du "+ name +" heißen möchtest?");
			if(a == JOptionPane.YES_OPTION)
			{
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JOptionPane.showMessageDialog(f, "OK dein Avatarname ist " + name);
				//System.out.println(name);
			}
			else
			{
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				name = JOptionPane.showInputDialog(f, "Gebe dein Avatarname ein:"); 
				a = JOptionPane.showConfirmDialog(f, "Bist du sicher dass du "+ name +" heißen möchtest?");
				JOptionPane.showMessageDialog(f, "OK dein Avatarname ist " + name);
				//System.out.println(name);
			}
		System.out.println(name);
		//String sql = "INSERT INTO blabla"+"(Avatarname)" + "VALUES (?)";
		//Database.Datenbank.setString(1,name);
		//myStmt.executeUpdate();		
	}

	public static void main(String[] args) {
		
	new Test_Welcome();	

	}
}
