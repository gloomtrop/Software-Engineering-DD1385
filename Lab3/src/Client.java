import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    Socket socket;
    BufferedReader in;
    PrintWriter ut;
    Client() throws IOException {
        socket = new Socket("localhost", 4713);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ut = new PrintWriter(socket.getOutputStream());
    }
    public BufferedReader getIn(){
        return in;
    }
    public PrintWriter getUt(){
        return ut;
    }
    public static void main(String[] args) throws IOException {
        new Client();

    }
}

