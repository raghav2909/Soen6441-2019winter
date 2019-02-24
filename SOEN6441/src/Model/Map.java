package Model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * This class handles the map data and also map editor.
 * @author samansoltani
 *@version 1.0
 */
public class Map extends Observable
{
	/**
	 * creating a arraylist for saving map data
	 */
	private ArrayList<NodeOfMap> MapData;
	
	
	 /**
	  * this constructor handles getting map data from map reader
	  * @param FileName the address of map
	  */
	public Map(String FileName) 
	{
		//ReadMap Reader = new ReadMap();
		//MapData = Reader.readMap(FileName);
	}
	
	/**
	 * returning the map data as an arraylist
	 * @return return the map data as an arraylist
	 */
	public ArrayList<NodeOfMap> GetMapData()
	{
		return this.MapData;
	}
	
	/**
	 * returning the map data 
	 * @return multidimensional array of map data
	 */
	public String[][] GetMapDataObject()
	{
		ArrayList<Object[]> NewData = new ArrayList<Object[]>();
		for (NodeOfMap n : MapData) 
		{
			for (NodeOfCountry m : n.getCountries()) 
			{
				String[] tempObject = new String [5];
				tempObject[1] = m.getCountryName();
				if(m.getPlayerCountry() != null)
				{
					tempObject [3] = m.getPlayerCountry().getPlayerName();
				}
				else
				{
					tempObject[3] = "";
				}
				tempObject[2] = String.valueOf(m.getArmyCount());
				NewData.add(tempObject);
				tempObject[0] = Integer.toString(m.getCoordinate()[0]);
				tempObject[4] = Integer.toString(m.getCoordinate()[1]);
			}
		}
		return NewData.toArray(new String[NewData.size()][]);
	}
	
	
	/**
	 * returning the map data
	 * @return multidimensional array of map data
	 */
	
}

