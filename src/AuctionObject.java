import java.util.Comparator;

// fixa guld boolen

abstract class AuctionObject {

	private String name;

	public AuctionObject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	abstract public int getValue();

	abstract public String toString();

}

class Jewelry extends AuctionObject {
	private boolean gold;
	private int jewls;

	public Jewelry(String name, int jewls, boolean gold) {
		super(name);
		this.gold = gold;
		this.jewls = jewls;
	}

	public boolean getGold() {
		return gold;
	}

	public int getJewls() {
		return jewls;
	}

	@Override
	public int getValue() {
		double value = gold ? getJewls() * 500 + 2000 : getJewls() * 500 + 700;
		return (int)(value * (1.25));
	}

	@Override
	public String toString() {
		String str = getName() + " Value: " + getValue() + ", Jewels: " + getJewls();
		if (gold) {
			str += ", Gold. (Jewelry)";
		} else {
			str += ", Silver. (Jewelry)";
		}
		return str;
	}
}

class Stock extends AuctionObject {
	private int priceEA;
	private int amount;

	public Stock(String name, int pEA, int amount) {
		super(name);
		this.priceEA = pEA;
		this.amount = amount;
	}

	public int getPrice() {
		return priceEA;
	}

	public int getAmount() {
		return amount;
	}

	public void blackMonday() {
		priceEA = 0;
	}

	@Override
	public int getValue() {
		double value = priceEA * amount;
		return (int)(value * (1.25));
	}

	@Override
	public String toString() {
		String str = getName() + ":" + " Total value: " + getValue() + ", Price " + getPrice() + ", Amount: "
				+ getAmount() + "(Stock)";
		return str;
	}

}

class Electronics extends AuctionObject {

	private int initialPrice;
	private double damage;

	public Electronics(String name, int initialPrice, double damage) {
		super(name);
		this.initialPrice = initialPrice;
		this.damage = damage;
	}

	public int getInitialPrice() {
		return initialPrice;
	}

	public double getDamage() {
		return damage;
	}

	@Override
	public int getValue() {
		double value;
		double damageCalc = damage / 10;
		System.out.println(damage + "damage");
		value = (initialPrice * damageCalc);
		System.out.println(value + "price");
		return (int) (value * 1.25);

	}

	@Override
	public String toString() {
		String estr = getName() + ": Value " + getValue() + ", Initial price: " + getInitialPrice() + ", Damage: "
				+ (int) getDamage() + " (Electronics)";
		return estr;
	}

}
