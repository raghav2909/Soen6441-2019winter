package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.openingdialog;

public class the_main_controller {
	
	private ActionListener editmap;
	
	private ActionListener playthegame;
	
	openingdialog opendialog= new openingdialog();
	
	public void tostart()
	{
		chooseplayoredit();
		gameplay();
	}


public void chooseplayoredit()
{
	opendialog.chooseplayoredit();
}

public void gameplay()
{
	playthegame = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String m =opendialog.decideMode();
			if(m=="s")
				System.out.println(1);
			else if(m=="m")
				System.out.println("more");

			opendialog.returnframe().dispose();	
		}
	};
	this.opendialog.Actiongameplay(playthegame);
}
}
