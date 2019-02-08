package Model;
/**
 * This class is used for Attack, Reinforcement, Fortification
 * @author YashNarra
 * version 1.0
 */
public class GamePhase {
	
	String phasename;
	
	GamePhase attack=new GamePhase("attack");
	GamePhase reinforcement=new GamePhase("reinforcement");
	GamePhase fortification=new GamePhase("fortification");
	
	
	public GamePhase(String string) {
		// TODO Auto-generated constructor stub
		this.phasename= string;
	}

	/**
	 * method for attack phase
	 */
	public void aphase() {
		this.phasename="attack";
	}
	
	/**
	 * method for reinforcement phase
	 */
	public void rphase() {
		this.phasename="reinforcement";
	}
	
	/**
	 * method for fortification phase.
	 */
	public void fphase() {
		this.phasename="fortification";
		
	}
	

}
