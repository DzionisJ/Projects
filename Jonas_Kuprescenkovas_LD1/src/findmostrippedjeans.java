import java.util.Comparator;

public class findmostrippedjeans implements Comparator<shop>
{

	@Override
	public int compare(shop arg0, shop arg1)
	{
		// TODO Auto-generated method stub
		return (arg0.Allanimals).mostjeans() - (arg1.Allanimals).mostjeans();
	}

}
