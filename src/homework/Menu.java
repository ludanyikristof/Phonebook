package homework;

import java.util.*;
import java.io.*;

public class Menu {

	public static void printMenu() {
		ArrayList <Phone > phones = new  ArrayList <Phone >() ;
		try {
			Scanner input = new Scanner(System.in);
			do {
				System.out.println("V�lassz men�pontot!");
				System.out.println("1 N�vjegy hozz�ad�s");
				System.out.println("2 N�vjegyek bet�lt�se");
				System.out.println("3 N�vjegy t�rl�se");
				System.out.println("4 N�vjegy keres�s");
				System.out.println("5 Vcard-ba ment�s");
				System.out.println("6 Rendez�s ABC szerint");
				System.out.println("7 N�vjegyek list�z�sa");

				int choose = input.nextInt();
				input.nextLine();

				switch (choose) {

				case 1:
					System.out.println("Vezet�kn�v: ");
					String firstname = input.nextLine();
					System.out.println("Keresztn�v: ");
					String lastname = input.nextLine();
					System.out.println("Becen�v: ");
					String nickname = input.nextLine();
					System.out.println("Munkehelyi telefonsz�m: ");
					String workphonenumber = input.nextLine();
					System.out.println("Otthoni telefonsz�m: ");
					String homephonenumber = input.nextLine();
					System.out.println("Megye: ");
					String state = input.nextLine();
					System.out.println("Ir�ny�t�sz�m (ha nincs, 0): ");
					int zip = Integer.parseInt(input.nextLine());
					System.out.println("V�ros ");
					String city = input.nextLine();
					System.out.println("Utca ");
					String street = input.nextLine();

					SaveFile.saveFile(new Phone(firstname, lastname, nickname, workphonenumber, homephonenumber, state,
							zip, city, street));

					break;
				case 2:
					File f = new File("contact.txt");
					try {
						phones = SaveFile.loadFile(f);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("\n" + "Done");

					break;
				case 3:
					System.out.println("T�rl�s: (vezet�kn�v alapj�n)");
					SaveFile.remove(input.nextLine());
					break;
				case 4:
					System.out.println("Keres�s: (vezet�kn�v keresztn�v)");
					SaveFile.search(input.nextLine());

					break;

				case 5:
					SaveToVcard.vcard();
					break;
				case 6:
					phones = SaveFile.loadFile(new File("contact.txt"));

					Collections.sort(phones, new NameComparator());
					for (Phone j : phones) {
						System.out.println(j);
					}
					break;
				case 7:
					for ( Phone i : phones) {
						System.out.println(i);
					}
					
			
					

				default:
					break;
				}
				System.out.println("Szeretne m�g valamit csinalni? (I/N)");
				if (input.next().toLowerCase().charAt(0) == 'n')
					break;

			} while (true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
