package homework;

import java.util.*;

public class Phone {
	private String firstname, lastname, nickname, worknumber, homenumber, city, state, street;
	private int zip;

	public Phone(String first, String last, String nick, String work, String home, String sta, int zi, String ci,
			String stree) {
		firstname = first;
		lastname = last;
		nickname = nick;
		worknumber = work;
		homenumber = home;
		city = ci;
		state = sta;
		street = stree;
		zip = zi;

	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getWorknumber() {
		return worknumber;
	}

	public void setWorknumber(String worknumber) {
		this.worknumber = worknumber;
	}

	public String getHomenumber() {
		return homenumber;
	}

	public void setHomenumber(String homenumber) {
		this.homenumber = homenumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String toString() {
		return firstname + " " + lastname + " " + nickname + " " + worknumber + " " + homenumber + " " + state + " "
				+ zip + " " + city + " " + street + " ";
	}

}