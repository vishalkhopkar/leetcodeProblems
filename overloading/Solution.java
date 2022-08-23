package overloading;

class Desktop {
	
	public void function(double a) {
		System.out.println("opera");
	}
	
	public void function(byte a) {
		System.out.println("u");
	}
	public void function(int a) {
		System.out.println("porga");
	}
	
	
}
public class Solution {

	public static void main(String[] args) {
		Desktop d = new Desktop();
		d.function(4);

	}

}
