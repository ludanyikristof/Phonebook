package homework;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class phonetest {
	Phone a ;
	@Before
	public void setup() {
		 a = new Phone("Lud�nyi", "Krist�f", "Krisi", "06308888888", "06304888888", "Heves", 3231,
				"Gy�ngy�ssolymos", "Szabads�g");
	}

	@Test
	public void testCount() {
		assertEquals(SaveFile.count(), 2);
	}

	@Test
	public void testAdd() {
		int c = SaveFile.count() + 1;
		
		SaveFile.saveFile(a);
		assertEquals(SaveFile.count(), c);
	}

	@Test
	public void testRemove() {
		int b = SaveFile.count() - 1;
		SaveFile.remove("Lud�nyi");
		assertEquals(SaveFile.count(), b);
	}

	@Test
	public void testCompare() {
		Phone o1 = new Phone("Lud�nyi", "Krist�f", "Krisi", "06308888888", "06304888888", "Heves", 3231,
				"Gy�ngy�ssolymos", "J�kai");
		Phone o2 = new Phone("Kiss", "Istv�n", "Pista", "06308888888", "06304888888", "Heves", 3231, "Gy�ngy�ssolymos",
				"Szabads�g");
		ArrayList<Phone> p = new ArrayList<Phone>();
		p.add(o1);
		p.add(o2);
		Collections.sort(p, new NameComparator());
		assertEquals(p.get(0).getFirstname(), "Kiss");

	}

	@Test
	public void testSearch() {
		assertEquals(SaveFile.search("Lud�nyi"), 1);
	}

	@Test
	public void testLoad() {
		File f = new File("contact.txt");
		ArrayList<Phone> p = null;
		try {
			p = SaveFile.loadFile(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(p.get(0).getFirstname(), "Lud�nyi");
	}
	@Test
	public void testGetState() {
		assertEquals("Heves",a.getState());
		
	}
	@Test
	public void testGetFirstName()   {
		assertEquals("Lud�nyi",a.getFirstname()); 
		
	}
	@Test
	public void testGetLastName () {
		assertEquals("Krist�f",a.getLastname());
		
	}
	@Test
	public void testToString() {
		String x = "Lud�nyi Krist�f Krisi 06307971401 0637303345 Heves 3231 Gy�ngy�ssolymos J�kai";
		assertEquals("toString",x,a.toString());
		
		
	}

}
