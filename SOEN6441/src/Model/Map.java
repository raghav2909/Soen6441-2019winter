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
	public String[][] GetMapObject()
	{
		ArrayList<Object[]> NewData = new ArrayList<Object[]>();
		for (NodeOfMap n : MapData)
		{
			for(NodeOfCountry m : n.getCountries()) 
			{
				String[] tempObject = new String[5];
				tempObject[0] = n.getContinent() +", "+n.getControlValue();
				tempObject[1] = m.getCountryName();
				String Neighbours ="";
				for(String s : m.getNeighboursString())
				{
					Neighbours = Neighbours + s + ", ";
				}
				tempObject[4]= Neighbours;
				if(m.getPlayerCountry() != null) 
				{
					tempObject[3] = m.getPlayerCountry().getPlayerName();
				}
				else 
				{
					tempObject[3] = "";
				}
				tempObject[2] = String.valueOf(m.getArmyCount());
				NewData.add(tempObject);
			}
		}
		return NewData.toArray(new String[NewData.size()][]);
	}
	
	/**
	 * show the map data on console
	 */
	public void MapPrint()
	{
		Object[][] map = this.GetMapDataObject();
		for(Object[] m : map)
		{
			System.out.println("Continent Name: "+ m[0]);
			System.out.println("Country Name: "+m[1]+", Neighbours: "+m[4]+", Owner: "+m[3]+", Armies: "+m[2]);
		}
	}
	
	
	/**
	 * notify Observer for a change
	 */
	public void UpdateMap() 
	{
		setChanged();
		notifyObservers(this);
	}
	
	
	/**
	 * checking if the loaded map is valid
	 * @return true if map is valid
	 */
	public boolean MapValid() 
	{
		if (isMapConnectedGragh() && isMapNodesContainUniqueCountries())
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * checking if a map is a connected graph or not
	 * @return true if it is
	 */
	public boolean isMapConnectedGragh() 
	{
		for (NodeOfMap n : this.MapData) 
		{
			for (NodeOfCountry m : n.getCountries()) 
			{
				if (m.getNeighboursCountries() == null || m.getNeighboursCountries().length ==0) 
				{
					return false;
				}
				for (NodeOfCountry b : m.getNeighboursCountries()) 
				{
					if(b.getNeighbours().contains(m)) 
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	/**
	 *check if every country belongs to a map
	 *@return true if all continents have unique countries ;else false 
	 */
	public boolean isMapNodesContainUniqueCountries() 
	{
		ArrayList <NodeOfCountry> s = new ArrayList<NodeOfCountry>();
		for (NodeOfMap n : this.MapData) 
		{
			for (NodeOfCountry m : n.getCountries()) 
			{
				if (s.contains(m)) 
				{
					return false;
				}
				else 
				{
					s.add(m);
				}
			}
		}
		return true;
	}
}

