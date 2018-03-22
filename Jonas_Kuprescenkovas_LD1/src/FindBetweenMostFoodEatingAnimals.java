import java.util.Comparator;

public class FindBetweenMostFoodEatingAnimals implements Comparator<shop>
{
	@Override
	public int compare(shop arg0, shop arg1)
	{
        return (arg0.Allanimals).findMostFoodEatingAnimal() - (arg1.Allanimals).findMostFoodEatingAnimal();
	}	
	
}
