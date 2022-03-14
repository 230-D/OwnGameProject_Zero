package Database;

import java.sql.*;
import javax.swing.*;

public class Welcome_InsertName {
	static JFrame f;
	
	public Welcome_InsertName()
	{
		String url = "jdbc:mysql://localhost/test?rewriteBatchedStatements=true";
		String user = "root";
		String pass = "";
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user,pass);
				PreparedStatement stmt = con.prepareStatement("INSERT INTO `blabla` (Avatarname) VALUES(?)");
				//stmt.setString(1, "Laye");
				//stmt.setString(2, "Magier");
				//stmt = con.prepareStatement("INSERT INTO `blabla` (Charakter) VALUES(?)");
				//stmt.setString(1, "Krieger");
			
				do
				{
				/*	int ID = IOTools.readInt("Gebe eine ID ein: ");
					String Avatarname= IOTools.readString("Gebe dein Avatarname ein: ");
					String Charakter = IOTools.readString("Magier oder Krieger?");
				*/
					f = new JFrame();	
					f.setVisible(true);
				
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
				
					//stmt.setInt(1, ID);
					stmt.setString(1, name);
					//stmt.setString(2, Charakter);
				
					int i =stmt.executeUpdate();
					System.out.println(i + " Records Inserted");
					break;
				}while(true);

			con.close();	
		}
		catch (Exception e)
		{
			System.out.println(e);
		}	
	}

	public static void main(String[] args) {
		new Welcome_InsertName();
	}
}
