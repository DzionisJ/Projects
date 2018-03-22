import java.util.Random;

public abstract class Animal
{
	String[] namesList = {"Buluma","Kakarott","Cell","Tina","Mitty","Roger","Doodle","Snakey","Timmy","Fluffy","Mark","Sam","Aurora"};
	private Random rng = new Random();
	
	protected int animalid;
	protected String animalName;
	 
	public int makeID()
	{
		return animalid = rng.nextInt(100)+1;
	}
	
	public String randomname()
	{
		int ins = rng.nextInt(namesList.length);
		String animalName = (namesList[ins]);
		
		return animalName;
	}
	
	Animal()
	{
		this.animalid = makeID();
		this.animalName = randomname();
	}
	
	abstract int foodEaten();
	abstract String animalinfo();
}
