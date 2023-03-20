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
    private String file = "contacts";
    private ExportFile exportFile;
    private ImportFile importFile;

    public Phonebook(String filePath) {
        this.contacts = new ArrayList<>();
        this.exportFile = new ExploreFileTo(filePath);
        this.importFile = new ImportFileTo(filePath);
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

    // Метод для удаления контакта
    public void removeContact(Scanner scanner) {
        System.out.println("Введите информацию о контакте, который нужно удалить:");
        System.out.print("Имя, фамилия, номер телефона или email: ");
        String searchQuery = scanner.nextLine();
        List<Contact> contactsToRemove = searchContacts(searchQuery);
        if (contactsToRemove.isEmpty()) {
            System.out.println("Контакт не найден.");
        } else {
            System.out.println("Найдены контакты: ");
            for (int i = 0; i < contactsToRemove.size(); i++) {
                System.out.println((i + 1) + ". " + contactsToRemove.get(i));
            }
            System.out.print("Введите номер контакта для удаления (0 для отмены): ");
            try {
                int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
                if (index >= 0 && index < contactsToRemove.size()) {
                    Contact contactToRemove = contactsToRemove.get(index);
                    contacts.remove(contactToRemove);
                    System.out.println("Контакт удален: " + contactToRemove);
                } else if (index == -1) {
                    System.out.println("Удаление отменено.");
                } else {
                    System.out.println("Неверный номер контакта.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат номера контакта.");
            }
        }
    }

    public void exportContactsToCsv() throws IOException {
        exportFile.exportToCsv(contacts, this.file);
    }

    public void importContactsFromCsv() throws IOException {
        List<Contact> importedContacts = importFile.importFromCsv(this.file);
        for (Contact contact : importedContacts) {
            if (!contacts.contains(contact)) {
                contacts.add(contact);
            }
        }
    }

    public void importContactsFromXml() throws IOException, XMLStreamException {
        List<Contact> importedContacts = importFile.importFromXml(this.file);
        for (Contact contact : importedContacts) {
            if (!contacts.contains(contact)) {
                contacts.add(contact);
            }
        }
    }

    public void exportContactsToXml() throws IOException, XMLStreamException {
        exportFile.exportToXml(contacts, this.file);
    }

    // Поиск контакта
    public List<Contact> searchContacts(String searchTerm) {
        List<Contact> searchContact = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstName().contains(searchTerm)
                    || contact.getLastName().contains(searchTerm)
                    || contact.getPhoneNumber().contains(searchTerm)
                    || contact.getEmail().contains(searchTerm)) {
                searchContact.add(contact);
            }
        }
        if (searchContact.size() == 0){
            System.out.println("Не найдено контактов");
        }
        return searchContact;
    }

    // Печать Контакта
    public void printAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }
}
