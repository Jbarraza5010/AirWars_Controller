package com.example.airwars_controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Server;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    private Server server;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

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