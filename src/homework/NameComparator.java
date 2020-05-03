package homework;

import java.util.Comparator;

public class NameComparator implements Comparator<Phone> {

 
	public  int compare(Phone o1, Phone o2) {
		String s1 = o1.getFirstname();
		String s2 = o2.getFirstname();
		return s1.compareToIgnoreCase(s2);
		
	}
	

}
