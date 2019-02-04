package controllers;


/**
 * Edit_Create_Map_Controller performs action  for 
 * creating new map or modifying the existing maPS
 * @see File_open_Controller
 * @author Raghav
 * @author Haramanpreet
 */
public class Edit_create_Map_Controller {
	private static Edit_create_Map_Controller ecm ;

	public Edit_create_Map_Controller() {
		
	}
	public static Edit_create_Map_Controller getInstance() {
		if(ecm==null) {
			ecm = new Edit_create_Map_Controller();
		}
		return ecm;
	}
	public void tobegin()
	{
		createnewmap();
		System.out.println("hey coming in edit or create");
		
	}
	private void createnewmap() {
		// TODO Auto-generated method stub
		
	}
}

