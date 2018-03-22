import java.util.Random;

public class shop
{
	int id; int animalcount; allAnimals Allanimals; Random rng = new Random();

	public shop(int id, int animalcount)
	{
		this.id = id;
		this.animalcount = animalcount;	
		Allanimals = new allAnimals(animalcount);
		
		
		for(int i = 0; i < animalcount; i ++) 
		{
			//int randomanimal = 0;
			int randomanimal = rng.nextInt(2)+1;
			if(randomanimal == 1) 
			{
				Allanimals.add(new Dog());
			}
				else if(randomanimal == 2)
			{
				Allanimals.add(new Cat()); //cia pabaigai pasilikau, kurti antra subclass 
			}
		}
	}
	
	public void showanimalinfo() 
	{
		/*for(Animal ani: Allanimals)
		{
			System.out.println(ani);
		}*/
		for(Animal ani: Allanimals) 
		{
			System.out.println(ani.animalinfo());
		}
	}
}
