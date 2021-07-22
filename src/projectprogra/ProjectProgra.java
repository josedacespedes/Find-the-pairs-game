package projectprogra;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author José Alvarado y Diego Coto Aplicación de cartas de memoría
 */
public class ProjectProgra extends Application {

    @Override
    public void start(Stage stage) {

        //Instancia de clase donde estan las escenas
        ScenesMain sM = new ScenesMain();

        //Creacion de controlador de escena
        Scene sceneUnificate = new Scene(sM.sceneControl(), 770, 690);

        //Poner las escenas en el escenario
        stage.setScene(sceneUnificate);

        //Tiulo de escenario
        stage.setTitle("JD Memory Cards");

        //Predetermina el tamaño sin modificarlo
        stage.setResizable(false);

        //Para que no pueda cerrar la ventana con la X
        stage.setOnCloseRequest((WindowEvent event) -> {
            event.consume();           //Consumar el evento
        });

        //icono en el top
        stage.getIcons().add(new Image("images/Ini.png"));
        stage.show();

    }//End start(Stage stage)

    public static void main() {

        //Llamo al escenario 
        launch();

    }//End main()

}//End class main

