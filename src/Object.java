import java.util.Comparator;

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
	
	abstract public String toString();
	
//	public static Comparator<Object> nameComp = new Comparator<Object>() {
//		
//	}
		
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
	
	@Override
	public int getValue() {
		return gold ? getJewls() * 500 + 2000 : getJewls() * 500 + 700;  
	}
	@Override
	public String toString() {
		String str = getName() + " Value: " + getValue() + ", Jewels: " + getJewls();
		if (gold) {
			str += ", Gold.";
		}else {
			str += ", Silver.";
		}
		return str;
	}
}

class Stock extends Object{
	private int pEA; //priceEach
	private int amount;
	
	public Stock (String name, int pEA, int amount) {
		super (name);
		this.pEA = pEA;
		this.amount = amount;
	}
	
	public int getPrice() {
		return pEA;
	}
	public int getAmount() {
		return amount;
	}
	
	public void blackMonday () {
		pEA = 0;
	}
	
	@Override
	public int getValue() {
		return pEA * amount;
	}
	
//	public void blackMonday(int value) {
//		value = 0;
//	}
	@Override
	public String toString() {
		String str = getName() + ":" + " Total value: " + getValue() + ", Price " + getPrice() + ", Amount: " + getAmount() ;
		return str;
	}
	
}

class Electronics extends Object {
	
	private int initialPrice;
	private double damage;
	
	public Electronics (String name,int initialPrice, double damage) {
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
		System.out.println(damage+ "damage");
		value = (initialPrice * damageCalc);
		System.out.println(value + "price");
		return (int) (value * 1.25);
		
	}
	@Override
	public String toString() {
		String estr = getName() + ": Value " + getValue()  + ", Initial price: " + getInitialPrice() + ", Damage: " + (int) getDamage();
		return estr;
	}
	
}
