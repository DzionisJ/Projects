import java.util.Random;

public class Cat extends Animal
{
int daysSpent; //praleistos dienos 
int avgDailyFoodUse = 280; //gramai per diena visiem sunim
int avgCaughtMicePerDay = 2;
	
	Random rng = new Random();
	{
		daysSpent = rng.nextInt(60)+1;
	//avgCaughtMicePerDay = rng.nextInt(3)+1;
	}
	
	/*Cat()
	{
		super();
	}*/
	
	public int allCaughtMice()
	{
		return daysSpent * avgCaughtMicePerDay;
	}
	
	@Override
	int foodEaten()
	{
		return (daysSpent * avgDailyFoodUse);
	}

	@Override
	String animalinfo()
	{
		// TODO Auto-generated method stub
		return String.format("Uzklojamoji reiksme ID: %d, "+"Vardas: %s, "+"Dienos prieglaudoje: %d, "+"Suvalgytas maisto kiekis: %d gramai, "
							+"Pagautos Peles: %d",animalid,animalName,daysSpent,foodEaten(),allCaughtMice()); 
	}
}
