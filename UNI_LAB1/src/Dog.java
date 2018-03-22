import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Dog extends Animal
{	
	public Dog()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int testindividual() 
	{
		int as = 20;
		
		return as ;
	}

	@Override
	public long How_Long_Has_This_Animal_Stayed_in_Shelter()
	{
		Random rng = new Random();
		int month; 
		int day;
		
		Date date = new Date();
		LocalDate localDate = LocalDate.now();
		LocalDate inputDate = LocalDate.of(2018,month = rng.nextInt(03)+1,day = rng.nextInt(30)+1);
		long Days_of_stay_in_shelter = ChronoUnit.DAYS.between(inputDate, localDate);
		
		return Days_of_stay_in_shelter;
	}
}
