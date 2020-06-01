package npackage;

import java.util.ArrayList;

public class CovidApp {

	/** Creates a new instance of CovidApp */
	public static void main(String[] args) {
	ArrayList<Stat> dhb = new ArrayList<Stat>();
	Utilities.load(dhb);
	
	ProjectFrame gui = new ProjectFrame (dhb);
	gui.setVisible(true);

	}

}
