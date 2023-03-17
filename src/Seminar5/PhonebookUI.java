package Seminar5;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;

public class PhonebookUI {
    private Phonebook phonebook;

    public PhonebookUI(String filePath) {
        phonebook = new Phonebook(filePath);
    }

    public void run() throws IOException, XMLStreamException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Импортировать контакты из CSV файла");
            System.out.println("4. Экспортировать контакты в CSV файл");
            System.out.println("5. Импортировать контакты из XML файла");
            System.out.println("6. Экспортировать контакты в XML файл");
            System.out.println("7. Поиск контакта");
            System.out.println("8. Вывести все контакты");
            System.out.println("9. сменить путь файла");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    removeContact(scanner);
                    break;
                case 3:
                    importContactsFromCsv();
                    break;
                case 4:
                    exportContactsToCsv();
                    break;
                case 5:
                    importContactsFromXml();
                    break;
                case 6:
                    exportContactsToXml();
                    break;
                case 7:
                    searchContacts(scanner);
                    break;
                case 8:
                    printAllContacts();
                    break;
                case 9:
                    filePath(scanner);
                    break;
                default:
                    System.out.println("Выберите корректное действие!");
                    break;
            }
        }
    }
    private void addContact(Scanner scanner) {
        System.out.println("Введите имя:");
        String firstName = scanner.next();

        System.out.println("Введите фамилию:");
        String lastName = scanner.next();

        System.out.println("Введите номер телефона:");
        String phoneNumber = scanner.next();

        System.out.println("Введите email:");
        String email = scanner.next();

        phonebook.addContact(new Contact(firstName, lastName, phoneNumber, email));
    }

    private void removeContact(Scanner scanner){
        phonebook.removeContact(scanner);
    }

    private void importContactsFromCsv() throws IOException {
        phonebook.importContactsFromCsv();
    }
    private void importContactsFromXml() throws XMLStreamException, IOException {
        phonebook.importContactsFromXml();
    }

    private void exportContactsToCsv() throws IOException {
        phonebook.exportContactsToCsv();
    }

    private void exportContactsToXml() throws XMLStreamException, IOException {
        phonebook.exportContactsToXml();
    }

    private void printAllContacts(){
        phonebook.printAllContacts();
    }

    private void searchContacts(Scanner scanner){
        System.out.println("Введите информацию о контакте, который ищете, можно часть");
        System.out.print("Имя, фамилия, номер телефона или email: ");
        String search = scanner.next();
        phonebook.searchContacts(search);
    }

    private void filePath(Scanner scanner){
        System.out.println("Введите путь к файлу, формата csv или xml \"формат указывать не надо\"");
        String filepath = scanner.next();
        phonebook = new Phonebook(filepath);
    }
}