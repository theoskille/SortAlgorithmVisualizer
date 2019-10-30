
public class MergeSort {
	public static void run(SortArray array) {
		SortArray aux=new SortArray(true);
		Visualizer.addArray(aux);
		sort(array,0,array.data().length-1,aux);
		Visualizer.removeArray(aux);
		array.unHighlightAll();
        array.update();
        Visualizer.running=false;
	}
	
	public static void sort(SortArray array, int lo, int hi, SortArray aux) {
		if(hi<=lo) return;
		array.update();
		aux.update();
		int mid=(lo+hi)/2;
		sort(array,lo,mid,aux);
		sort(array,mid+1,hi,aux);
		merge(array,lo,mid,hi,aux);
	}
	
	public static void merge(SortArray array, int lo, int mid, int hi, SortArray aux) {
		int i=lo;
		int j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux.data()[k].setVal(array.data()[k].val());
		aux.update();
		for(int k=lo;k<=hi;k++) {
			array.data()[k].highlight();
			array.update();
			if(i>mid) {
				array.data()[k].setVal(aux.data()[j].val());
				aux.data()[j].highlight();
				aux.update();
				j++;
			}else if(j>hi) {
				array.data()[k].setVal(aux.data()[i].val());
				aux.data()[i].highlight();
				aux.update();
				i++;
			}else if(aux.data()[j].val()<aux.data()[i].val()) {
				array.data()[k].setVal(aux.data()[j].val());
				aux.data()[j].highlight();
				aux.update();
				j++;
			}else {
				array.data()[k].setVal(aux.data()[i].val());
				aux.data()[i].highlight();
				aux.update();
				i++;
			}
			array.data()[k].unHighlight();
			aux.unHighlightAll();
		}
		array.update();
	}
}
