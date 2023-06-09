package com.example.airwars_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Server;
import Classes.Grafo;
import Classes.LinkedList;

public class HelloController implements Initializable {

    private Server server;

    private String[] aeropuertos = {"norte america", "sur america", "europa", "asia", "oceania", "africa"};

    private String[] portaviones = {"pacifico1", "pacifico2", "atlantico", "indico"};

    @FXML
    private Button eliminar;

    @FXML
    private ChoiceBox<?> rutas;

    @FXML
    private Text textAviones;

    @FXML
    private Text textDestruidos;

    @FXML
    private Text textFuncionando;

    @FXML
    private Text textRuta;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            server = new Server(new ServerSocket(1234));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error creando server");
        }
        LinkedList mapa = new LinkedList();

        for(String i : portaviones){
            int prob = ((int) (Math.random() * (3 - 1) + 1));
            if (prob == 1){
                mapa.insertFirst(i);
            }
        }

        for(String i : aeropuertos){
            int prob = ((int) (Math.random() * (3 - 1) + 1));
            if (prob == 1){
                mapa.insertFirst(i);
            }
        }
        mapa.displayList();
    }
}