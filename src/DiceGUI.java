import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class DiceGUI {
	private final int WIDTH = 600;
	private final int HEIGHT = 300;
	private JFrame frame; 
	private drawingJPanel panel; 
	DieDrawing dicePics[] = new DieDrawing[5];
	private String name = "";
	private String numturns = "";
	Image background;

	public DiceGUI(){
		frame = new JFrame("Yahtzee");
		
		dicePics[0] = new DieDrawing(70, 100, 150);
		dicePics[1] = new DieDrawing(70, 200, 150);
		dicePics[2] = new DieDrawing(70, 300, 150);
		dicePics[3] = new DieDrawing(70, 400, 150);
		dicePics[4] = new DieDrawing(70, 500, 150);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new drawingJPanel();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			
		//5. Put the panel into the frame content pane
		frame.getContentPane().add(panel);
		
		//6. Set the frame size at or above preferred size
		frame.pack();
			
		//7. Make frame visible
		frame.setVisible(true);
		
		background = new ImageIcon("background.jpg").getImage();
		panel.repaint();
}
	
public void display(int[] dicevals, boolean[] diceholds, String pname, Integer num){
	name = pname;
	numturns = num.toString();
	for(int x = 0; x < 5; x++){
		dicePics[x].setFace(dicevals[x]);
		dicePics[x].setHold(diceholds[x]);
	}
	panel.repaint();
}


	private class drawingJPanel extends JPanel{
				
		public void paintComponent(Graphics g){
			//Call the original paintComponent for background
			super.paintComponent(g);
		
			//Add our drawing 
			g.drawImage(background, 0, 0, null);
			DieDrawing.drawText(g, name, numturns);
			
			
			
			dicePics[0].draw(g);
			dicePics[1].draw(g);
			dicePics[2].draw(g);
			dicePics[3].draw(g);
			dicePics[4].draw(g);
			
		}
				
	}

}
