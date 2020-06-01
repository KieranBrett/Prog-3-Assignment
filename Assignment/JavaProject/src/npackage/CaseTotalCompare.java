package npackage;

import java.util.Comparator;

public class CaseTotalCompare implements Comparator<Stat> {
	
	@Override
	public int compare(Stat c1, Stat c2) {
		
		return c2.getTotalCases() -c1.getTotalCases();
	}

}
