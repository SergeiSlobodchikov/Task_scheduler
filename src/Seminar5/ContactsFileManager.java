package Seminar5;

import java.io.IOException;
import java.util.*;
import javax.xml.stream.*;
import java.io.*;


public class ContactsFileManager {
    private String filePath;
    public ContactsFileManager(String filePath) {
        this.filePath = filePath;
    }

    public List<Contact> importFromCsv() throws IOException {
        List<Contact> contacts = new ArrayList<>();
        Set<Contact> uniqueContacts = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath + ".csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    Contact contact = new Contact(parts[0], parts[1], parts[2]);
                    if (parts.length >= 4) {
                        contact.setEmail(parts[3]);
                    }
                    uniqueContacts.add(contact); // добавляем контакт в Set
                }
            }
        }
        contacts.addAll(uniqueContacts); // добавляем уникальные контакты из Set в List
        return contacts;
    }

    // метод для экспорта контактов в файл в формате CSV
    public void exportToCsv(List<Contact> contacts) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath + ".csv"))) {
            for (Contact contact : contacts) {
                bw.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getPhoneNumber() + "," + contact.getEmail());
                bw.newLine();
            }
        }
    }

    public List<Contact> importFromXml() throws IOException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream = new FileInputStream(filePath + ".xml");
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
        List<Contact> contacts = new ArrayList<>();
        Contact contact = null;
        String elementName = null;
        while (xmlStreamReader.hasNext()) {
            int eventType = xmlStreamReader.next();
            switch (eventType) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = xmlStreamReader.getLocalName();
                    if ("contact".equals(elementName)) {
                        contact = new Contact();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (contact != null) {
                        String data = xmlStreamReader.getText();
                        switch (elementName) {
                            case "firstName":
                                contact.setFirstName(data);
                                break;
                            case "lastName":
                                contact.setLastName(data);
                                break;
                            case "phoneNumber":
                                contact.setPhoneNumber(data);
                                break;
                            case "email":
                                contact.setEmail(data);
                                break;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = xmlStreamReader.getLocalName();
                    if ("contact".equals(elementName)) {
                        if (!contacts.contains(contact)) { // проверяем уникальность контакта
                            contacts.add(contact);
                        }
                        contact = null;
                    }
                    break;
            }
        }
        return contacts;
    }

    public void exportToXml(List<Contact> contacts) throws IOException, XMLStreamException {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        OutputStream outputStream = new FileOutputStream(filePath + ".xml");
        XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(outputStream);
        xmlStreamWriter.writeStartDocument();
        xmlStreamWriter.writeStartElement("contacts");
        for (Contact contact : contacts) {
            xmlStreamWriter.writeStartElement("contact");
            xmlStreamWriter.writeStartElement("firstName");
            xmlStreamWriter.writeCharacters(contact.getFirstName());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeStartElement("lastName");
            xmlStreamWriter.writeCharacters(contact.getLastName());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeStartElement("phoneNumber");
            xmlStreamWriter.writeCharacters(contact.getPhoneNumber());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeStartElement("email");
            xmlStreamWriter.writeCharacters(contact.getEmail());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndElement();
        }
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();
        xmlStreamWriter.flush();
        xmlStreamWriter.close();
    }
}