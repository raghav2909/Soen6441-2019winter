package controllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import view.openingdialog;
/**
 * maincr variable stores reference of class MainController
 */


public class the_main_controller {
	private static the_main_controller maincr ;
	
	private ActionListener editmap;
	
	private ActionListener playthegame;
	
	openingdialog opendialog= new openingdialog();
	public the_main_controller()
	{
		
	}
	public static the_main_controller getInstance() {
		if(maincr==null) {
			maincr = new the_main_controller();
		}
		return maincr;
	}
	
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
			{
				System.out.println("Single mode opted");
				opendialog.games_option();
			}
				else if(m=="m")
				{
				System.out.println("tournament mode opted");
				}

			opendialog.returnframe().dispose();	
		}
	};
	this.opendialog.Actiongameplay(playthegame);
}


public void Single_Mode_Start() {
	System.out.println("Coming here new game");

	File_open_Controller foc= new File_open_Controller();
	// TODO Auto-generated method stub
	
}
public void single_Mode_Saved_Start() {

	System.out.println("Coming here saved mode");
	// TODO Auto-generated method stub
	File_open_Controller foc= new File_open_Controller();
}
}
