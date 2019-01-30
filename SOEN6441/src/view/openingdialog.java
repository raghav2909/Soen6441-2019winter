package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class openingdialog {
	
	JFrame first_frame;
	JButton gameplay;
	JButton mapedit;

	public void chooseplayoredit()
	{
		first_frame = new JFrame("Select an option");
		gameplay = new JButton("Play Game");
		mapedit = new JButton("Edit Map");
		first_frame.setSize(300, 300);
//		freme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		first_frame.setLayout(new FlowLayout());
		first_frame.add(gameplay);
		first_frame.add(mapedit);
//		freme.validate();
		first_frame.setVisible(true);
	}
	
	public String decideMode()
	{
		JFrame fr= new JFrame("Choose Mode of the Game");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		String[] choices = {"Single","Multi-player"};
		int h;
		h=JOptionPane.showOptionDialog(fr, "Select the game mode to play", "CHOOSE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		if(h==0)
		{
			fr.dispose();
			return "s";
		}
		else
		{
			fr.dispose();
			return "m";
		}
		
		
//		return "single";
	}
	public JFrame returnframe()
	{
		return this.first_frame;
	}
	public void Actiongameplay(ActionListener action)
	{
		this.gameplay.addActionListener(action);
	}

}
