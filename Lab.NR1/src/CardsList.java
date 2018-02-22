import java.util.List;

public class CardsList extends Graphics_cards
{

	private static String name; 
	private static int price;
	
	public CardsList(String line)
	{
		String[] Graphics_card = line.split(",");
		name = Graphics_card[0];
		price = Integer.parseInt(Graphics_card[1]);
		
		System.out.println("The name: " + name + " " + "Price: " + price + "€");
	}
	
	/*public static void printingEverything(List<Graphics_cards> cards)
	{
		System.out.println("The name: " + name + " " + "Price: " + price + "€");
	}*/

	@Override
	public void help_me()
	{
		// TODO Auto-generated method stub
	
	}

}
