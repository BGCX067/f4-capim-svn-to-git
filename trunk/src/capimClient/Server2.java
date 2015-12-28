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
public class Server2 {

    private DatagramSocket datagramSocket;
    private byte[] sendData;
    private byte[] receiveData;
    private Thread _monitorThread;
    private HashMap _usuariosLogados;
    private static final Integer SIZE_BYTE = 1024;
    private String records = "/home/helinho/svn/CapimF4/Arquivos/records.txt";
    private String friends = "/home/helinho/svn/CapimF4/Arquivos/friends.txt";


    public Server2() throws SocketException, Exception {
        datagramSocket = new DatagramSocket(5000);
        sendData = new byte[SIZE_BYTE];
        receiveData = new byte[SIZE_BYTE];

        _usuariosLogados = new HashMap();

                try {
                    while (true) {
                        System.out.println("waiting a packet...");
                        sendData = new byte[SIZE_BYTE];
                        receiveData = new byte[SIZE_BYTE];
                        //receber pacote
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        datagramSocket.receive(receivePacket);

                        StringTokenizer token;
                        String message = new String(receivePacket.getData());
////
                        token = new StringTokenizer(message);
                        String type_message = token.nextToken(":");

////                        //tratamento
////
                        if (type_message.equals("0")) {
                            String login = token.nextToken(":");
                            String pass = token.nextToken(".");
                            
                            gravaArquivo(records,login,pass);
                        }

                        if (type_message.equals("1")) {
                            String login = token.nextToken(":");
                            
                            _usuariosLogados.put(login, receivePacket.getAddress()+":"
                                            +receivePacket.getPort()+":"+"online");

                            System.out.println(_usuariosLogados.get(login).toString());
                            BufferedReader in = new BufferedReader(new FileReader(new File(friends)));
                            String str;

                            StringTokenizer strt;
                            while ((in.readLine()) != null) {
                                strt = new StringTokenizer(in.readLine());
                                str = strt.nextToken(":");
                                System.out.println(str);
                                if (str.equals(login)) {
                                    String lista;

                                    while( !(str = strt.nextToken(":")).equals("\n")){
                                        if (_usuariosLogados.containsKey(str)) {
                                            lista = "2:" + str;
                                            sendData = lista.getBytes();
                                            String user = _usuariosLogados.get(str).toString();
                                            
                                            DatagramPacket sendPacket = new DatagramPacket(sendData,
                                                    sendData.length, InetAddress.getByName(user),getPort(user));
                                            datagramSocket.send(sendPacket);
                                        }
                                        //enviar msg para clientes amigos de login.
                                    }
                                    str = in.readLine();

                                }
                            }
                            System.out.println(_usuariosLogados.containsKey(login));
                        }

//                        String mensagem = new String(receivePacket.getData());
                        System.out.println("recebeu: " + message);
                        //reenviar pacote recebido
                        sendData = "chegou".toUpperCase().getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(sendData,
                                sendData.length, InetAddress.getByName("127.0.0.1"), 101);
//                        DatagramPacket sendPacket2 = new DatagramPacket(sendData,
//                                sendData.length, InetAddress.getByName("192.168.1.102"), 100);
//                        datagramSocket.send(sendPacket2);
                        datagramSocket.send(sendPacket);
                    }
                } catch (IOException ex) {
                }
    }

     public void gravaArquivo(String arquivo, String login, String pass) throws Exception {
        FileWriter out = new FileWriter(arquivo, true);
        out.write(login + pass + "\n");
        out.close();
    }
        public boolean findContact(String contact, String arquivo) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader(new File(arquivo)));
        String str;
        StringTokenizer strt;
        while ((str = in.readLine()) != null) {
            strt = new StringTokenizer(str);
            str = strt.nextToken(":");
            if (str.equals(contact)){
                return true;
            }
//            System.out.println(str);
        }
        return false;
    }
        public String getIP(String user){
            String str;
            StringTokenizer strt = new StringTokenizer(user);
            str = strt.nextToken(":").substring(1);
            return str;
        }
        public int getPort(String user){
            String str;
            StringTokenizer strt = new StringTokenizer(user);
            str = strt.nextToken(":");
            str = strt.nextToken(":").substring(1);
            return Integer.parseInt(str);
        }

    public static void main(String[] args) throws Exception {

        Server2 server = new Server2();

    }
}
