package scoket_testing;
// A Java program for a serverSide
import java.io.*;
import java.net.*;
import java.lang.*;

public class serverSide {

    // initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // constructor with port
    public serverSide(int port) throws IOException {

        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);

            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();

            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(
                            socket.getInputStream()));

             java.lang.String line = "";

            // reads message from client until "End" is sent
            while (!line.equals("End")) {

                line = in.readUTF();

                System.out.println(line);
            }

            System.out.println("Closing connection");

            // close connection
            socket.close();

            in.close();
        }

        catch (IOException i) {

            System.out.println(i);
        }
    }

    public static void main(String[] args) throws Throwable {

        serverSide server = new serverSide(5000);
    }
}

