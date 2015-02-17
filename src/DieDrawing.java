import java.awt.*;

import javax.swing.*;

public class DieDrawing {
	private int sideWidth;
	private int face;
	private boolean hold;
	private int xCoor;
	private int yCoor;
	

	public DieDrawing(int width, int x, int y){
		sideWidth = width;
		xCoor = x;
		yCoor = y;
	}
	
	public void setFace(int f){
		face = f;
	}
	
	public void setHold(boolean a){
		hold = a;
	}
	
	public static void  drawText(Graphics e, String name, String numturns) {
		
		e.setColor(Color.black);
		e.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		e.drawString("Player: ", 300, 50);
		e.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		e.drawString("Roll: " + numturns, 475, 275);
		e.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		e.setColor(Color.lightGray);
		e.drawString(name, 350, 100);
		
	}
	
	public void  draw(Graphics g) {
			
			if(hold){
				g.setColor(Color.cyan);
			}else{
				g.setColor(Color.black);
			}
			g.drawRect( xCoor, yCoor, sideWidth, sideWidth);
			if(face == 1){
				g.fillOval(xCoor + (sideWidth/2) - 5, yCoor + (sideWidth / 2) - 5, 10, 10);
			}else if(face == 2){
				g.fillOval(xCoor + (1* sideWidth/4) - 5, yCoor + (sideWidth / 2) - 25, 10, 10);
				g.fillOval(xCoor + (3*sideWidth/4) - 5, yCoor + (sideWidth / 2) + 15, 10, 10);
			}else if(face == 3){
				g.fillOval(xCoor + (sideWidth/ 4) - 5, yCoor + (sideWidth / 2) - 25, 10, 10);
				g.fillOval(xCoor + (sideWidth/2) - 5, yCoor + (sideWidth / 2) - 5, 10, 10);
				g.fillOval(xCoor + (3 * sideWidth/ 4) - 5, yCoor + (sideWidth / 2) + 15, 10, 10);
			}else if(face == 4){
				g.fillOval(xCoor + (1* sideWidth/4) - 5, yCoor + (sideWidth / 2) - 25, 10, 10);
				g.fillOval(xCoor + (3*sideWidth/4) - 5, yCoor + (sideWidth / 2) + 15, 10, 10);
				g.fillOval(xCoor + (1* sideWidth/4) + 30, yCoor + (sideWidth / 2) - 25, 10, 10);
				g.fillOval(xCoor + (3*sideWidth/4) - 40, yCoor + (sideWidth / 2) + 15, 10, 10);
			}else if(face == 5){
				g.fillOval(xCoor + (1* sideWidth/4) - 5, yCoor + (sideWidth / 2) - 25, 10, 10);
				g.fillOval(xCoor + (sideWidth/2) - 5, yCoor + (sideWidth / 2) - 5, 10, 10);
				g.fillOval(xCoor + (3*sideWidth/4) - 5, yCoor + (sideWidth / 2) + 15, 10, 10);
				g.fillOval(xCoor + (1* sideWidth/4) + 30, yCoor + (sideWidth / 2) - 25, 10, 10);
				g.fillOval(xCoor + (3*sideWidth/4) - 40, yCoor + (sideWidth / 2) + 15, 10, 10);
			}else if(face == 6){
				g.fillOval(xCoor + (1* sideWidth/4) - 5, yCoor + (sideWidth / 2) - 25, 10, 10);
				g.fillOval(xCoor + (3*sideWidth/4) - 5, yCoor + (sideWidth / 2) + 15, 10, 10);
				g.fillOval(xCoor + (1* sideWidth/4) + 30, yCoor + (sideWidth / 2) - 25, 10, 10);
				g.fillOval(xCoor + (3*sideWidth/4) - 40, yCoor + (sideWidth / 2) + 15, 10, 10);
				g.fillOval(xCoor + (1* sideWidth/4) - 5, yCoor + (sideWidth / 2) - 5, 10, 10);
				g.fillOval(xCoor + (3*sideWidth/4) - 5, yCoor + (sideWidth / 2) - 5, 10, 10);
			}
				
		
	}
		
}

