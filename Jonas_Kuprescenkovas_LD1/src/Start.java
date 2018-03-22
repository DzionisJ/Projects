
public class Start
{
	
	public static void main(String[] args)
	{
		Animal_shelter shelterAnimals = new Animal_shelter();
	
		shelterAnimals.sortbyfoodconsumption();
		for(shop thing:shelterAnimals)   
		{
			System.out.println(thing.id +" : Suvalgytas maistas - " + thing.Allanimals.mostfood + " Gramai");
		}
		
		System.out.println("||=====================================================================================================||");
		shelterAnimals.sortbymicecaught();
		for(shop thing:shelterAnimals)   
		{
			System.out.println(thing.id +" : Pagautos peles - " + thing.Allanimals.caughtmice);
		}
		
		System.out.println("||=====================================================================================================||");
		for(shop thing:shelterAnimals)
		{
			//TODO
			System.out.println(thing.id);
			System.out.println("||=====================================================================================================||");
			thing.showanimalinfo();

		}
		
	}
}	
