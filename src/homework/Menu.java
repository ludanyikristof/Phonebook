package homework;

import java.util.*;
import java.io.*;

public class Menu {

	public static void printMenu() {
		ArrayList <Phone > phones = new  ArrayList <Phone >() ;
		try {
			Scanner input = new Scanner(System.in);
			do {
				System.out.println("Válassz menüpontot!");
				System.out.println("1 Névjegy hozzáadás");
				System.out.println("2 Névjegyek betöltése");
				System.out.println("3 Névjegy törlése");
				System.out.println("4 Névjegy keresés");
				System.out.println("5 Vcard-ba mentés");
				System.out.println("6 Rendezés ABC szerint");
				System.out.println("7 Névjegyek listázása");

				int choose = input.nextInt();
				input.nextLine();

				switch (choose) {

				case 1:
					System.out.println("Vezetéknév: ");
					String firstname = input.nextLine();
					System.out.println("Keresztnév: ");
					String lastname = input.nextLine();
					System.out.println("Becenév: ");
					String nickname = input.nextLine();
					System.out.println("Munkehelyi telefonszám: ");
					String workphonenumber = input.nextLine();
					System.out.println("Otthoni telefonszám: ");
					String homephonenumber = input.nextLine();
					System.out.println("Megye: ");
					String state = input.nextLine();
					System.out.println("Irányítószám (ha nincs, 0): ");
					int zip = Integer.parseInt(input.nextLine());
					System.out.println("Város ");
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
					System.out.println("Törlés: (vezetéknév alapján)");
					SaveFile.remove(input.nextLine());
					break;
				case 4:
					System.out.println("Keresés: (vezetéknév keresztnév)");
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
				System.out.println("Szeretne még valamit csinalni? (I/N)");
				if (input.next().toLowerCase().charAt(0) == 'n')
					break;

			} while (true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
