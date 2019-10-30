
public class QuickSort {
	public static void run(SortArray array) {
		sort(array,0,array.data().length-1);
		array.unHighlightAll();
        array.update();
        Visualizer.running=false;
	}
	
	public static void sort(SortArray array,int lo, int hi) {
		if(hi<=lo) return;
		int j=partition(array,lo,hi);
		sort(array,lo,j-1);
		sort(array,j+1,hi);
	}
	
	public static int partition(SortArray array, int lo, int hi) {
		int i=lo;
		int j=hi+1;
		int v=array.data()[lo].val();
		while(true) {
			while(array.data()[++i].val()<v) {
				array.data()[i].highlight();
				array.update();
				if(i==hi)
					break;
				array.data()[i].unHighlight();
			}
			while(v<array.data()[--j].val()) {
				array.data()[j].highlight();
				array.update();
				if(j==lo)
					break;
				array.data()[j].unHighlight();
			}
			if(i>=j)
				break;
			array.swap(i,j);
			array.unHighlightAll();
		}
		array.data()[lo].highlight();
		array.data()[j].highlight();
		array.update();
		array.swap(lo,j);
		array.unHighlightAll();
		return j;
		
	}
}
