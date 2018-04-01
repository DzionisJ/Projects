package Core;

public class Item 
{
	private String Name; private int price; private int weight;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Item(String name, int price, int weight) {
		//super();
		Name = name;
		this.price = price;
		this.weight = weight;
	}
	
	@Override
    public String toString()
	{
        return getName()+" "+ getPrice()+" "+getWeight();
    }
}
