package abstractClassExample;

public abstract class Abstract1 {
	public int a, b;
	public void show() {
		System.out.println("Print");
	}
	
	public static void main(String[] args) {
		Abstract1 a = new Proper();
		a.show();
	}
}

class Proper extends Abstract1{
	@Override
	public void show() {
		System.out.println("kulla");
	}
}
