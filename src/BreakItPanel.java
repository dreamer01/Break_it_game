import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BreakItPanel extends JPanel implements KeyListener{
	
	ArrayList<Block> blocks =new ArrayList<Block>();
	ArrayList<Block> ball =new ArrayList<Block>();
	
	int score=0;
	Block bat;
	Thread thread;
	Animate animate;
	
	BreakItPanel(){
		bat=new Block(210,485,100,25,"bat.png");
		
		for(int i=0;i<=8;i++){
			blocks.add(new Block((i*60+2),0,60,25,"blue.png"));
		}
		for(int i=0;i<=8;i++){
			blocks.add(new Block((i*60+2),25,60,25,"red.png"));
		}
		for(int i=0;i<=8;i++){
			blocks.add(new Block((i*60+2),50,60,25,"green.png"));
		}
		
		ball.add(new Block(250,455,25,25,"ball.png"));
		addKeyListener(this);
		setFocusable(true);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Block b : blocks)
			b.draw(g, this);
		for(Block b : ball)
			b.draw(g, this);
		bat.draw(g, this);
	}
	
	public void update(){
		
		for(Block b: ball){
			b.x+=b.dx;
			if(b.x>(getWidth()-25)&&b.dx>0 || b.x<0)
				b.dx*=-1;
			if(b.y<0||b.intersects(bat))
				b.dy*=-1;
			if(b.y>(getHeight()-25))
				{
				JOptionPane.showMessageDialog(null, "Game Over Your Score is :"+score);
				System.exit(0);
				}
				
			b.y+=b.dy;
			
			for(Block bl: blocks){
				if(b.intersects(bl)&& !bl.destroyed){
					bl.destroyed=true;
					score++;
					b.dy*=-1;
				}
			}
		}
		
		
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			animate=new Animate(this);
			thread=new Thread(animate);
			thread.start();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT&& bat.x>0)
			bat.x-=20;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT&& bat.x<(getWidth()-bat.getWidth()))
			bat.x+=20;
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
