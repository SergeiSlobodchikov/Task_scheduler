package Seminar5;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        PhonebookUI phonebook = new PhonebookUI("contacts");
        phonebook.run();
    }
}
