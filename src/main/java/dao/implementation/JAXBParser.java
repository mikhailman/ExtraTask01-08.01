package dao.implementation;

import dao.DAOException;
import dao.IJAXBParser;
import entity.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParser implements IJAXBParser {

    private String path = String.valueOf(ClassLoader.getSystemResource("catalog.xml").getFile());

    public Catalog read() throws DAOException {
        Catalog catalog = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            catalog = (Catalog) unmarshaller.unmarshal(new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public void write(Catalog catalog) throws DAOException {
        try {
            JAXBContext context = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(catalog, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}