import java.util.ArrayList;
import java.util.Collections;

public class Shelter extends ArrayList<Faculty>
{
	// does nothing for now
	void sortFacultiesBySomeCriteria(){
	      Collections.sort(this, new SomeCriteria());
	   }

}
