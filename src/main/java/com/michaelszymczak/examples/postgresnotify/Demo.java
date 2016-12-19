package com.michaelszymczak.examples.postgresnotify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// see https://jdbc.postgresql.org/documentation/head/listennotify.html
public class Demo {

    public static void main(String[] argv) throws SQLException, ClassNotFoundException {
       System.out.println("Demo!");

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://postgres:5432/postgres";

        // Create two distinct connections, one for the notifier
        // and another for the listener to show the communication
        // works across connections although this example would
        // work fine with just one connection.

        Connection lConn = DriverManager.getConnection(url,"postgres","mysecretpassword");
        Connection nConn = DriverManager.getConnection(url,"postgres","mysecretpassword");

        // Create two threads, one to issue notifications and
        // the other to receive them.

        Listener listener = new Listener(lConn);
        Notifier notifier = new Notifier(nConn);
        listener.start();
        notifier.start();
    }

    public boolean ok() {
        return true;
    }


}
