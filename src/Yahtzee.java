//Emily Kessler
//April 2014

import java.util.Scanner;

import javax.swing.JOptionPane;


public class Yahtzee {
	private static Player player1 = new Player();
	private static Player player2 = new Player();

	public static void main(String[] args) throws InterruptedException {
		String name1 = "", name2 = "";
		int whatplayer = 1;
	
		boolean loop = true;
			while(loop == true || name1 == "" ){
				try{
					name1 = JOptionPane.showInputDialog("Player 1, please enter your first name");
					if(name1 != null) loop = false;
					else loop = true;
				}catch(Exception e){
					loop = true;
					}
				}
			
			loop = true;
			while(loop == true || name1 == "" || name2 == ""){
				try{
					
					name2 = JOptionPane.showInputDialog("Player 2, please enter your first name");
					if(name2 != null) loop = false;
					else loop = true;
				}catch(Exception e){
					loop = true;
					}
				}
			
		
		for(int u = 0; u < 13; u++){  
			whatplayer = 1;
			player1.playerTurn(whatplayer, name1);
			
			whatplayer = 2;
			player2.playerTurn(whatplayer, name2);
		}
		
		
		player1.getScore();
		player2.getScore();
		
		if(player1.compareTo(player2) == 1 ){
			JOptionPane.showMessageDialog(null, "The winner is " + name1);
		}else if(player1.compareTo(player2) == -1 ){
			JOptionPane.showMessageDialog(null, "The winner is player " + name2);
		}else{
			JOptionPane.showMessageDialog(null, "It's a tie");
		}
		
		System.exit(0);

	}

}