package genericClassExample;

class GenericBox<T extends Number> {
	private T thing;

	public GenericBox(T thing) {
		super();
		this.thing = thing;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	
}
public class Main {
	public static void main(String[] args) {
		GenericBox<Number> g = new GenericBox<Number>(5.0f);
	}
}
