package Layer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Welcome implements ActionListener{

	JFrame f;
	JLabel l1,l2;
	JPanel panel;
	String name;
	JButton b1;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Welcome()
	{
		f = new JFrame("New Story Adventure");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JPanel panel = new JPanel();
		panel.setBounds(200,560,800,100);
		panel.setBackground(Color.gray);

		JOptionPane.showMessageDialog(f, "Willkommen Abenteurer...drücke 'OK' um fortzufahren");
		JOptionPane.showMessageDialog(f, "... deine Reise beginnt in kürze... ");

		String url = "jdbc:mysql://localhost/story?rewriteBatchedStatements=true";
		String user = "root";
		String pass = "";
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user,pass);
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `history` (Avatarname) VALUES(?)");
			//stmt.setString(1, "Laye");
			//stmt.setString(2, "Magier");
			//stmt = con.prepareStatement("INSERT INTO `blabla` (Charakter) VALUES(?)");
			//stmt.setString(1, "Krieger");
		
			do
			{
				name = JOptionPane.showInputDialog(f, "Gebe dein Avatarname ein:");
				int a = JOptionPane.showConfirmDialog(f, "Bist du sicher dass du '"+ name +"' heißen möchtest?");
			
				if(a == JOptionPane.YES_OPTION)
				{
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JOptionPane.showMessageDialog(f, "OK dein Avatarname ist '" + name + "'");
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
				//int i =stmt.executeUpdate();
				//System.out.println(i + " Records Inserted");
				break;
			}while(true);

		con.close();	
		}
		catch (Exception e)
		{
			//System.out.println(e);
		}

		l1 = new JLabel ("Erzähler: "
				+ "In einem dunklen Wald, wachst du bei deinem Lager auf!\r\n"
				+ " Das Lagerfeuer lodert und zischt.");
		l1.setBounds(50,50,100,30);
		l2 = new JLabel();
		l2.setBounds(50,50,100,30);
		b1 = new JButton("»");
		b1.setBounds(50,50,50,50);
		b1.setBackground(Color.green);
		f.add(panel);
		b1.addActionListener(this);
		panel.add(l1);
		panel.add(l2);
		panel.add(b1);
		//panel.add(b2);	
		f.setSize(1280,720);
		f.setLayout(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		l1.setVisible(true);
		l2.setVisible(false);
		
		for (int i = 0; i < 7; i++)
		{
			if(e.getSource() ==this.b1)
			{
				l1.setText(name+": (zzzz)..hmm..! ....Wieder der Wald\n... es ist wie ein Albtraum.... ");			
			}		
		}
	}

	public static void main(String[] args) {
		
		new Welcome();	
	}
}
