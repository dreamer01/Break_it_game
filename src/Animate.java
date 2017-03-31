
public class Animate implements Runnable{
	BreakItPanel bpanel;
	
	Animate(BreakItPanel pnl){
		bpanel=pnl;
	}
	public void run(){
		while(true){
			bpanel.update();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
