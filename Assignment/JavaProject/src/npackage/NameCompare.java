package npackage;

import java.util.Comparator;

public class NameCompare implements Comparator<Stat>{

	@Override
	public int compare(Stat o1, Stat o2) {
		return o1.getCountry().compareTo(o2.getCountry());
	}
}
