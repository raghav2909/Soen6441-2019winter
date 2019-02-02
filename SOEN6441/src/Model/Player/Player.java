package Model.Player;

import java.util.ArrayList;

/**
 * This class is responsible to represent the player
 * @author samansoltani
 * @version 1.0
 */
public class Player
{
    /**
     * Name of Player
     */
    private String PlayerName;
    /**
     * Player Turn
     */
    private boolean PlayerTurn = false;
    /**
     * List of Countries owned by player
     */
    private ArrayList<NodeOfCountry> PlayerCountries;
    /**
     * List of Continents owned by player
     */
    private ArrayList<NodeOfMap> PlayerContinents;
    /**
     * Number of Armies owned by player
     */
    private int PlayerArmies;
    /**
     * List of Cards owned by player
     */
    private ArrayList<Card> Cards;
    /**
     * Number of times player used cards exchange
     */
    private int PlayerCardsUsed;
    /**
     * Name of selected country for reinforcement
     */
    private String CountryReinSelect;
    /**
     * List of all continents
     */
    private ArrayList<NodeOfMap> AllContinents;
    /**
     * Number of selected armies for reinforcement
     */
    private int ArmiesReinSelect;
    /**
     * Save selected country for fortification
     */
    private NodeOfCountry SelectCountry;
    /**
     * Save neighbours of selected country
     */
    private NodeOfCountry NeSelectedCountry;
    /**
     * Changeable strategy for player
     */
    private StrategyOfPlayer PlayerStrategy;
    /**
     * Determine player still in the game or not
     */
    private boolean PlayerLost = false;
    /**
     * Save GameDrive
     */
    private GameDrive driver;
    /**
     * Set up Player with name
     * @param name Player Name
     */
    public Player(String name,GameDriver pDriver)
    {
        this.PlayerName = name;
        this.driver = pDriver;
        this.PlayerCountries = new ArrayList<NodeOfCountry>();
        this.PlayerContinents = new ArrayList<NodeOfMap>();
        this.Cards = new ArrayList<cards>();
    }
    /**
     * Set up Player with name and armies
     * @param name Player Name
     * @param Narmies Player New Armies
     */
    public Player (String name, int Narmies, GameDriver pDriver)
    {
        this.PlayerName = name;
        this.PlayerArmies = Narmies;
        this.AllContinents = new ArrayList<NodeOfMap>();
    }
    /**
     * Set up Player with name and armies
     * @param name Player Name
     * @param Narmies Player New Armies
     * @param ListOfCountries List of all counties owned by Player
     */
    public Player (String name, int Narmies,ArrayList<NodeOfCountry> ListOfCountries,GameDrive pDriver)
    {
        this(name , pDriver);
        this.PlayerArmies = Narmies;
        this.AllContinents = new ArrayList<NodeOfMap>();
        for(NodeOfCountry c: ListOfCountries)
        {
            this.AddCountry(c);
        }
    }
    /**
     * return Player Name
     * @return Player Name
     */
    public String getPlayerName()
    {
        return this.PlayerName;
    }
    /**
     * Add Country to the Player Countries
     * @param Country Name of Country own by Player
     */
    public void AddCountry (NodeOfCountry Country)
    {
        this.PlayerCountries.add(Country);
        if(Country.getOwner() != this)
        {
            Country.setOwner(this);
        }
    }
    /**
     * Return List of Countries owned by PLayer
     * @return ArrayList of Countries
     */
    public ArrayList<NodeOfCountry> getCountries()
    {
        return this.PlayerCountries;
    }
    /**
     * Gets the List of Countries Owned by Player
     * @return List Of Countries Name
     */
    public String[] getNameOfCountries()
    {
        String[] names = new String [this.PlayerCountries.size()];
        for (int i=0; i<names.length,i++)
        {
            names[i] = this.PlayerCountries.get(i).getCountryName();
            System.out.println(names[i]);
        }
        return names;
    }
    /**
     * Shows Countries owned by Player with No Armies
     * @return List of Countries with no army
     */
    public String[] getEmptyCountriesName()
    {
        ArrayList<String> names = new ArrayList<String>();
        for(NodeOfCountry c: this.PlayerCountries)
        {
            if(c.getArmyCount()=0)
                names.add(c.getCountryName());
        }
        return names.toArray(new String[names.size()]);
    }
    /**
     * Removes country from a Player Countries
     * @prarm Country removed country
     */
    public void RemoveCountry(NodeOfCountry Country)
    {
        this.PlayerCountries.remove(Country);
    }
    /**
     * Add a card to Player
     * @param card added card
     */
    public void AddCard (Card card)
    {
        this.Cards.add(card);
    }
    /**
     * Remove a card from Player
     * @param card Removed card
     */
    public void RemoveCard (Card card)
    {
        this.Cards.remove(card);
    }
    /**
     * Add a continent to Player continents
     * @param continent added continent
     */
    public void AddContinent(NodeOfMap continent)
    {
        this.PlayerContinents.add(continent);
    }
    /**
     * Remove a continent from Player continent
     * @param continent removed continent
     */
    public void RemoveContinent(NodeOfMap continent)
    {
        this.PlayerContinents.remove(continent);
    }
    /**
     * checking for continent own by player
     */
    public void ContinentCheck ()
    {
        for (NodeOfMap continent : this.AllContinents)
        {
            System.out.println(continent.getContinentName());
            if(this.PlayerCountries.containAll(Continent.getContinentList()))
            {
                addContinent(continent);
                System.out.println("Adde :" + continent.getContinentName());
            }
        }
    }
    /**
     * Calculation of armies
     * @return armies count
     */
    public int CalArmy()
    {
        ContinentCheck();
        int CountCountries = this.PlayerCountries.size();
        int CountContinents = this.PlayerContinents.size();
        int CountCards = this.Cards.size();
        int CountArmies = CountCountries/3;
        if(CountArmies < 3)
        {
            CountArmies =3;
        }
        if (CountContinents > 0)
        {
            CountContinents =0;
            for(NodeOfMap Continent : this.PlayerContinents)
            {
                CountContinents += Continent.getControlValue();
            }
        }
        CountArmies = CountContinents;
        System.out.println(CountArmies);
        return CountArmies;
    }
    /**
     * Addd armies to player
     * @param count added armies
     */
    public void AddedArmies(int count)
    {
        this.CountArmies += count;
    }
    /**
     * Remove armies to player
     * @param count removed armies
     */
    public void RemovedArmies(int count)
    {
        this.CountArmies -= count;
    }
    /**
     * Number of Player armies
     * @return number of player armies
     */
    public int getCountArmies()
    {
       return this.CountArmies();
    }
    /**
     * Node of country by country name
     * @param NewCountry the given country
     * @return matched countries
     */
    public NodeOfCountry getCountry(String NewCountry) {
        return NodeOfCountry.getCountry(PlayerCountries,NewCountry);
    }
    /**
     * Set player turn to true
     */
    public void SetTurnTrue()
    {
        this.PlayerTurn =true;
    }
    /**
     * Set player turn to false
     */
    public void SetTurnFalse()
    {
        this.PlayerTurn =false;
    }
    /**
     * give the player turn
     * @return turn of player
     */
    public boolean getTurn()
    {
        return this.PlayerTurn;
    }




























    /**
     * Set up New Strategy for Player
     */
    public void SetStrategy (StrategyOfPlayer Strategy)
    {
        this.PlayerStrategy = Strategy;
    }
    /**
     * Checking if two PLayers are equal
     */
    public boolean Equals (Object p)
    {
        if (p instanceof Player)
        {
            if(((Player) p).getPlayerName().equals(this.getPlayerName()))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Move Armies
     * @param pArmies
     * @param MaxArmies
     * @param Message
     * @return
     */
    public int MoveArmies(int pArmies,int MaxArmies, String Message)
    {
        return this.PlayerStrategy.MoveArmies(pArmies,MaxArmies,Message);
    }
    public String PlacementOfArmies()
    {
        if (getEmptyCountriesName().length !=0)
        {
            return this.PlayerStrategy.PlaceArmy(getEmptyCountriesName(),getPlayerName());
        }
        else
        {
            return.this.PlayerStrategy.PlaceArmy(getNameOfCountries(),getPlayerName());
        }
    }
}

