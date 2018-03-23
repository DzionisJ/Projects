
public class Start
{
	
	public static void main(String[] args)
	{
		Animal_shelter shelterAnimals = new Animal_shelter();
	
		for(shop thing:shelterAnimals)
		{
			// isvedu pradine kolekciju kolekcija su ju duomenimis
			System.out.println(thing.id);
			System.out.println("||=====================================================================================================||");
			thing.showanimalinfo();

		}
		
		System.out.println("||=====================================================================================================||");
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
		shelterAnimals.sortbyjeans();
		for(shop thing:shelterAnimals)   
		{
			System.out.println(thing.id +" : Sudraskyti dzinsai - " + thing.Allanimals.ripjeans);
		}
		
		System.out.println("||=====================================================================================================||");
		for(shop thing:shelterAnimals)
		{
			// isvedu pradine kolekciju kolekcija su ju duomenimis isrikiuotais pagal dzinsu sudraskyma
			System.out.println(thing.id);
			System.out.println("||=====================================================================================================||");
			thing.showanimalinfo();

		}
		
	}
}	
