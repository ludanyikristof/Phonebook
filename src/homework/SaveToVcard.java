package homework;
import java.util.*;

import java.io.*;

public class SaveToVcard {

	public static void vcard() throws IOException {
		File file = new File("contact2.vcf");
		FileOutputStream fop = new FileOutputStream(file);
		Scanner input = new Scanner (System.in);
		
		System.out.print("Név (kereszt vezeték): ");
		String firstname = input.nextLine();
		//String lastname = input.nextLine();
		System.out.print("Cég: ");
		String company = input.nextLine();
		System.out.print("Telefonszám: ");
		String number = input.nextLine();
		System.out.print("Email: ");
		String email = input.nextLine();

		if (file.exists()) {
			/*String vcard = "BEGIN:VCARD\n" + "VERSION:4.0\n" + "N:"+Forrest+";Forrest;;;\n" + "FN:Forrest Gump\n"
					+ "ORG:Bubba Gump Shrimp Co.\n" + "TITLE:Shrimp Man\n"
					+ "TEL;TYPE=work,voice;VALUE=uri:tel:+1-111-555-1212\n"
					+ "TEL;TYPE=home,voice;VALUE=uri:tel:+1-404-555-1212\n" + "EMAIL:forrestgump@example.com\n"
					+ "REV:20080424T195243Z\n" + "END:VCARD";*/
			String v = String.format("BEGIN:VCARD\n" + "VERSION:4.0\n" + "N:;;;;\n" + "FN:%s\n"
					+ "ORG:%s\n" + "TITLE:\n"
					+ "TEL;TYPE=work,voice;VALUE=uri:%s\n"
					+ "TEL;TYPE=home,voice;VALUE=uri:\n" + "EMAIL:%s\n"
					+ "REV:20080424T195243Z\n" + "END:VCARD",firstname, company, number,email);
			fop.write(v.getBytes());

			BufferedReader br = null;
			String currentLine;
			br = new BufferedReader(new FileReader("contact2.vcf"));
			while ((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);
			}

			fop.flush();
			fop.close();
			System.out.println("Complete");
		} else
			System.out.println("file doesnt exist");

	}
}
