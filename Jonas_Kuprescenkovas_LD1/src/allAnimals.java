import java.util.ArrayList;

public class allAnimals extends ArrayList<Animal>
{//sarasas visu gyvunu
	int allanimals;
	int mostfood = 0;
	int caughtmice = 0;
	
	public allAnimals(int animalcount)
	{
		this.allanimals = animalcount;
	}

	public int findMostFoodEatingAnimal()
	{
		for(int i = 0; i < allanimals; i++) 
		{   
			get(i).foodEaten();
			if(get(i) instanceof Dog) 
			{
				if(((Dog)get(i)).foodEaten() > mostfood) 
				{
					mostfood = ((Dog)get(i)).foodEaten();
				}
			}
			else if (get(i) instanceof Cat) {
				if(((Cat)get(i)).foodEaten() > mostfood) {
					mostfood = ((Cat)get(i)).foodEaten();
				}
			}
		}
		return mostfood;
	}
	
	
	int MostCaughtMice() 
	{
		for(int i = 0; i < size(); i++) 
		{	
			if(get(i) instanceof Cat) 
			{
				caughtmice = ((Cat)get(i)).allCaughtMice();
			}
		}
		return caughtmice;
	}
}
