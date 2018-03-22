import java.util.ArrayList;

public class Animals extends ArrayList<Animal>
{
	   int evaluateSomeCriteria()
	   {	   int a=0;
			 for(int i=0; i<3; i++)
			 {
				 get(i).How_Long_Has_This_Animal_Stayed_in_Shelter();
				 if(get(i) instanceof Dog)
				 {
					 a	= ((Dog)get(i)).testindividual();
				 }
			 }
		   return a;
	   }
}
