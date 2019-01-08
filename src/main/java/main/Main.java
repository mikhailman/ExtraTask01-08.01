package main;

import dao.DAOException;
import dao.IJAXBParser;
import dao.implementation.JAXBParser;

public class Main {
    public static void main(String[] args) throws DAOException {
        IJAXBParser jaxbParser = new JAXBParser();
        System.out.println(jaxbParser.read());

    }
}