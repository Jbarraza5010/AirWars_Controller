package Classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

    public class GrafoPruebaMain extends Application {
        /**
         * Función que abre la interfaz gráfica
         * @param stage
         * @throws IOException
         */
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(GrafoPruebaMain.class.getResource("GrafoPrueba.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        }

        /**
         * Método main() de la aplicación
         * @param args
         */
        public static void main(String[] args) {
            launch();
        }
    }