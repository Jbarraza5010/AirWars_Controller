package com.example.airwars_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Server;
import javafx.scene.text.Text;

public class HelloController implements Initializable {

    private Server server;

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

    }
}