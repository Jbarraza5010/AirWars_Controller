package com.example.airwars_controller;

import Classes.Avion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Server;
import Classes.Grafo;
import Classes.LinkedList;

/**
 * Clase controller del controlador aereo
 */
public class HelloController implements Initializable {

    private Server server;

    private String[] aeropuertos = {"norte america", "sur america", "europa", "asia", "oceania", "africa"};

    private String[] portaviones = {"pacifico1", "pacifico2", "atlantico", "indico"};

    private String[] todos = {"norte america", "sur america", "europa", "asia", "oceania", "africa", "pacifico1", "pacifico2", "atlantico", "indico"};

    private Grafo grafo = new Grafo();

    private int funcionando = 0;

    private int derribados = 0;

    private Avion SkyShredder = new Avion(3, 1, 1, 100);
    private Avion GroundZero = new Avion(1, 3, 1, 100);
    private Avion FlyingFortress = new Avion(1, 1, 3, 100);

    private LinkedList aviones = new LinkedList();

    private String[] tipos = {"SkyShredder", "GroundZero", "FlyingFortress"};

    @FXML
    private Text avionesD;

    @FXML
    private Text avionesF;

    @FXML
    private Button crear;

    @FXML
    private Button eliminar;

    @FXML
    private ChoiceBox<String> posicion;

    @FXML
    private ChoiceBox<?> rutas;

    @FXML
    private Text textAviones;

    @FXML
    private Text textBuscar;

    @FXML
    private Text textDestruidos;

    @FXML
    private Text textFuncionando;

    @FXML
    private Text textRuta;

    @FXML
    private ChoiceBox<String> tipo;

    /**
     * Este metodo crea un avion segun el tipo
     * @param event
     */
    @FXML
    void clickCrear(ActionEvent event) {
        if (tipo.getValue() == "SkyShredder"){
            server.createPlane("SkyShredder", posicion.getValue());
            funcionando++;
            avionesF.setText(String.valueOf(funcionando));
            avionesD.setText(String.valueOf(derribados));
        } else if (tipo.getValue() == "FlyingFortress") {
            server.createPlane("FlyingFortress", posicion.getValue());
            funcionando++;
            avionesF.setText(String.valueOf(funcionando));
            avionesD.setText(String.valueOf(derribados));
        } else if (tipo.getValue() == "GroundZero") {
            server.createPlane("GroundZero", posicion.getValue());
            funcionando++;
            avionesF.setText(String.valueOf(funcionando));
            avionesD.setText(String.valueOf(derribados));
        }
    }

    /**
     * Metodo que incia el server junto con sus metodos
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            server = new Server(new ServerSocket(1234));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error creando server");
        }

        tipo.getItems().addAll(tipos);

        for(String i : portaviones){
            int prob = ((int) (Math.random() * (3 - 1) + 1));
            int e = ((int) (Math.random() * (portaviones.length - 1) + 1));
            String dest = portaviones[e];
            int peso = ((int) (Math.random() * (5 - 1) + 1));
            if (prob == 1){
                server.sendMessageToController(i);
                posicion.getItems().add(i);
                //grafo.nuevoNodo(i);
                //grafo.nuevoNodo(dest);
                //grafo.NuevaArista(i, dest, peso);
            }
        }

        for(String i : aeropuertos){
            int prob = ((int) (Math.random() * (3 - 1) + 1));
            int e = ((int) (Math.random() * (aeropuertos.length - 1) + 1));
            String dest = aeropuertos[e];
            int peso = ((int) (Math.random() * (5 - 1) + 1));
            if (prob == 1){
                server.sendMessageToController(i);
                posicion.getItems().add(i);
                //grafo.nuevoNodo(i);
                //grafo.nuevoNodo(dest);
                //grafo.NuevaArista(i, dest, peso);
            }
        }
    }
}