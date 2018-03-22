import java.util.Comparator;

public class SomeCriteria implements Comparator<Faculty>
{

	@Override
	public int compare(Faculty arg0, Faculty arg1)
	{
		return arg0.animals.evaluateSomeCriteria() - arg1.animals.evaluateSomeCriteria();
	}

}
