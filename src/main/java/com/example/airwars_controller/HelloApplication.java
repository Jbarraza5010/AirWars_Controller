package com.example.airwars_controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Esta clase inicia la aplicacion del controlador aereo
 */
public class HelloApplication extends Application {
    /**
     * Funcion que abre la interfaz grafica
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Controller Aéreo");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo main de la aplicacion
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}