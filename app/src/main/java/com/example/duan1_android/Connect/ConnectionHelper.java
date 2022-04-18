package com.example.duan1_android.Connect;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection connection;
    String user, pass, database, ip, port;
    @SuppressLint("NewApi")
    public Connection connectionclass() {
        String ip = "192.168.1.37", port = "1433", username = "bang1", password = "bangdz", databasename = "DuAn";
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connect = "jdbc:jtds:sqlserver://" + ip + "/" + databasename;
            connection = DriverManager.getConnection(connect, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}