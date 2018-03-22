import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Animal_shelter extends ArrayList<shop>
{
	int randomAnimalamountinShop;
	Random RNG = new Random();  	
	
	// ArrayList<Integer> list = new ArrayList<Integer>(size);
     
	Animal_shelter()
	{
	     randomAnimalamountinShop = RNG.nextInt(5)+1; // generuojam random kiekik gyvunu
		//randomAnimalamountinShop=5;

		for(int i = 0; i < 5; i++) 
		{	
		     //randomAnimalamountinShop = RNG.nextInt(5)+1; 
	         this.add(new shop(i, randomAnimalamountinShop));
		}
	}
	void sortbyfoodconsumption() 
	{
        Collections.sort(this, new FindBetweenMostFoodEatingAnimals());
    }
	void sortbymicecaught() // .
	{
        Collections.sort(this, new MostCaughtMiceComparator());
    }
}
