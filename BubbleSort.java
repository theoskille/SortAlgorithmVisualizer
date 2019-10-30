
public class BubbleSort{

	public static void run(SortArray array) {
		int n = array.data().length;  
        int temp = 0;  
        for(int i=0; i < n; i++){  
        	for(int j=1; j < (n-i); j++){  
        		if(array.data()[j-1].val() > array.data()[j].val()){
        			array.data()[j-1].highlight();
        			array.data()[j].highlight();
        			array.swap(j-1,j);
        			array.data()[j-1].unHighlight();
        			array.data()[j].unHighlight();
                }  
                          
            }  
        }
        array.unHighlightAll();
        array.update();
        Visualizer.running=false;
	}

}
