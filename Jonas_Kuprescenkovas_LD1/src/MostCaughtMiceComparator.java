import java.util.Comparator;

public class MostCaughtMiceComparator implements Comparator<shop>
{

	@Override
	public int compare(shop arg0, shop arg1)
	{
        return (arg0.Allanimals).MostCaughtMice() - (arg1.Allanimals).MostCaughtMice();
	}	

}
