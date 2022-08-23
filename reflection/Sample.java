package reflection;

interface A {
	void show();
}
public class Sample {
	public static void main(String[] args) {
		Class<?> c = A.class;
		try {
			Class<? extends Object> c1 = Class.forName("reflection.Employee");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

class Employee {
	int id;
	String name;
}