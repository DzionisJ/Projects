import java.util.Random;

public class Dog extends Animal
{
	int daysSpent; int avgDailyFoodUse = 320; //gramai per diena visiem sunim
	int avgsudraskytoskelnes = 2;
	
	Random rng = new Random();
	{
		daysSpent = rng.nextInt(60)+1;
	}
	
	/*Dog()
	{
		super();
	}*/
	
	@Override
	int foodEaten()
	{
		return (daysSpent * avgDailyFoodUse);
	}
	
	public int rippedjeans()
	{
		return daysSpent*avgsudraskytoskelnes;
	}

	@Override
	String animalinfo()
	{
		// TODO Auto-generated method stub
		return String.format("ID: %d, "+"Vardas: %s, "+"Dienos prieglaudoje: %d, "+"Suvalgytas maisto kiekis: %d gramai" +" Sudraskyti dzinsai : %d"
							,animalid,animalName,daysSpent,foodEaten(),rippedjeans()); 
	}
	
}
