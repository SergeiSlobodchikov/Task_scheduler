package Seminar5;


import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public interface ExportFile {

    public void exportToXml(List<Contact> contacts, String filePath) throws IOException, XMLStreamException;

    public void exportToCsv(List<Contact> contacts, String filePath) throws IOException;
}
