package homework;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SaveFile {

	public static void saveFile(Phone p) {

		System.out.println("A névjegy elmentve!");
		File file = new File("contact.txt");
		try {
			if (!file.exists())
				file.createNewFile();

			PrintWriter pw = new PrintWriter(new FileWriter(file, true));

			pw.println(p.toString());
			pw.close();
		} catch (IOException e) {
			e.getMessage();
		}

	}

	public static ArrayList<Phone> loadFile(File f) throws FileNotFoundException {
		Scanner s;
		ArrayList<Phone> list = new ArrayList<Phone>();
		s = new Scanner(f);
		String[] lines;
		while (s.hasNext()) {
			lines = s.nextLine().split(" ");
			list.add(new Phone(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5], Integer.parseInt(lines[6]),
					lines[7], lines[8]));

		}
		s.close();
		return list;
	}

	public static int search(String name) {
		try {
			Scanner input = new Scanner(new File("contact.txt"));
			String[] block = new String[0];

			int i = 0;
			while (input.hasNextLine()) {

				block = input.nextLine().split(" ");
				if (block[0].equals(name)) {
					System.out.println("Keresett: " + block[0] + " " + " Volt taálálat " + name + "-ra/re");
					input.close();
					return i;

				}

				++i;
			}
			input.close();
		} catch (IOException e) {
			e.getMessage();
		}

		System.out.println("Nem található: " + name);
		return -1;
	}

	public static void remove(String n) {
		int index = search(n);
		if (index != -1) {
			try {
				File f1 = new File("contact.txt");
				Scanner input = new Scanner(new File("contact.txt"));
				String[] lines;
				Phone p;
				ArrayList<Phone> list = new ArrayList<Phone>();
				int i = 0;
				while (input.hasNextLine()) {

					lines = input.nextLine().split(" ");

					if (index != i) {
						p = new Phone(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5],
								Integer.parseInt(lines[6]), lines[7], lines[8]);
						list.add(p);
					}
					++i;
				}

				input.close();

				f1.delete();

				for (Phone j : list) {
					saveFile(j);

				}

			} catch (IOException e) {
				e.getMessage();

			}

		} else {
			System.out.println("Nem található ilyen ember!");
		}

	}

	public static int count() {
		int i = 0;
		Scanner input = new Scanner("contact.txt");
		while (input.hasNextLine()) {
			i++;

		}
		return i;
	}
	
}