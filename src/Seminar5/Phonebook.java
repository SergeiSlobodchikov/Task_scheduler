package Seminar5;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Phonebook {
    private List<Contact> contacts;
    private ContactsFileManager fileManager;
    public Phonebook(String filePath) {
        this.contacts = new ArrayList<>();
        this.fileManager = new ContactsFileManager(filePath);
    }

    // метод для добавления контакта в справочник
    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            Collections.sort(contacts, new Comparator<Contact>() {
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getLastName().compareTo(c2.getLastName());
                }
            });
        } else {
            System.out.println("Контакт уже существует в справочнике!");
        }
    }


    // метод для удаления контакта из справочника
    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public void removeContact(String firstName, String lastName, String phoneNumber, String email) {
        contacts.remove(new Contact(firstName,lastName,phoneNumber,email));
    }


    public void removeContact(Scanner scanner) {
        System.out.println("Введите информацию о контакте, который нужно удалить:");
        System.out.print("Имя, фамилия, номер телефона или email: ");
        String searchQuery = scanner.nextLine().trim();

        List<Contact> contactsToRemove = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(searchQuery) ||
                    contact.getLastName().equalsIgnoreCase(searchQuery) ||
                    contact.getPhoneNumber().equalsIgnoreCase(searchQuery) ||
                    contact.getEmail().equalsIgnoreCase(searchQuery)) {
                contactsToRemove.add(contact);
            }
        }

        if (contactsToRemove.isEmpty()) {
            System.out.println("Контакт не найден.");
        } else {
            System.out.println("Найдены контакты: ");
            for (Contact contact : contactsToRemove) {
                System.out.println(contact);
            }
            System.out.print("Вы уверены, что хотите удалить эти контакты? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y")) {
                contacts.removeAll(contactsToRemove);
                System.out.println("Контакты удалены.");
            } else {
                System.out.println("Удаление отменено.");
            }
        }
    }

    public void exportContactsToCsv() throws IOException {
        fileManager.exportToCsv(contacts);
    }

    public void importContactsFromCsv() throws IOException {
        List<Contact> importedContacts = fileManager.importFromCsv();
        for (Contact contact : importedContacts) {
            if (!contacts.contains(contact)) {
                contacts.add(contact);
            }
        }
    }

    public void importContactsFromXml() throws IOException, XMLStreamException {
        List<Contact> importedContacts = fileManager.importFromXml();
        for (Contact contact : importedContacts) {
            if (!contacts.contains(contact)) {
                contacts.add(contact);
            }
        }
    }

    public void exportContactsToXml() throws IOException, XMLStreamException {
        fileManager.exportToXml(contacts);
    }

    public void searchContacts(String searchTerm) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().contains(searchTerm)
                    || contact.getLastName().contains(searchTerm)
                    || contact.getPhoneNumber().contains(searchTerm)
                    || contact.getEmail().contains(searchTerm)) {
                System.out.println(contact.toString());
            }
        }
    }

    public void printAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }
}
