import java.util.*;

public abstract class Graphics_cards
{
	private static String info = "GTA 1050Ti,1500"; // read a file maybe?...
	
	public static String getinfo()
	{
		return info;	
	}
	
	public static List<Graphics_cards> start()
	{
		List<Graphics_cards> cards = new ArrayList<Graphics_cards>();
		
		Graphics_cards g = new CardsList(getinfo()); 
		Graphics_cards gg = new CardsList("Pie,666"); //cuz this is a drag
		cards.add(g);
		cards.add(gg);
		
		return cards;
	}
	
	public abstract void help_me();// nieko dar nedaro, cia kolkas tik kad nepamirsciau padaryt :D
}
