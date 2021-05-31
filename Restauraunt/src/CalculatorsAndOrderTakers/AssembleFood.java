package CalculatorsAndOrderTakers;

public class AssembleFood<T> {
	T obj;
	private String topping;
	public AssembleFood(T obj){
		this.obj = obj;
	}
	
	@Override
	public String toString() {
		return this.obj.toString();
	}
	
	public String getTopping() {
		return "with " + topping;
	}
	
	public void setTopping(String topping) {
		this.topping = topping;
	}
}
