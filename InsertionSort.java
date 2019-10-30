
public class InsertionSort {
	
	public static void run(SortArray array) {
		int len = array.data().length-1;
		int key = 0;
		int i = 0;
		for(int j = 1;j<len;j++){
			array.data()[j-1].unHighlight();
		    key = array.data()[j].val();
		    array.data()[j].highlight();
		    i = j-1;
		    while(i>=0 && array.data()[i].val()>key){
		      array.data()[i+1].setVal(array.data()[i].val());
		      array.data()[i+1].highlight();
		      array.update();
		      array.data()[i+1].unHighlight();
		      i--;
		      array.data()[i+1].setVal(key);
		      array.update();
		      
		      
		    }
		}
		array.unHighlightAll();
        array.update();
        Visualizer.running=false;
	}
}
