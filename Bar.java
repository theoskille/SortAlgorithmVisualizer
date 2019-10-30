
public class Bar {
	private int val;
	private boolean color;
	
	public Bar(int val) {
		this.val=val;
		color=false;
	}
	public int val() {return val;}
	public void setVal(int val) {this.val=val;}
	public boolean color() {return color;}
	public void highlight() {color=true;}
	public void unHighlight() {color=false;}
}
