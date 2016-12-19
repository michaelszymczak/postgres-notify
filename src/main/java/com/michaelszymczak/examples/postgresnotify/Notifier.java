package com.michaelszymczak.examples.postgresnotify;

import java.sql.*;

class Notifier extends Thread
{
    private Connection conn;

    public Notifier(Connection conn)
    {
        this.conn = conn;
    }

    public void run()
    {
        while (true)
        {
            try
            {
                Statement stmt = conn.createStatement();
                stmt.execute("NOTIFY mymessage");
                stmt.close();
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}

