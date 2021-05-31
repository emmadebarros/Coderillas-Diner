package CalculatorsAndOrderTakers;

public class CashRegister {
	private double currentCash;

	public double depositCash(double deposit) {
		return currentCash += deposit;
	}

	public double getCurrentCash() {
		return currentCash;
	}

	public void setCurrentCash(double currentCash) {
		this.currentCash = currentCash;
	}

	public double returnChange(double cost, double moneyGiven) {
		if ((moneyGiven - cost) < 0) {
			System.out.println("Customer didn't give enough money");
			return -1;
		} else {
			return (moneyGiven - cost);
		}
	}

	public CashRegister(double currentCash) {
		this.currentCash = currentCash;
	}
	
	@Override
	public String toString() {
		return "current cash =" + this.currentCash;
	}
}
