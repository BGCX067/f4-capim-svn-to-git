package capimClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MAGDA
 */
public class Client {

    private Message mesg;
    private static DatagramSocket client;
    private static DatagramPacket sendPacket;
    private static DatagramPacket receivePacket;
    private static BufferedReader in;
    private static InetAddress IPAddress;
    private Thread receber;
    private Thread enviar;
    private byte[] sendData = new byte[1024];
    private byte[] receiveData = new byte[1024];
    private int TYPE_MESSAGE;
    private String DESTINATION;
    private static String MESSAGE;
    private HashMap users;

    public Client(String message) throws SocketException {
        MESSAGE = message;
        client = new DatagramSocket();


        enviar = new Thread() {

            public void run() {
                while (true) {
                    try {
                        sendData = new byte[1024];
//                        System.out.println("DIGITE:");
//                        String message = new Scanner(System.in).nextLine();
//                        System.out.println(getMessage());

                        
                        sendData = getMessage().getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("127.0.0.1"), 5000);
                        client.send(sendPacket);

                        StringTokenizer token = new StringTokenizer(getMessage());
                        String str = token.nextToken(":");
                        if( str.equals("0") || str.equals("1")){
                            break;
                        }

                    } catch (IOException ex) {
                    }
                }//fim do while
            }
        };

        receber = new Thread() {

            public void run() {
                DatagramPacket receivePacket;

                while (true) {
                    try {
                        receiveData = new byte[1024];

                        receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        client.receive(receivePacket);
                        String message2 = new String(receivePacket.getData());
                        StringTokenizer token;
                        token = new StringTokenizer(message2);
                        String str = token.nextToken(":");
                        if(str.equals("2")){
                            str = token.nextToken(":");
                            addList(str);
                        }
                        System.out.println("Mensagem do servidor: " + message2);

                    } catch (IOException ex) {
                    }
                }//fim do while
            }
        };

        enviar.start();
        receber.start();
    }

    public Object message(String tipo, String dest, String mesg){

        return 0;
    }

    public String getMessage(){
        return MESSAGE;
    }
    public void setMessage(String message) {
        MESSAGE = message;
    }

    public void addList(String user){
        users.put(user,"online");
    }

    public HashMap getList(){
        return users;
    }
    public static void main(String args[]) throws SocketException {
        new Client(MESSAGE);
    }


}
