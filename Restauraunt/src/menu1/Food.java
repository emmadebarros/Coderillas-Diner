package menu1;

public abstract class Food {
	private double price;
	private double calories;
	private String topping;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public Food(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	public String getTopping() {
		return "with " + topping;
	}
	
	public void setTopping(String topping) {
		this.topping = topping;
	}
	
}
