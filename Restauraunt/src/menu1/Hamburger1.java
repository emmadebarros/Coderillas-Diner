package menu1;

public class Hamburger1 extends Food{
	
	public String topping;
	private double price;
	
	public Hamburger1(double price, String topping) {
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
		return "Hamburger";
	}
}
