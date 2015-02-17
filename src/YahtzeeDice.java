//Emily Kessler
//April 2014

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class YahtzeeDice {
	private int[] diceVals = new int[5];
	private boolean[] diceHolds = new boolean[5];
	private DiceGUI gui = new DiceGUI();
	private String pname;
	private int numturns = 1;
	private static int choice;
	private static pScores[] possible = new pScores[13];
	private static int[][] usedslots = new int[13][2];
	public int player = 1;
	public static boolean yahtzeebonus = false;

	

	
	public YahtzeeDice(){
		for(int x = 0; x < 5; x++){
			diceHolds[x] = false;
			diceVals[x] = 0;
		}
		
		for(int x = 0; x < 13; x++){
			usedslots[x][0] = 0;
			usedslots[x][1] = 0;
		
		}
		
		
	}
	
	
	private static class pScores{
			String category;
			boolean valid = true;
			int score = 0;
		public pScores(String c){
			category = c;
		}
		public String toString(){
			return category;
		}
	}
	
	public int possibleScores(){
		//choose a number not type name
		//don't show ones that have been used
		int ace = 0, two =0, three=0, four=0, five=0, six=0, threekind=0, fourkind=0, fullhouse=0, lgstraight=0, smstraight=0, yahtzee=0, chance=0;
		
		for(int z = 0; z < 5; z++){
			if(diceVals[z] == 1) ace += 1;
			else if(diceVals[z] == 2) two += 2;
			else if(diceVals[z] == 3) three+= 3;
			else if(diceVals[z] == 4) four += 4;
			else if(diceVals[z] == 5) five += 5;
			else if(diceVals[z] == 6) six+= 6;		
		}
		
		for(int x = 0; x < 3; x++){
			if(diceVals[x] == diceVals[x+1] && diceVals[x] == diceVals[x+2]){
					threekind = diceVals[0] + diceVals[1] + diceVals[2] + diceVals[3] + diceVals[4] ;
		}}
		
		for(int x = 0; x < 2; x++){
			if(diceVals[x] == diceVals[x+1] && diceVals[x] == diceVals[x+2]&& diceVals[x] == diceVals[x+3]){
					fourkind = diceVals[0] + diceVals[1] + diceVals[2] + diceVals[3] + diceVals[4] ;
		}}
		
		//Full House
		if(diceVals[0] == diceVals[1] && diceVals[1] == diceVals[2] && diceVals[3] == diceVals[4] && diceVals[4] != diceVals[1]){
			fullhouse = 25;
		}else if(diceVals[0] == diceVals[1] && diceVals[2] == diceVals[3] && diceVals[4] == diceVals[3] && diceVals[4] != diceVals[1]){
			fullhouse = 25;
		}
		
		//Large Straight
		int count = 0;
		for(int z = 0; z < 4; z++){
			if(diceVals[z] == diceVals[z + 1] - 1) count++;
		}
		if(count == 4){
			lgstraight = 40;
		}
		
		//Yahtzee
		if(diceVals[0] == diceVals[1] && diceVals[0] == diceVals[2] && diceVals[0] == diceVals[3] && diceVals[0] == diceVals[4]){
			yahtzee = 50;
			yahtzeebonus = true;
		}
		
		//Small Straight
		int count2 = 0, equalcount=0;
		for(int z = 0; z < 4; z++){
			if(diceVals[z] == (diceVals[z + 1] - 1) || diceVals[z] == diceVals[z + 1]){
				if(diceVals[z] == diceVals[z+1]){
					equalcount++;
				}else{
					count2++;
				}
			}
		}
		if(diceVals[0] == 1 && diceVals[1] == 2 && diceVals[2] == 3 && diceVals[3] == 5 && diceVals[4] == 6){
		}else if(diceVals[0] == 1 && diceVals[1] == 2 && diceVals[2] == 4 && diceVals[3] == 5 && diceVals[4] == 6){	
		}else if(equalcount < 2 && count2 >= 3){
			smstraight = 30;
		}
		
		//Chance
		chance = diceVals[0] + diceVals[1] + diceVals[2] + diceVals[3] +  diceVals[4];
		
		
		String display = categories(ace, two, three, four, five, six, threekind, fourkind, fullhouse, lgstraight, smstraight, yahtzee, chance);
		
		boolean loop = true;
		while(loop == true){
			try{
				String c = JOptionPane.showInputDialog(display + "\n" + "Please type the number of the category that you would like to use.");
				choice = Integer.parseInt(c);
				if(c.equals("1") || c.equals("2") || c.equals("3") || c.equals("4") || c.equals("5") || c.equals("6") || c.equals("7") || c.equals("8") || c.equals("9") || c.equals("10") || c.equals("11") || c.equals("12") || c.equals("13")){
					loop = false;
				}else loop = true;
			}catch(Exception e){ 
				loop = true;
				}
			}
			
		
		
		
		usedslots[choice - 1][player - 1] = -1;
		
		int choiceval = 0;
		if(choice == 1){
			choiceval = ace;
		}else if(choice == 2){
			choiceval = two;
		}else if(choice == 3){
			choiceval = three;
		}else if(choice == 4){
			choiceval = four;
		}else if(choice == 5){
			choiceval = five;
		}else if(choice == 6){
			choiceval = six;
		}else if(choice == 7){
			choiceval = threekind;
		}else if(choice == 8){
			choiceval = fourkind;
		}else if(choice == 9){
			choiceval = fullhouse;
		}else if(choice == 10){
			choiceval = smstraight;
		}else if(choice == 11){
			choiceval = lgstraight;
		}else if(choice == 12){
			choiceval = yahtzee;
		}else if(choice == 13){
			choiceval = chance;
		}
		
		return choiceval;
		
		
	
	}
	
		
	public String categories(int ace,int two,int three,int four,int five,int six,int threekind,int fourkind,int fullhouse,int lgstraight,int smstraight,int yahtzee, int chance){
		String d = "";
		possible[0] = new pScores("1. Aces: " + ace);
		possible[1] = new pScores("2. Twos: " + two);
		possible[2] = new pScores("3. Threes: " + three);
		possible[3] = new pScores("4. Fours: " + four);
		possible[4] = new pScores("5. Fives: " + five);
		possible[5] = new pScores("6. Sixes: " + six);
		possible[6] = new pScores("7. Three of a Kind: " + threekind);
		possible[7] = new pScores("8. Four of a Kind: "+ fourkind);
		possible[8] = new pScores("9. Full House: " + fullhouse);
		possible[9] = new pScores("10. Small Straight: " + smstraight);
		possible[10] = new pScores("11. Large Straight: " + lgstraight);
		possible[11] = new pScores("12. YAHTZEE: " + yahtzee);
		possible[12] = new pScores("13. Chance: " + chance);
		
		for(int x = 0; x < 13; x++){
			if(usedslots[x][player - 1] != -1){ 
				d += possible[x] + "\n";
			}else{
				d += "\n";
			}
		}
		return d;
	}
		
	
	
	public void roll(String playername, int numts) throws InterruptedException{
		pname = playername;
		numturns = numts + 1;
		Random r = new Random();
		for(int x = 0; x < 5; x++){
			if(diceHolds[x] == false){
				for(int k = 0; k < 8; k++){
					diceVals[x] = r.nextInt(6) + 1;
					Thread.sleep(95);
					gui.display(diceVals, diceHolds, playername, numturns);
				}
			
			}}
		
	}
		

	
	public void score(int[] scores, int playernum){
		player = playernum;

		insertionSort();
		
		int choicescore = possibleScores(); 
		//send score array to scoregui
		scores[choice - 1] = choicescore;
		
	}
	
	
	
	public void insertionSort(){
		for (int index = 1; index < diceVals.length; index++){
			int key = diceVals[index];
			int position = index;
			
			//shift larger values to the right
			while(position > 0 && diceVals[position-1] > key){
				diceVals[position] = diceVals[position-1];
				//diceHolds[position] = diceHolds[position-1];
				position--;
			}
			diceVals[position] = key;
			//diceHolds[position] = diceHolds[key];			
		}
		
		System.out.println(diceVals);
				
	}
	
	public String toString(){
		String values = "You rolled: ";
		for(int x = 0; x < 5; x++){
			values = "" + values  + diceVals[x] + ", ";
		}
		return values;
	}

	public void resetDie(){
		for(int x = 0; x < 5; x++){
			diceHolds[x] = false;
		}
	}
	
	public void holdDie(int num){
		
		int holdanswer = JOptionPane.showConfirmDialog (null, "Would you like to hold die number " + (num + 1));
		if(holdanswer == JOptionPane.YES_OPTION){
			diceHolds[num] = true;
		}else{
			diceHolds[num] = false;
		}
		
			gui.display(diceVals, diceHolds, pname, numturns);
				
		
	}
	
	public static boolean returnYahtzee(){
		return yahtzeebonus;
	}

}
	
	

