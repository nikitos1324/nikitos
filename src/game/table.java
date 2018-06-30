package game;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
public class table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      JFrame  w = new JFrame("Окно");
	   w.setSize(800,800);
	   w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   w.setLayout(new BorderLayout(1,1));
	   w.setVisible(true);
	   
	   Canvas canv = new Canvas();
	   w.add(canv);
	}

}
class Canvas extends JComponent{
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		Graphics2D gg=(Graphics2D)g;
		gg.setPaint(Color.black);   
		gg.drawRect(5,5,800,800);
	    gg.drawRect(5,5,100,100);
	    gg.setColor(Color.magenta);
	    
	    gg.fillRect(105,5,100,100);
	    gg.drawRect(205,5,100,100);
	    gg.fillRect(305,5,100,100);
	    gg.drawRect(405,5,100,100);
	    gg.fillRect(505,5,100,100);
	    gg.drawRect(605,5,100,100);
	    gg.fillRect(705,5,100,100);
	    
	    gg.fillRect(5,105,100,100);
	    gg.drawRect(5,205,100,100);
	    gg.fillRect(5,305,100,100);
	    gg.drawRect(5,405,100,100);
	    gg.fillRect(5,505,100,100);
	    gg.drawRect(5,605,100,100);
	    gg.fillRect(5,705,100,100);
	   
	    gg.drawRect(105,105,100,100);  
	    gg.fillRect(105,205,100,100);
	    gg.drawRect(105,305,100,100);
	    gg.fillRect(105,405,100,100);
	    gg.drawRect(105,505,100,100);
	    gg.fillRect(105,605,100,100);
	    gg.drawRect(105,705,100,100);
	    
	    
	    gg.fillRect(205,105,100,100);
	    gg.drawRect(205,205,100,100);
	    gg.fillRect(205,305,100,100);
	    gg.drawRect(205,405,100,100);
	    gg.fillRect(205,505,100,100);
	    gg.drawRect(205,605,100,100);
	    gg.fillRect(205,705,100,100);
	    
	    gg.drawRect(305,105,100,100);  
	    gg.fillRect(305,205,100,100);
	    gg.drawRect(305,305,100,100);
	    gg.fillRect(305,405,100,100);
	    gg.drawRect(305,505,100,100);
	    gg.fillRect(305,605,100,100);
	    gg.drawRect(305,705,100,100);
	    
	    gg.fillRect(405,105,100,100);
	    gg.drawRect(405,205,100,100);
	    gg.fillRect(405,305,100,100);
	    gg.drawRect(405,405,100,100);
	    gg.fillRect(405,505,100,100);
	    gg.drawRect(405,605,100,100);
	    gg.fillRect(405,705,100,100);
	    
	    gg.drawRect(505,105,100,100);  
	    gg.fillRect(505,205,100,100);
	    gg.drawRect(505,305,100,100);
	    gg.fillRect(505,405,100,100);
	    gg.drawRect(505,505,100,100);
	    gg.fillRect(505,605,100,100);
	    gg.drawRect(505,705,100,100);
	    
	    gg.fillRect(605,105,100,100);
	    gg.drawRect(605,205,100,100);
	    gg.fillRect(605,305,100,100);
	    gg.drawRect(605,405,100,100);
	    gg.fillRect(605,505,100,100);
	    gg.drawRect(605,605,100,100);
	    gg.fillRect(605,705,100,100);
	    
	    gg.drawRect(705,105,100,100);  
	    gg.fillRect(705,205,100,100);
	    gg.drawRect(705,305,100,100);
	    gg.fillRect(705,405,100,100);
	    gg.drawRect(705,505,100,100);
	    gg.fillRect(705,605,100,100);
	    gg.drawRect(705,705,100,100);
	    
	    gg.setColor(Color.black);
	    gg.fillOval(5,105,100,100);
	    gg.fillOval(205,105,100,100);
	    gg.fillOval(405,105,100,100);
	    gg.fillOval(605,105,100,100);
	    gg.fillOval(105,5,100,100);
	    gg.fillOval(305,5,100,100);
	    gg.fillOval(505,5,100,100);
	    gg.fillOval(705,5,100,100);
	    gg.fillOval(305,205,100,100);
	    gg.fillOval(505,205,100,100);
	    gg.fillOval(705,205,100,100);
	    gg.fillOval(105,205,100,100);
	    
	    gg.setColor(Color.white);
	    gg.fillOval(5,705,100,100);
	    gg.fillOval(5,505,100,100);
	    gg.fillOval(705,605,100,100);
	    gg.fillOval(605,505,100,100);
	    gg.fillOval(605,705,100,100);
	    gg.fillOval(505,605,100,100);
	    gg.fillOval(305,605,100,100);
	    gg.fillOval(105,605,100,100);
	    gg.fillOval(205,505,100,100);
	    gg.fillOval(405,505,100,100);
	    gg.fillOval(205,705,100,100);
	    gg.fillOval(405,705,100,100);
	}
}
class panel extends JPanel
{
	Color[] masColor;
	int tCol = 0;
	int mX, mY;
	boolean flag = false;
	
	public panel()

{
		addMouseListener(new myMouse1());
		
		}
	public class myMouse1 implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}}
	