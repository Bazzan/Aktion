

// fixa guld boolen

abstract class Object {
	
	private String name;

	
	public Object(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract public int getValue();
		
}

class Jewelry extends Object{
	private boolean gold;
	private int jewls;
	
	public Jewelry(String name,int jewls , boolean gold) {
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
	
	public String toString() {
		String str = getName() + " value: " + getValue() + " jewels: " + getJewls();
		if (gold) {
			str += " gold.";
		}else {
			str += " silver.";
		}
		return str;
	}
	
	@Override
	public int getValue() {
		return gold ? getJewls() * 500 + 2000 : getJewls() * 500 + 700;  
	}
	
}

class Stock extends Object{
	private int value;
	private int amount;
	
	public Stock (String name, int value, int amount) {
		super (name);
		this.value = value;
		this.amount = amount;
	}
	
	@Override
	public int getValue() {
		return value * amount;
	}
	
	public void blackMonday(int value) {
		value = 0;
	}
	
}

class Electronics extends Object {
	
	private int initialPrice;
	private int damage;
	private double value;
	private double price;
	
	public Electronics (String name,int iP, int damage) {
		super(name);
		this.initialPrice = iP;
		this.damage = damage;
	}
	
	public double calcValue() {
		
		price = initialPrice * damage/10;
		value = (price * 1.25);
		return value;
	}
	
	@Override
	public int getValue() {
		return (int)calcValue();
	}
	
}
