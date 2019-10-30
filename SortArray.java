import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SortArray extends JPanel {
	static final int ARRAYMAX=(Visualizer.HEIGHT-Visualizer.MENUHEIGHT)/2;
	private static int BARWIDTH=10;
	public static int NUMBARS=Visualizer.WIDTH/(BARWIDTH+1);
	private int sleepTime=10;
	private Bar[] data;
	private boolean aux;
	
	
	public SortArray() {
		this.aux=false;
		data=new Bar[NUMBARS];
		for(int i=0;i<data.length;i++)
			data[i]=new Bar(i+1);
	}
	public SortArray(boolean aux) {
		this.aux=aux;
		data=new Bar[NUMBARS];
		for(int i=0;i<data.length;i++)
			data[i]=new Bar(0);
	}

	
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		super.paintComponent(g2);
		for(int i=0;i<data.length;i++) {
			if(data[i].color()) 
				g2.setColor(Color.RED);
			else
				g2.setColor(Color.BLACK);
			if(!aux)
				g2.fillRect(i+BARWIDTH*i,0,BARWIDTH,data[i].val());
			else if(aux)
				g2.fillRect(i+BARWIDTH*i,0,BARWIDTH,data[i].val());
				
		}
		if(aux) {
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2.drawString("Auxillery Array",Visualizer.WIDTH/2-60,SortArray.ARRAYMAX/2);
		}
		
	}
	
	public void shuffle() {
		Random r=new Random();
		for(int i=0;i<data.length-1;i++)
			swap(i,r.nextInt(NUMBARS-1));
		Visualizer.running=false;
	}
	
	public void swap(int x, int y) {
		int temp=data[x].val();
		data[x].setVal(data[y].val());
		data[y].setVal(temp);
		
		update();
	}
	
	private long milliToNano(long m) {
		return 1000000*m;
	}
	
	public Bar[] data() {return data;}
	
	public void update() {
		repaint();
		Visualizer.sleepFor(milliToNano(sleepTime));
	}
	
	public void incSleepTime() {
		if(sleepTime<20)
			sleepTime++;
	}
	public void decSleepTime() {
		if(sleepTime>0)
			sleepTime--;
	}
	public int getSpeed() {
		if(sleepTime<10)
			return 20-sleepTime;
		else if(sleepTime>10)
			return 10-(sleepTime-10);
		else
			return sleepTime;
	}
	public void incBarWidth() {BARWIDTH++;}
	public void decBarWidth() {if(BARWIDTH>1)BARWIDTH--;}
	
	public void reconstruct() {
		NUMBARS=Visualizer.WIDTH/(BARWIDTH+1);
		data=new Bar[NUMBARS];
		for(int i=0;i<data.length;i++)
			data[i]=new Bar(i+1);
	}
	public void unHighlightAll() {
		for(int i=0;i<data.length;i++)
			data[i].unHighlight();
	}
	
	
	

	
}
