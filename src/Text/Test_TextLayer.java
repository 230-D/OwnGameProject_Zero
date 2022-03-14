package Text;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test_TextLayer {

	private static JDialog d;
	
	Test_TextLayer()
	{
		JFrame f = new JFrame();
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d = new JDialog(f, "Dialog Example", true);
		d.setLayout(new FlowLayout());
		JButton b = new JButton ("OK");
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Test_TextLayer.d.setVisible(false);
			}
		});
	
		d.add(new JLabel ("Click Button to Continue..."));
		d.add(b);
		d.setSize(300,300);
		d.setVisible(true);	
	}
	
	public static void main(String[] args) {
		new Test_TextLayer();
	}
}