
public class SelectionSort {
	public static void run(SortArray array) {
		 int j = 0;
		 for(int i=0;i<array.data().length-1;i++){
			if(i!=0)
				array.data()[i-1].unHighlight();
		    j = i;
		    array.data()[i].highlight();
		    for(int k = i;k<array.data().length-1;k++){
		      array.data()[k].highlight();
		      array.update();
		      if(k!=i)
		    	  array.data()[k].unHighlight();
		      if(array.data()[j].val()>array.data()[k].val()){
		        j = k;
		      }
		    }
		    array.swap(i,j);
		  }
		 array.unHighlightAll();
	     array.update();
	     Visualizer.running=false;
	}
}
