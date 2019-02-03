package controllers;

import static java.lang.System.exit;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controllers.MessageWindow;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* 
 * @author: Gursharan
 * for Tournament mode maximum 4 players can play
*/

public class TournamentModeMenu extends JFrame {
	 private MessageWindow messageWindow;
	 private int w,h;
	 public JLabel mapLabel1 = new JLabel("No Map Selected");
	 public JLabel mapLabel2 = new JLabel("No Map Selected");
	 public JLabel mapLabel3 = new JLabel("No Map Selected");
	 public JLabel mapLabel4 = new JLabel("No Map Selected");
	 public JLabel mapLabel5 = new JLabel("No Map Selected");
	 public String[] str1 = {"Nothing", "Aggressive", "Benevolent", "Random", "Cheater"};
	 public String[] str2 = {"Nothing", "Aggressive", "Benevolent", "Random", "Cheater"};
	 public String[] str3 = {"Nothing", "Aggressive", "Benevolent", "Random", "Cheater"};
	 public String[] str4 = {"Nothing", "Aggressive", "Benevolent", "Random", "Cheater"};
	 public JComboBox tournamentstr1 = new JComboBox(str1);
	 public JComboBox tournamentstr2 = new JComboBox(str2);
	 public JComboBox tournamentstr3 = new JComboBox(str3);
	 public JComboBox tournamentstr4 = new JComboBox(str4);
	 public Integer[] ListoftournamentGames = {1, 2, 3, 4, 5};
	 public Integer[] ListoftournamentTurns = {10, 15, 20, 25, 30, 35, 40, 45, 50};
	 public JComboBox GamesInTournament = new JComboBox(ListoftournamentGames);
	 public JComboBox TurnsInTournament = new JComboBox(ListoftournamentTurns);
	 public TournamentModeMenu(MessageWindow messageWindow) {
	        super("Tournament Mode Game");
	        this.messageWindow = messageWindow;
	        this.w = 1300;
	        this.h = 500;
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(this.w, this.h);
	        setResizable(false);
	        setAlwaysOnTop(false);
	        this.setLayout(new GridBagLayout());
	        GridBagConstraints grid_bag_cons = new GridBagConstraints();
	        grid_bag_cons.insets = new Insets(10, 0, 10, 0);
	        grid_bag_cons.gridx = 0;
	        grid_bag_cons.gridy = 0;
	        getContentPane().add(mapSelector(), grid_bag_cons);
	        grid_bag_cons.gridx = 0;
	        grid_bag_cons.gridy = 1;
	        getContentPane().add(player_strategy_selector(), grid_bag_cons);
	        grid_bag_cons.gridx = 0;
	        grid_bag_cons.gridy = 2;
	      getContentPane().add(numberSelector(), grid_bag_cons);
	        grid_bag_cons.gridx = 0;
	        grid_bag_cons.gridy = 3;
	       getContentPane().add(initializeGame(), grid_bag_cons);

//	         pack(); // ignore sizing
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	/*
	 * This methods allows selection of maps in tournament mode . At max 4 maps can be selected
	 */
private JPanel mapSelector() {
    JPanel mapSelectionPanel = new JPanel();
    JPanel mapSelection = new JPanel();

    TitledBorder title = BorderFactory.createTitledBorder("First map selection to make: Select here");
    mapSelectionPanel.setBorder(title);

//    mapSelectionPanel.setPreferredSize(new Dimension(1100, 100));
    mapSelectionPanel.setLayout(new GridBagLayout());
    GridBagConstraints grid_bag_cons = new GridBagConstraints();
    grid_bag_cons.insets = new Insets(5, 15, 5, 15);

    JButton map1 = new JButton(("Select Map 1"));
    JButton map2 = new JButton(("Select Map 2"));
    JButton map3 = new JButton(("Select Map 3"));
    JButton map4 = new JButton(("Select Map 4"));
    grid_bag_cons.gridx = 1;
    grid_bag_cons.gridy = 1;
    mapSelectionPanel.add(map1, grid_bag_cons);
    grid_bag_cons.gridx = 2;
    grid_bag_cons.gridy = 1;
    mapSelectionPanel.add(map2, grid_bag_cons);
    grid_bag_cons.gridx = 3;
    grid_bag_cons.gridy = 1;
    mapSelectionPanel.add(map3, grid_bag_cons);
    grid_bag_cons.gridx = 4;
    grid_bag_cons.gridy = 1;
    mapSelectionPanel.add(map4, grid_bag_cons);
    grid_bag_cons.gridx = 5;
    grid_bag_cons.gridy = 1;
    

    //  Labels on mapSelectionPanel1
    grid_bag_cons.gridx = 1;
    grid_bag_cons.gridy = 2;

    mapSelectionPanel.add(mapLabel1, grid_bag_cons);
    grid_bag_cons.gridx = 2;
    grid_bag_cons.gridy = 2;
    mapSelectionPanel.add(mapLabel2, grid_bag_cons);
    grid_bag_cons.gridx = 3;
    grid_bag_cons.gridy = 2;
    mapSelectionPanel.add(mapLabel3, grid_bag_cons);
    grid_bag_cons.gridx = 4;
    grid_bag_cons.gridy = 2;
    mapSelectionPanel.add(mapLabel4, grid_bag_cons);
       mapSelection.add(mapSelectionPanel);
    return mapSelection;
}
/*
 * This method returns player strategies and create separate panel for it
 */
	private JPanel player_strategy_selector() {
	JPanel strategy_selector_panel = new JPanel();
	JPanel strategyButton= new JPanel();

    TitledBorder title = BorderFactory.createTitledBorder("Select strategies for each player.");
    strategy_selector_panel.setBorder(title);

//   strategy_selector_panel.setPreferredSize(new Dimension(1000, 100));
    strategy_selector_panel.setLayout(new GridBagLayout());
    GridBagConstraints grid_bag_cons = new GridBagConstraints();
    grid_bag_cons.insets = new Insets(5, 15, 5, 15);

    tournamentstr1.setSelectedIndex(1);
    tournamentstr2.setSelectedIndex(2);
    tournamentstr3.setSelectedIndex(3);
    tournamentstr4.setSelectedIndex(4);

    grid_bag_cons.gridx = 1;
    grid_bag_cons.gridy = 1;
    strategy_selector_panel.add(new JLabel("Player1 strategy:"), grid_bag_cons);
    grid_bag_cons.gridx = 1;
    grid_bag_cons.gridy = 2;
    strategy_selector_panel.add(tournamentstr1, grid_bag_cons);
    grid_bag_cons.gridx = 2;
    grid_bag_cons.gridy = 1;
    strategy_selector_panel.add(new JLabel("Player2 strategy:"), grid_bag_cons);
    grid_bag_cons.gridx = 2;
    grid_bag_cons.gridy = 2;
    strategy_selector_panel.add(tournamentstr2, grid_bag_cons);
    grid_bag_cons.gridx = 3;
    grid_bag_cons.gridy = 1;
   strategy_selector_panel.add(new JLabel("Player3 strategy:"), grid_bag_cons);
    grid_bag_cons.gridx = 3;
    grid_bag_cons.gridy = 2;
   strategy_selector_panel.add(tournamentstr3, grid_bag_cons);
    grid_bag_cons.gridx = 4;
    grid_bag_cons.gridy = 1;
   strategy_selector_panel.add(new JLabel("Player4 strategy:"), grid_bag_cons);
    grid_bag_cons.gridx = 4;
    grid_bag_cons.gridy = 2;
   strategy_selector_panel.add(tournamentstr4, grid_bag_cons);

   strategyButton.add(strategy_selector_panel);
   return strategyButton;
	}
	/*
	 * This method set settings like number of maps, number of games to play for each game in Tournament mode 
	 */
	private JPanel numberSelector() {
        JPanel numberSelectorPanel = new JPanel();
        JPanel numberSelectorButtons = new JPanel();

        TitledBorder title = BorderFactory.createTitledBorder("Set settings for Game: ");
        numberSelectorPanel.setBorder(title);

        numberSelectorPanel.setLayout(new GridBagLayout());
        GridBagConstraints grid_bag_cons = new GridBagConstraints();
       grid_bag_cons.insets = new Insets(5, 15, 5, 15);

        GamesInTournament.setSelectedIndex(0);
        TurnsInTournament.setSelectedIndex(0);


       grid_bag_cons.gridx = 1;
       grid_bag_cons.gridy = 1;
        numberSelectorPanel.add(new JLabel("Enter Number of games to play on each map."),grid_bag_cons);
       grid_bag_cons.gridx = 1;
       grid_bag_cons.gridy = 2;
        numberSelectorPanel.add(GamesInTournament,grid_bag_cons);
       grid_bag_cons.gridx = 2;
       grid_bag_cons.gridy = 1;
        numberSelectorPanel.add(new JLabel("Maximum number of turns"),grid_bag_cons);
       grid_bag_cons.gridx = 2;
       grid_bag_cons.gridy = 2;
        numberSelectorPanel.add(TurnsInTournament,grid_bag_cons);

        numberSelectorButtons.add(numberSelectorPanel);

        return numberSelectorButtons;
    }
	 private JPanel initializeGame() {
	        JPanel initializeGamePanel = new JPanel();
	        JPanel initializeGameButtons = new JPanel();

	        TitledBorder title = BorderFactory.createTitledBorder("Start the game");
	        initializeGamePanel.setBorder(title);

	        initializeGamePanel.setLayout(new GridBagLayout());
	        GridBagConstraints grid_bag_cons = new GridBagConstraints();
	        grid_bag_cons.insets = new Insets(5, 15, 5, 15);

	        JButton start = new JButton("Start the game");

	        grid_bag_cons.gridx = 0;
	        grid_bag_cons.gridy = 0;
	        initializeGamePanel.add(start,grid_bag_cons);

	        initializeGameButtons.add(initializeGamePanel);
	        return initializeGameButtons;
	 }
}