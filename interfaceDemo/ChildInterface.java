package interfaceDemo;

public interface ChildInterface extends ParentInterface {
	@Override
	default void move() {
		System.out.println("move");
	}
}
