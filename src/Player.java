import java.util.Scanner;

import javax.swing.JOptionPane;


public class Player implements Comparable {
	private int[] playerscore = new int[13];
	private static YahtzeeDice dice = new YahtzeeDice();
	private String name;
	private static ScoreGUI squishy = new ScoreGUI();
	private boolean yahtzeebonus = false;
	
	
	public Player(){
		for(int y = 0; y < 13; y++){
			playerscore[y] = -1;
		}
	}
	
		
	public String getName(){
		return name;
	}
	
	public void playerTurn(int turn, String names) throws InterruptedException{
		int turnnum = turn;
		name = names;
		int numturns = 0;
		while(numturns <= 2){
			System.out.println("Roll number " + (numturns + 1));
			dice.roll(name, numturns);
			dice.resetDie();
			System.out.println(dice.toString());
			if(numturns < 2){
				int holdanswer = JOptionPane.showConfirmDialog (null, "Would you like to roll again?");
				if(holdanswer == JOptionPane.YES_OPTION){
					for(int x = 0; x < 5; x++){
						dice.holdDie(x);}
				}else{
					numturns = 3;
				}}
			numturns++;	
		}
		
		
		dice.score(playerscore, turnnum);
		squishy.display(playerscore, turnnum, name);
		
		Thread.sleep(1000);
		
	}

	public int getScore(){
		int playertotal = total();
		int playerupper = 0, playerlower = 0;
		int playeruppertotal = 0;
		int upperbonus = 0;
		
		for(int x = 0; x < 6; x++){
			playerupper = playerupper + playerscore[x];
		}
		for(int x = 6; x < 13; x++){
			playerlower = playerlower + playerscore[x];
		}
		
		if(playerupper >= 63){
			playeruppertotal = playerupper + 35;
			playertotal = playertotal + 35;
			upperbonus = 1;
		}
		
		boolean yahtzeebonus = YahtzeeDice.returnYahtzee();
		
		
		squishy.endDisplay(playerupper, playerlower, playeruppertotal, playertotal, upperbonus, yahtzeebonus);
		return playertotal;
	}

	public int total(){
		int tot = 0;
		for(int x = 0; x < 13; x++){
			if(playerscore[x] != -1){
				tot = tot + playerscore[x];
			}
			
		}		
		return tot;
	}
	
	public int compareTo(Object player2) {
		if(((Player) player2).getScore() > getScore()){
			return -1;
		}else if(((Player) player2).getScore() < getScore()){
			return 1;
		}else{
			return 0;
		}

	}



}
