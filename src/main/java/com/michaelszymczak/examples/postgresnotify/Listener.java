package com.michaelszymczak.examples.postgresnotify;

import java.sql.*;

class Listener extends Thread
{
    private Connection conn;
    private org.postgresql.PGConnection pgconn;

    Listener(Connection conn) throws SQLException
    {
        this.conn = conn;
        this.pgconn = conn.unwrap(org.postgresql.PGConnection.class);
        Statement stmt = conn.createStatement();
        stmt.execute("LISTEN mymessage");
        stmt.close();
    }

    public void run()
    {
        while (true)
        {
            try
            {
                // issue a dummy query to contact the backend
                // and receive any pending notifications.

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1");
                rs.close();
                stmt.close();

                org.postgresql.PGNotification notifications[] = pgconn.getNotifications();

                if (notifications != null)
                {
                    for (int i=0; i<notifications.length; i++)
                        System.out.println("Got notification: " + notifications[i].getName());
                }

                // wait a while before checking again for new
                // notifications

                Thread.sleep(500);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}