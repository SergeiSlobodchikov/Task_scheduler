package Seminar5;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public interface ImportFile {

    public List<Contact> importFromXml(String filePath) throws IOException, XMLStreamException ;

    public List<Contact> importFromCsv(String filePath) throws IOException;

}
