package controllers;
import java.awt.EventQueue;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class File_open_Controller  {
	private String mapRead = null;
	
public String MapInfo(String newExtension) {
	JFrame frame = new JFrame("Map File Chooser");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.validate();
	frame.setVisible(true);
	/*JFileChooser to ask user to choose a map file.*/
	JFileChooser fc = new JFileChooser();
	fc.setCurrentDirectory(new File("./data/map"));
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Map Files", newExtension);
	fc.setFileFilter(filter);

	int returnValue = fc.showOpenDialog(frame);
	/*Get the path of the map file chosen*/
	if (returnValue == JFileChooser.APPROVE_OPTION) {
		File selectedFile = fc.getSelectedFile();
		mapRead = selectedFile.getAbsolutePath();
		frame.dispose();
		if(mapRead.substring(mapRead.lastIndexOf("."),mapRead.length()).equalsIgnoreCase("."+newExtension)){
			return mapRead;
		}
	}
	else if (returnValue == JFileChooser.CANCEL_OPTION)
	{

        JOptionPane.showMessageDialog(File_open_Controller.this, "Cancelled",
                                      "Not Open",
                                      JOptionPane.OK_OPTION);
        
	}
	else if(returnValue == JFileChooser.ERROR_OPTION)
	{
		JOptionPane.showMessageDialog(File_open_Controller.this, "Error",
                "Map Opening Error",
                JOptionPane.OK_OPTION);	
	}
	if(newExtension.equals("map")) {
		return MapInfo(newExtension);
	}
	return null;
}
}