import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Visualizer{
	
	public static final int WIDTH=1000;
	public static final int HEIGHT=800;
	public static final int MENUWIDTH=WIDTH;
	public static final int MENUHEIGHT=HEIGHT/4;
	private static final int BUTTONHEIGHT=40;
	private static final int BUTTONWIDTH=120;
	private static JFrame frame;
	private SortArray array;
	private JLabel speedCounter;
	private JLabel barCounter;
	private JLabel algorithmTypeLabel;
	private JLabel bestRLabel;
	private JLabel worstRLabel;
	private JLabel bestSLabel;
	private JLabel worstSLabel;
	public static boolean running;
	
	
	public Visualizer() {
		running=false;
		frame=new JFrame("Sort Algorithm Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		
		array=new SortArray();
		array.setBounds(0,0,WIDTH,SortArray.ARRAYMAX);
		
		frame.add(array);
		
		JPanel menu=new JPanel();
		menu.setBounds(0,HEIGHT-MENUHEIGHT,WIDTH,MENUHEIGHT);
		menu.setBackground(Color.GRAY);
		menu.setLayout(null);
		
		JLabel menuLabel=new JLabel("Sort Algorithms");
		menu.add(menuLabel);
		menuLabel.setBounds(30+BUTTONWIDTH*2+20,5,100,20);
		
		JLabel algorithmSpeedLabel=new JLabel("Algorithm speed");
		menu.add(algorithmSpeedLabel);
		algorithmSpeedLabel.setBounds(WIDTH-BUTTONWIDTH-8,MENUHEIGHT/2,100,20);
		
		JLabel arrayLengthLabel=new JLabel("Array Length");
		menu.add(arrayLengthLabel);
		arrayLengthLabel.setBounds(WIDTH-BUTTONWIDTH*2-8,MENUHEIGHT/2,100,20);
		
		barCounter=new JLabel(Integer.toString(SortArray.NUMBARS));
		menu.add(barCounter);
		barCounter.setBounds(WIDTH-BUTTONWIDTH*2-8,MENUHEIGHT/2+25,100,20);
		
		speedCounter=new JLabel(Integer.toString(array.getSpeed()));
		menu.add(speedCounter);
		speedCounter.setBounds(WIDTH-BUTTONWIDTH-8,MENUHEIGHT/2+25,100,20);
		
		algorithmTypeLabel=new JLabel("No Algorithm Currently Running");
		menu.add(algorithmTypeLabel);
		algorithmTypeLabel.setBounds(WIDTH-BUTTONWIDTH*3-80,5,200,20);
		
		JLabel runTimeLabel=new JLabel("Running Time:");
		menu.add(runTimeLabel);
		runTimeLabel.setBounds(WIDTH-BUTTONWIDTH*3-80,30,110,20);
		
		worstRLabel=new JLabel("Worst Case:");
		menu.add(worstRLabel);
		worstRLabel.setBounds(WIDTH-BUTTONWIDTH*3-80,50,210,20);
		
		bestRLabel=new JLabel("Best Case:");
		menu.add(bestRLabel);
		bestRLabel.setBounds(WIDTH-BUTTONWIDTH*3-80,70,210,20);
		
		JLabel spaceComplexityLabel=new JLabel("Space Complexity:");
		menu.add(spaceComplexityLabel);
		spaceComplexityLabel.setBounds(WIDTH-BUTTONWIDTH*3-80,90,120,20);
		
		worstSLabel=new JLabel("Worst Case:");
		menu.add(worstSLabel);
		worstSLabel.setBounds(WIDTH-BUTTONWIDTH*3-80,110,120,20);
		
		bestSLabel=new JLabel("Best Case:");
		menu.add(bestSLabel);
		bestSLabel.setBounds(WIDTH-BUTTONWIDTH*3-80,130,120,20);
		
		frame.add(menu);
		
		
		JButton shuffle=new JButton("Shuffle");
		shuffle.setBounds(10,MENUHEIGHT/4+BUTTONHEIGHT/2,BUTTONWIDTH,BUTTONHEIGHT);
		shuffle.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	if(!running) {
		    		running=true;
			    	Thread t = new Thread(new Runnable() {
			    	    public void run() {
			    	    	worstRLabel.setText("Worst Case:");
			    	    	bestRLabel.setText("Best Case:");
			    	    	worstSLabel.setText("Worst Case:");
			    	    	bestSLabel.setText("Best Case:");
			    	        algorithmTypeLabel.setText("shuffling");
			    	    	array.shuffle();
			    	    }
			    	});
			    	t.start();
			    }
		    }
		});   
		menu.add(shuffle);
		
		JButton bubbleSort=new JButton("Bubble Sort");
		bubbleSort.setBounds(20+BUTTONWIDTH,MENUHEIGHT/4,BUTTONWIDTH,BUTTONHEIGHT);
		bubbleSort.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
			    if(!running) {
			    	running=true;
			    	Thread t = new Thread(new Runnable() {
			    	    public void run() {
			    	    	worstRLabel.setText("Worst Case: O(n^2)");
			    	    	bestRLabel.setText("Best Case: O(n)");
			    	    	worstSLabel.setText("Worst Case: O(1)");
			    	    	bestSLabel.setText("Best Case: O(1)");
			    	    	algorithmTypeLabel.setText("Bubble Sort");
			    	        BubbleSort.run(array);
			    	    }
			    	});
			    	t.start();
			    }
		    }
		});   
		menu.add(bubbleSort);
		
		JButton selectionSort=new JButton("Selection Sort");
		selectionSort.setBounds(30+BUTTONWIDTH*2,MENUHEIGHT/4,BUTTONWIDTH,BUTTONHEIGHT);
		selectionSort.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	if(!running) {
		    		running=true;
			    	Thread t = new Thread(new Runnable() {
			    	    public void run() {
			    	    	worstRLabel.setText("Worst Case: O(n^2)");
			    	    	bestRLabel.setText("Best Case: O(n^2)");
			    	    	worstSLabel.setText("Worst Case: O(1)");
			    	    	bestSLabel.setText("Best Case: O(1)");
			    	    	algorithmTypeLabel.setText("Selection Sort");
			    	        SelectionSort.run(array);
			    	    }
			    	});
			    	t.start();
		    	}
		    }
		});   
		menu.add(selectionSort);
		
		JButton insertionSort=new JButton("Insertion Sort");
		insertionSort.setBounds(40+BUTTONWIDTH*3,MENUHEIGHT/4,BUTTONWIDTH,BUTTONHEIGHT);
		insertionSort.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	if(!running) {
		    		running=true;
			    	Thread t = new Thread(new Runnable() {
			    	    public void run() {
			    	    	worstRLabel.setText("Worst Case: O(n^2)");
			    	    	bestRLabel.setText("Best Case: O(n)");
			    	    	worstSLabel.setText("Worst Case: O(1)");
			    	    	bestSLabel.setText("Best Case: O(1)");
			    	    	algorithmTypeLabel.setText("Insertion Sort");
			    	        InsertionSort.run(array);
			    	    }
			    	});
			    	t.start();
		    	}
		    }
		});   
		menu.add(insertionSort);
		
		JButton mergeSort=new JButton("Merge Sort");
		mergeSort.setBounds(20+BUTTONWIDTH,MENUHEIGHT/4+BUTTONHEIGHT+10,BUTTONWIDTH,BUTTONHEIGHT);
		mergeSort.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	if(!running) {
		    		running=true;
			    	Thread t = new Thread(new Runnable() {
			    	    public void run() {
			    	    	worstRLabel.setText("Worst Case: O(nLogn)");
			    	    	bestRLabel.setText("Best Case: O(nLogn)");
			    	    	worstSLabel.setText("Worst Case: O(n)");
			    	    	bestSLabel.setText("Best Case: O(n)");
			    	    	algorithmTypeLabel.setText("Merge Sort");
			    	        MergeSort.run(array);
			    	    }
			    	});
			    	t.start();
		    	}
		    }
		});   
		menu.add(mergeSort);
		
		JButton quickSort=new JButton("Quick Sort");
		quickSort.setBounds(30+BUTTONWIDTH*2,MENUHEIGHT/4+BUTTONHEIGHT+10,BUTTONWIDTH,BUTTONHEIGHT);
		quickSort.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	if(!running) {
		    		running=true;
			    	Thread t = new Thread(new Runnable() {
			    	    public void run() {
			    	    	worstRLabel.setText("Worst Case: O(n^2)");
			    	    	bestRLabel.setText("Best Case: O(nLogn)");
			    	    	worstSLabel.setText("Worst Case: O(n)");
			    	    	bestSLabel.setText("Best Case: O(logn)");
			    	    	algorithmTypeLabel.setText("Quick Sort");
			    	        QuickSort.run(array);
			    	    }
			    	});
			    	t.start();
		    	}
		    }
		});   
		menu.add(quickSort);
		
		JButton heapSort=new JButton("Heap Sort");
		heapSort.setBounds(40+BUTTONWIDTH*3,MENUHEIGHT/4+BUTTONHEIGHT+10,BUTTONWIDTH,BUTTONHEIGHT);
		heapSort.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	if(!running) {
		    		running=true;
			    	Thread t = new Thread(new Runnable() {
			    	    public void run() {
			    	    	worstRLabel.setText("Worst Case: O(nLogn)");
			    	    	bestRLabel.setText("Best Case: O(nLogn)");
			    	    	worstSLabel.setText("Worst Case: O(1)");
			    	    	bestSLabel.setText("Best Case: O(1)");
			    	    	algorithmTypeLabel.setText("Heap Sort");
			    	        HeapSort.run(array);
			    	    }
			    	});
			    	t.start();
		    	}
		    }
		});   
		menu.add(heapSort);
		
		JButton decSpeed=new JButton("Speed -");
		decSpeed.setBounds(WIDTH-BUTTONWIDTH-10,MENUHEIGHT/14+BUTTONHEIGHT+5,BUTTONWIDTH-20,BUTTONHEIGHT-10);
		decSpeed.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	array.incSleepTime();
		    	speedCounter.setText(Integer.toString(array.getSpeed()));
		    	menu.repaint();
		    }
		});   
		menu.add(decSpeed);
		
		JButton incSpeed=new JButton("Speed +");
		incSpeed.setBounds(WIDTH-BUTTONWIDTH-10,MENUHEIGHT/14,BUTTONWIDTH-20,BUTTONHEIGHT-10);
		incSpeed.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	array.decSleepTime();
		    	speedCounter.setText(Integer.toString(array.getSpeed()));
		    	menu.repaint();
		    }
		});   
		menu.add(incSpeed);
		
		JButton incArray=new JButton("Length +");
		incArray.setBounds(WIDTH-BUTTONWIDTH*2-10,MENUHEIGHT/14,BUTTONWIDTH-20,BUTTONHEIGHT-10);
		incArray.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	if(!running) {
		    		running=true;
			    	array.decBarWidth();
			    	array.reconstruct();
			    	barCounter.setText(Integer.toString(SortArray.NUMBARS));
			    	menu.repaint();
			    	running=false;
		    	}
		    }
		});   
		menu.add(incArray);
		
		JButton decArray=new JButton("Length -");
		decArray.setBounds(WIDTH-BUTTONWIDTH*2-10,MENUHEIGHT/14+BUTTONHEIGHT+5,BUTTONWIDTH-20,BUTTONHEIGHT-10);
		decArray.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)            {
		    	if(!running) {
		    		running=true;
			    	array.incBarWidth();
			    	array.reconstruct();
			    	barCounter.setText(Integer.toString(SortArray.NUMBARS));
			    	menu.repaint();
			    	running=false;
		    	}
		    }
		});   
		menu.add(decArray);
		
		menu.repaint();
		
		
		
	}
	
	public static void sleepFor(long sleepTime) {
		long timeElapsed;
		final long startTime=System.nanoTime();
		do {
			timeElapsed=System.nanoTime()-startTime;
		}while(timeElapsed<sleepTime);
	}
	
	public static void addArray(SortArray array) {
		frame.add(array);
		array.setBounds(0,SortArray.ARRAYMAX,WIDTH,SortArray.ARRAYMAX);
	}
	public static void removeArray(SortArray array) {
		frame.remove(array);
		frame.repaint();
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Visualizer visualizer=new Visualizer();
	}

}
