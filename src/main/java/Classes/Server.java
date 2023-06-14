package Classes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase del server
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    /**
     * Clase constructora del server
     * @param serverSocket
     */
    public Server(ServerSocket serverSocket){
        try{
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch(IOException e){
            System.out.println("Error creando servidor");
            e.printStackTrace();
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    /**
     * Metodo que envia un mensaje a la aplicacion del juego
     * @param message
     */
    public void sendMessageToController(String message){
        try{
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error enviando mensaje al controller");
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    /**
     * Este metodo envia el tipo y la posicion del avion que se desea crear
     * @param tipo
     * @param pos
     */
    public void createPlane(String tipo, String pos){
        try{
            bufferedWriter.write(tipo);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write(pos);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error enviando mensaje al controller");
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    /**
     * Mettodo que cierra el socket entre el server y el cliente
     * @param socket
     * @param bufferedReader
     * @param bufferedWriter
     */
    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
