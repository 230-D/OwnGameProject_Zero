package Layer;

import javax.swing.*;

public class Test_Layer {
	
	public static void main(String[] args) {
		JFrame f = new JFrame("New Story Adventure");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		JLabel l1,l2;
		l1 = new JLabel("First Label");
		l1.setBounds(50,500,100,30);
		l2 = new JLabel("Second Label");
		l2.setBounds(50,100,100,30);
		JButton b = new JButton("click");
		b.setBounds(130,100,100,40);
		f.add(l1);
		f.add(l2);
		f.add(b);
		f.setSize(1280,720);
		f.setLayout(null);
		f.setVisible(true);
	}
}
