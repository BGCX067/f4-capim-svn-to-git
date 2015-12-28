/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capimClient;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class Server {

    private DatagramSocket datagramSocket;
    private byte[] sendData;
    private byte[] receiveData;
    private Thread _monitorThread;
    private HashMap _usuariosLogados;
    private static final Integer SIZE_BYTE = 1024;
    private String arquivo = "/home/helinho/svn/CapimF4/Arquivos/records.txt";

//    private String message;
//    private String type_message;
//    private String dest;

    public Server() throws SocketException {
        datagramSocket = new DatagramSocket(5000);
        sendData = new byte[SIZE_BYTE];
        receiveData = new byte[SIZE_BYTE];

        _usuariosLogados = new HashMap();

        _monitorThread = new Thread() {

            public void run() {
                while (true) {
                    try {
                        sendData = new byte[SIZE_BYTE];
                        receiveData = new byte[SIZE_BYTE];
                        //receber pacote
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                        datagramSocket.receive(receivePacket);

//                        sendData = receivePacket.getData();
                        StringTokenizer token;
                        String message = new String(receivePacket.getData());
////
                        token = new StringTokenizer(message);
                        String type_message = token.nextToken(":");

////                        //tratamento
////
                        if (type_message.equals("0")) {
                            String login = token.nextToken(":");
                            String pass = token.nextToken();
                            gravaArquivo(arquivo,login,pass);
                        }
////                            //String m = protocolo.nextToken();
////                            //zelito;timbo;...;olaaa
////                            StringTokenizer strt = new StringTokenizer((String)_usuariosLogados.get("timbo"));
////                            InetAddress ip = InetAddress.getByName(strt.nextToken(";").substring(1));
////                            int port = Integer.parseInt(strt.nextToken());
////
////                            //sendData = m.getBytes();
////
////                            DatagramPacket sendPacket = new DatagramPacket(sendData,
////                                sendData.length, ip, port);
////                        }
////
////                        String ip_port = receivePacket.getAddress() + ":" + receivePacket.getPort();
////
////
////
////                        String mensagem = new String(receivePacket.getData());
////                        //login
////                        _usuariosLogados.put(mensagem, ip_port);
//
//                        String mensagem = new String(receivePacket.getData());
//
//
//                        System.out.println("recebeu: " + mensagem);
//                        //reenviar pacote recebido
//                        sendData = mensagem.toUpperCase().getBytes();
//
//                        DatagramPacket sendPacket = new DatagramPacket(sendData,
//                                sendData.length, InetAddress.getByName("192.168.1.102"), 1234);
//
//                        datagramSocket.send(sendPacket);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }



//                try {
//                    while (true) {
//                        System.out.println("waiting a packet...");
//                        sendData = new byte[SIZE_BYTE];
//                        receiveData = new byte[SIZE_BYTE];
//                        //receber pacote
//                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//                        datagramSocket.receive(receivePacket);
//                        String mensagem = new String(receivePacket.getData());
//                        System.out.println("recebeu: " + mensagem);
//                        //reenviar pacote recebido
//                        sendData = mensagem.toUpperCase().getBytes();
//                        DatagramPacket sendPacket = new DatagramPacket(sendData,
//                                sendData.length, InetAddress.getByName("201.8.253.168"), 5000);
////                        DatagramPacket sendPacket2 = new DatagramPacket(sendData,
////                                sendData.length, InetAddress.getByName("192.168.1.102"), 100);
////                        datagramSocket.send(sendPacket2);
//                        datagramSocket.send(sendPacket);
//                    }
//                } catch (IOException ex) {
//                }
            }
        };

        _monitorThread.start();
    }

     public void gravaArquivo(String arquivo, String login, String pass) throws Exception {
        FileWriter out = new FileWriter(arquivo, true);
        out.write(login + ":" + pass + "\n");
        out.close();
    }
        public boolean findContact(String contact) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader(new File(arquivo)));
        String str;
        StringTokenizer strt;
        while ((str = in.readLine()) != null) {
            strt = new StringTokenizer(str);
            str = strt.nextToken();
            if (str.equals(contact)){
                return true;
            }
//            System.out.println(str);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        Server server = new Server();

    }
}
