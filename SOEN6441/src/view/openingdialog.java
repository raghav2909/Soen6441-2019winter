package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controllers.the_main_controller;
import controllers.*;

public class openingdialog {
	
	JFrame first_frame;
	JButton gameplay;
	JButton mapedit;

	public void chooseplayoredit()
	{
		first_frame = new JFrame("Select an option");
		gameplay = new JButton("Play Game");
		mapedit = new JButton("Edit Map");
		first_frame.setSize(150, 150);
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
		String[] choices = {"Single","Tournament"};
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

	public void games_option() {
		JFrame f2 = new JFrame();
		f2.setLayout(new BoxLayout(f2.getContentPane(),BoxLayout.Y_AXIS));
		JButton New_Game = new JButton("New Game");
		JButton Load_Game = new JButton("Load Game");
		f2.add(Load_Game);
		f2.add(New_Game);
		f2.pack();
		f2.setVisible(true);
		
		New_Game.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				the_main_controller.getInstance().Single_Mode_Start();
				
			}
		});
		Load_Game.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e)
				{
			f2.dispose();
			the_main_controller.getInstance().single_Mode_Saved_Start();
			File_open_Controller foc= new File_open_Controller();
			
			}
				
				
		});
		
	}

}
