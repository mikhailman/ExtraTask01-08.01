package jd2.htp.verishko.dao;

public class DAOException extends Exception {
    public DAOException() {

    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}