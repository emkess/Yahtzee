import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.File;
import java.io.IOException;

public class ScoreGUI {
	private final int WIDTH = 450;
	private final int HEIGHT = 615;
	private JFrame Sframe; 
	private drawingJPanel Spanel;
	private static int[][] playerscore = new int[13][2];
	private String player1name = "";
	private String player2name = "";
	private String p1tot = "", p2tot = "", p1u = "", p2u = "", p1l = "", p2l = "", p1ut = "", p2ut = "";
	Image background;
	private int p1upperbonus = 0, p2upperbonus = 0;
	private boolean yahtzeebonus1 = false, yahtzeebonus2 = false;
	

	int temp = 1;
	int temp2 = 1;

	public ScoreGUI(){
				
		for(int r = 0; r < 13; r++){
			playerscore[r][0] = -1;
			playerscore[r][1] = -1;
		}
		
		Sframe = new JFrame("Score Card");
		
				
		Sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Spanel = new drawingJPanel();
		Spanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			
		//5. Put the panel into the frame content pane
		Sframe.getContentPane().add(Spanel);
		
		//6. Set the frame size at or above preferred size
		Sframe.pack();
			
		Spanel.setBackground(Color.lightGray);
		//7. Make frame visible
		Sframe.setVisible(true);
		Sframe.setLocation(700, 0);
	
		background = new ImageIcon("Yahtzee.jpg").getImage();
		Spanel.repaint();
		
	}
	
	
	
	public void display(int[] pscores, int turnnum, String name){
		if(temp == 1){
			if(name.length() <= 3){
				player1name = name;
			}else{
				player1name = ""+ name.charAt(0) + name.charAt(1) + name.charAt(2);
			}
		}
		if(temp == 2){
			if(name.length() <= 3){
				player2name = name;
			}else{
				player2name = ""+ name.charAt(0) + name.charAt(1) + name.charAt(2);
		}
		}
		
		
		temp++;
		
		if(turnnum == 1){
			for(int x = 0; x < 13; x++){
				playerscore[x][0] = pscores[x];
			}
		}else{
			for(int x = 0; x < 13; x++){
				playerscore[x][1] = pscores[x];
		}}
		
			
		Spanel.repaint();
	}
	
	public void endDisplay(int playerupper, int playerlower, int playeruppertotal, int playertotal, int upperbonus, boolean yb){
		if(temp2 == 1){
			p1tot = "" + playertotal;
			p1u = "" + playerupper;
			p1l = "" + playerlower;
			p1ut = "" + playeruppertotal;
			p1upperbonus = upperbonus;
			yahtzeebonus1 = yb;
		}
		
		
		
		if(temp2 == 2){
			p2tot = "" + playertotal;
			p2u = "" + playerupper;
			p2l = "" + playerlower;
			p2ut = "" + playeruppertotal;
			p2upperbonus = upperbonus;
			yahtzeebonus1 = yb;
		}
		
		temp2++;
		
		Spanel.repaint();
	}
	
	
	
	private class drawingJPanel extends JPanel{
		
		public void paintComponent(Graphics k){
					
			super.paintComponent(k);
			k.drawImage(background, 0, 0, null);
			int r = 55;
			k.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			k.setColor(Color.cyan);
			k.drawString(player1name, 200, 22);
			k.drawString(player2name, 240, 22);
			k.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			
			for(int w = 0; w < 6; w++){
				if(playerscore[w][0] != -1){
					k.drawString("" + playerscore[w][0], 210, r); 
					r = r + 25;
				}else r = r + 25;
			}
			r = r + 110;
			for(int w = 6; w < 13; w++){
				if(playerscore[w][0] != -1){
					k.drawString("" + playerscore[w][0], 210, r); 
					r = r + 26;
				}else r = r + 26;
			}
				
			
			r = 55;
			k.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			k.setColor(Color.cyan);
			for(int w = 0; w < 6; w++){
				if(playerscore[w][1] != -1){
					k.drawString("" + playerscore[w][1], 250, r); 
					r = r + 25;
				}else r = r + 25;
			}
			r = r + 110;
			for(int w = 6; w < 13; w++){
				if(playerscore[w][1] != -1){
					k.drawString("" + playerscore[w][1], 248, r); 
					r = r + 26;
				}else r = r + 26;
			}
			
			
			
			
			k.drawString(p1u, 210, 208);
			k.drawString(p2u, 250, 208);
			if(p1upperbonus == 1){
				k.drawString("" + 35, 210, 240);
			}
			if(p2upperbonus == 1){
				k.drawString("" + 35, 210, 240);
			}
					
			k.drawString(p1ut, 210, 265);
			k.drawString(p2ut, 250, 265);
			k.drawString(p1l, 210, 550);
			k.drawString(p2l, 250, 550);
			k.drawString(p1u, 210, 577);
			k.drawString(p2u, 250, 577);
			k.drawString(p1tot, 210, 605);
			k.drawString(p2tot, 250, 605);
		
		}
				
	}

}
