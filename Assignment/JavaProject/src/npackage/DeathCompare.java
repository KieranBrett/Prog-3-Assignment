package npackage;

import java.util.Comparator;

public class DeathCompare implements Comparator<Stat> {
	
	@Override
	public int compare(Stat c1, Stat c2) {
		
		return c2.getTotalDeaths() -c1.getTotalDeaths();
	}

}
