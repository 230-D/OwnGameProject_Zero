package Text;

import javax.swing.*;
import java.awt.*;

public class Test_TextTransition {

		public Test_TextTransition()
		{
			JFrame f = new JFrame ("New Story Adventure");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel p = new JPanel();
			p.setBounds(200,500,800,100);
			p.setBackground(Color.gray);
			
			JTextField t1;
			t1 = new JTextField("Welcome Player..");
			t1.setBounds(50,100,200,30);
			
			JLabel l1;
			l1 = new JLabel("Welcome Player...");
			l1.setBounds(100,200,200,200);
		
			
			
			
			
			f.add(p);
			f.add(t1);
			f.add(l1);
			f.setSize(1280,720);
			f.setLayout(null);
			f.setVisible(true);
			
			
			
		}
	 	

	
	
	
	
	public static void main(String[] args) {
		
		new Test_TextTransition();
		
	   
	    
	    
	 
		
	}
}
