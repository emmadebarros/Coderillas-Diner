package menu1;

public class Spaghetti1 extends Food{
	

	public String topping;
	
	public Spaghetti1(double price, String topping) {
		super(price);
		this.topping = topping;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}
	
	@Override
	public String toString() {
		return "Spaghetti";
	}
}
