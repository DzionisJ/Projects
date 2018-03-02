import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Animal
{
	private int animalID;
	private String Name;
	private String species;
	
	public void setAnimalinfo(int id, String name, String s)
	{
		this.animalID = id;
		this.Name = name;
		this.species = s;
	}
	
	public int getanimalID()
	{
		return animalID;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String getSpecies()
	{
		return species;
	}
	
	static public List<Animal> start()
	{
		List<Animal> Allanimals = new ArrayList<Animal>();
		
		Random rng = new Random();
		int ID; String[] names = {"Tom","Simon","Fluffy","Bastard","Doggo","Spooder"};
		String rng_name; String[] species = {"Dog","Cat"};
		String rng_species;
		
		Animal one = new Dog();
		one.setAnimalinfo(ID = rng.nextInt(100)+1, rng_name = names[new Random().nextInt(names.length)], 
						  rng_species = species[new Random().nextInt(species.length)]);
		Allanimals.add(one);
		
		Animal two = new Dog();
		two.setAnimalinfo(ID = rng.nextInt(100)+1, rng_name = names[new Random().nextInt(names.length)], 
						  rng_species = species[new Random().nextInt(species.length)]);
		Allanimals.add(two);
//********************* cats below		
		Animal three = new Cat(); 
		three.setAnimalinfo(ID = rng.nextInt(100)+1, rng_name = names[new Random().nextInt(names.length)],		  
						  rng_species = species[new Random().nextInt(species.length)]);
		Allanimals.add(three);
		
		return Allanimals;
	}
	
	public abstract long How_Long_Has_This_Animal_Stayed_in_Shelter(); 
	
	public long getStuffff()
	{
		return How_Long_Has_This_Animal_Stayed_in_Shelter();
	}
	
	public Animal() //default constructor
	{
	}

	static public void print(List<Animal> Allanimals) // printing all the animals that are in the list
	{
		 for(int i=0; i<3; i++)
		 {			
			System.out.println("ID " + Allanimals.get(i).getanimalID() +" " + Allanimals.get(i).getName()+" " + 
			Allanimals.get(i).getSpecies() + " " + Allanimals.get(i).getStuffff() + " days");			 
		 }
	}
}
