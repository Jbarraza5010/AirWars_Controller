package Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.*;
import javafx.fxml.Initializable;


public class GrafoPrueba extends Grafo{

    Grafo grafo;

    @FXML
    private Button BtnInsertarArco;
    @FXML
    private Button BtnInsertarNodo;

    @FXML
    private TextField Entrada;

    @FXML
    private TextArea Salida;

    /**
     * Función de botón para crear un nodo para el grafo
     * @param event
     */
    @FXML
    private void BtnInsertarNodo(ActionEvent event){
        String dato = Entrada.getText();
        grafo.nuevoNodo(dato);
        Salida.setText(grafo.toString());
        Entrada.setText("");
    }
    /**
     * Función de botón para crear un arco para el grafo
     */
    @FXML
    private void BtnInsertarArco(ActionEvent event){
        String origen = "";
        String destino = "";
        origen = JOptionPane.showInputDialog("Origen:");
        destino = JOptionPane.showInputDialog("Destino :");
        if(grafo.existeVertice(origen) && grafo.existeVertice(destino)){
            grafo.NuevaArista(origen, destino);
        }
        Salida.setText(grafo.toString());
    }
}

