import java.util.Random;

public class Dog extends Animal
{
	int daysSpent; int avgDailyFoodUse = 320; //gramai per diena visiem sunim
	
	Random rng = new Random();
	{
		daysSpent = rng.nextInt(60)+1;
	}
	
	Dog()
	{
		super();
	}
//sukurti mamals clase ir ten uzklojamoji reksme bus
	@Override
	int foodEaten()
	{
		return (daysSpent * avgDailyFoodUse);
	}

	@Override
	String animalinfo()
	{
		// TODO Auto-generated method stub
		return String.format("ID: %d, "+"Vardas: %s, "+"Dienos prieglaudoje: %d, "+"Suvalgytas maisto kiekis: %d gramai"
							,animalid,animalName,daysSpent,foodEaten()); 
	}
	
}
