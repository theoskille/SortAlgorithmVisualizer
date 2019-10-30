
public class HeapSort {
	public static void run(SortArray array) {
		int length=array.data().length-1;
		for(int i=array.data().length/2;i>=0;i--) 
			sink(array,i,length);
		while(length>0) {
			array.data()[0].highlight();
			array.data()[length].highlight();
			array.update();
			array.swap(0,length);
			array.unHighlightAll();
			length--;
			sink(array,0,length);
		}
		array.unHighlightAll();
        array.update();
        Visualizer.running=false;
		
	}
	
	public static void sink(SortArray array, int k,int length) {
		int size=length;
		while(2*k<=size) {
			int j=2*k;
			if(j<size && array.data()[j].val()<array.data()[j+1].val())
				j++;
			if(!(array.data()[k].val()<array.data()[j].val()))
					break;
			array.data()[j].highlight();
			array.data()[k].highlight();
			array.update();
			array.swap(k,j);
			array.unHighlightAll();
			k=j;
		}
	}
}
