package tutes;

import java.util.Scanner;

import tutes.util.ds.Trie;

public class Contacts {
	static Trie contacts;

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        contacts = new Trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            processCommand(op, contact);
        }
	}

	private static void processCommand(String op, String contact) {
		if(op.equals("add"))
			addContact(contact);
		else if(op.equals("find"))
			findContact(contact);
	}

	private static void findContact(String contact) {
		System.out.println(contacts.findWordsWithPartial(contact));
	}

	private static void addContact(String contact) {
		contacts.addWord(contact);
	}

}
