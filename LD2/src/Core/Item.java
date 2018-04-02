package Core;

public class Item 
{
	private String Name; private Double price; private Double weight;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Item(String name, Double price2, Double weight2) {
		//super();
		Name = name;
		this.price = price2;
		this.weight = weight2;
	}
	
	@Override
    public String toString()
	{
        return getName()+" "+ getPrice()+" "+getWeight();
    }
}
