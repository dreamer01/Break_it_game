import javax.swing.JFrame;

public class Main {
	public static void main(String [] args){
		JFrame frame = new JFrame("Break It");
		
		BreakItPanel panel = new BreakItPanel();
		frame.getContentPane().add(panel);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(550, 550);
		frame.setResizable(false);
		
	}

}
