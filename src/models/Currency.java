package models;

/**
 * @author Brayan Esta clase es de moneda
 */

public class Currency {
	private double valueCoin;
	private String sign;
	private String name;


	public Currency(double valueCoin, String sign, String name) {
		this.valueCoin = valueCoin;
		this.sign = sign;
		this.name = name;
	}

	public double getValueCoin() {
		return valueCoin;
	}

	public void setValueCoin(double valueCoin) {
		this.valueCoin = valueCoin;
	}

	public   double multiplyCoin(double value) {
		return this.getValueCoin() * value;
	}

	public  double divideCoin(double value) {
		return this.getValueCoin() / value;
	}

	public String messageConverted(double value) {
		return "Tienes " + this.sign + value + " " + this.name;
	}

	public String messageConvertedToSoles(double value)
	{
		return "Tienes S/. " + value + " Soles";
	}

	

}
