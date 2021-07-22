package projectprogra;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ScenesMain {
    //Instancia de clase logica

    LogicMx lM = new LogicMx();
    timeKeper c = new timeKeper();

    //Instancia dependiente
    timeKeper e = c;

    //Creacion de los contenedores
    AnchorPane aP_Name = new AnchorPane();
    AnchorPane aP_gM = new AnchorPane();
    AnchorPane aP_Unificate = new AnchorPane();

    //Declarar variabes
    int touchCont = 0;
    int fSaveA;
    int cSaveA;
    int fSaveB;
    int cSaveB;

    int gate = 0;
    int fGatA;
    int cGatA;
    int fGatB;
    int cGatB;
    int score;

    public AnchorPane sceneControl() {

        setUser().setPrefSize(780, 700);

        setgameMode(lM.cardSame(lM.parRandom())).setPrefSize(780, 700);

        aP_Unificate.getChildren().addAll(setUser(), setgameMode(lM.cardSame(lM.parRandom())));

        aP_gM.setVisible(false);

        return aP_Unificate;
    }

    //Metodo de primer escena donde ira la solicitud de usuario entre otras cosas
    public AnchorPane setUser() {

        //Genera la imagen o gif de fondo
        BackgroundImage myBI = new BackgroundImage(new Image("images/mario1.gif", 790, 700, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        aP_Name.setBackground(new Background(myBI));

        //Solicitud de nombre, ingreso de nombre y boton de confirmar
        Label lB_Title = new Label("\n   Juego de Memoria de Cartas ");
        lB_Title.setFont(new Font("Arial", 40));
        lB_Title.setTextFill(Color.GREENYELLOW);

        Label lB_Name = new Label("Ingrese el nombre del jugador");
        lB_Name.setFont(new Font("Arial", 25));
        lB_Name.setTextFill(Color.GREENYELLOW);

        TextField tF_Name = new TextField();
        tF_Name.setPrefSize(90, 40);
        tF_Name.setFont(new Font("Arial", 16));

        //Boton de insertar jugador
        Button bT_InsertName = new Button("Confirmar Jugador");
        bT_InsertName.setMinSize(30, 30);
        bT_InsertName.setFont(new Font("Arial", 15));
        bT_InsertName.setStyle("-fx-background-color:#00CCFF");

        //Label que dara bienvenida 
        Label lB_welcome = new Label();
        lB_welcome.setFont(new Font("Arial", 30));

        //Boton que lleva juego
        ImageView iv2 = new ImageView(new Image("images/comenzar.gif"));
        iv2.setFitHeight(80);
        iv2.setFitWidth(150);
        Button bT_startScene = new Button("", iv2);
        bT_startScene.setMinSize(105, 55);
        bT_startScene.setMaxSize(105, 55);

        //Boton de salida
        ImageView iv1 = new ImageView(new Image("images/exit2.gif"));
        iv1.setFitHeight(45);
        iv1.setFitWidth(48);
        Button bT_exit = new Button("", iv1);
        bT_exit.setMinSize(48, 45);
        bT_exit.setMaxSize(48, 45);

        //Boton de creditos
        Button bTN_credits = new Button("Créditos");
        bTN_credits.setFont(new Font("Arial", 16));
        bTN_credits.setPrefSize(90, 40);
        bTN_credits.setStyle("-fx-background-color:#CCCC00");

        //Label de creditos
        Label lB_credits = new Label("Proyecto del curso IF2000:\n----------------------------------------------------------------------------------------------------------------"
                + "\nJosé David Alvarado Céspedes - B80304"
                + "\nJuan Diego Coto Ramiréz - B82444"
                + "\nPara empezar, el juego tiene cartas boca abajo completamente aleatorias, "
                + "\ndonde el jugador debera clickear dos cartas, en caso de que las cartas sean iguales,"
                + "\nse tornarán invisibles y suma un puntaje. En caso contrario se voltearán."
                + "\nEl objetivo del juego es obtener todos los pares de cartas en el menor tiempo.");
        lB_credits.setFont(new Font("Arial", 15));
        lB_credits.setStyle("-fx-background-color:#CCCC00");
        lB_credits.setVisible(false);

        //VBox que contendra el label de nombre y su textfield
        VBox vB_Center = new VBox(45, lB_Name, tF_Name);

        //Acomodo el vertical box
        AnchorPane.setTopAnchor(vB_Center, 150.0);
        AnchorPane.setLeftAnchor(vB_Center, 210.0);

        //Acomodo el boton de insertarjugador
        AnchorPane.setTopAnchor(bT_InsertName, 310.0);
        AnchorPane.setLeftAnchor(bT_InsertName, 310.0);

        //Acomodo el label de bienvenida
        AnchorPane.setBottomAnchor(lB_welcome, 270.0);
        AnchorPane.setLeftAnchor(lB_welcome, 65.0);

        //Acomodo el boton comezar
        AnchorPane.setBottomAnchor(bT_startScene, 180.0);
        AnchorPane.setLeftAnchor(bT_startScene, 330.0);

        //Acomodo el Titulo
        AnchorPane.setTopAnchor(lB_Title, 10d);
        AnchorPane.setLeftAnchor(lB_Title, 80d);

        //Boton de salida
        AnchorPane.setBottomAnchor(bT_exit, 5d);
        AnchorPane.setRightAnchor(bT_exit, 5d);

        //Boton de creditos
        AnchorPane.setBottomAnchor(bTN_credits, 5d);
        AnchorPane.setLeftAnchor(bTN_credits, 5d);

        //Label de creditos
        AnchorPane.setBottomAnchor(lB_credits, 8d);
        AnchorPane.setLeftAnchor(lB_credits, 115d);

        //Desabilito boton de comenzar hasta que se ingrese un nombre
        bT_startScene.setDisable(true);

        bT_InsertName.setOnAction((event) -> {

            String text = tF_Name.getText();
            //Elimino espacios
            text = text.replaceAll(" ", "");
            //Verifico si se dejo en blanco el espacio
            if (text.length() == 0) {
                //Si deja en blanco    
                lB_welcome.setText("Error, debe ingresar un nombre de jugador");
                lB_welcome.setTextFill(Color.AQUA);

            } else {
                tF_Name.setEditable(false);
                lB_welcome.setText("Bienvenid@ " + tF_Name.getText());
                lB_welcome.setTextFill(Color.LAWNGREEN);
                bT_startScene.setDisable(false);

            }//End if

        });//End accion de boton de insertar

        //Accion de boton que me lleva a otra escena
        bT_startScene.setOnAction((event) -> {
            aP_gM.setVisible(true);
            lB_welcome.setText("");
            lB_credits.setText("");
            bT_startScene.setDisable(true);
        });

        //cierra la app
        bT_exit.setOnMouseExited((event) -> {

            Platform.exit();
            JOptionPane.showMessageDialog(null, "GRACIAS POR JUGAR", "JD Memory card", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(getClass().getResource("/images/thanks.png")));
        });

        //Accion de boton de creditos
        bTN_credits.setOnAction((event) -> {
            lB_credits.setVisible(true);
        });

        //Agrego nodos a AnchorPane
        aP_Name.getChildren().addAll(vB_Center, bT_InsertName, lB_Title, bT_startScene, bT_exit, lB_welcome, bTN_credits, lB_credits);

        return aP_Name;
    }//End setUser() 

    public AnchorPane setgameMode(Card[][] a) {

        //Gridpane para elementos del tiempo y tilePane de matriz
        GridPane gP_timeKeper = new GridPane();
        gP_timeKeper.setVgap(10);
        TilePane tP_Mx = new TilePane();

        //Se agrega las cartas al talepane y se ponen invisibles al click
        for (int f = 0; f < a.length; f++) {
            for (int c = 0; c < a[0].length; c++) {

                tP_Mx.getChildren().addAll(a[f][c].getbTN());
                a[f][c].getbTN().setMouseTransparent(true);

            }//End de columnas 

        }//End de Filas

        //Fondo de AnchorPane
        BackgroundImage myBI = new BackgroundImage(new Image("images/recuerdo.jpg", 740, 750, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        aP_gM.setBackground(new Background(myBI));

        //Boton de marcador
        Button bTN_points = new Button("Marcador");
        bTN_points.setPrefSize(90, 75);
        bTN_points.setFont(new Font("Arial", 16));
        bTN_points.setStyle("-fx-background-color:#CCCC00");

        //Boton de juego nuevo
        Button bTN_reGame = new Button("Juego Nuevo");
        bTN_reGame.setPrefSize(130, 35);
        bTN_reGame.setFont(new Font("Arial", 16));
        bTN_reGame.setStyle("-fx-background-color:#99CCFF");

        //Boton de regresar
        ImageView iv2 = new ImageView(new Image("images/devolver.png"));
        iv2.setFitHeight(27);
        iv2.setFitWidth(29);
        Button bT_back = new Button("", iv2);

        //Boton de salida
        ImageView iv1 = new ImageView(new Image("images/exit2.gif"));
        iv1.setFitHeight(37);
        iv1.setFitWidth(39);
        Button bT_exit = new Button("", iv1);
        bT_exit.setMinSize(39, 37);
        bT_exit.setMaxSize(39, 37);

        //Boton con mensaje de felicitaciones
        ImageView iv_congrat = new ImageView(new Image("images/congrat.gif"));
        iv_congrat.setFitHeight(50);
        iv_congrat.setFitWidth(250);
        Button bTN_congrat = new Button("", iv_congrat);
        bTN_congrat.setMinSize(250, 50);
        bTN_congrat.setMaxSize(250, 50);
        bTN_congrat.setVisible(false);

        //Boton de iniciar juego
        Button bTN_start = new Button("Iniciar");
        bTN_start.setPrefSize(130, 35);
        bTN_start.setFont(new Font("Arial", 16));
        bTN_start.setStyle("-fx-background-color:#CC9900");

        AnchorPane.setBottomAnchor(bT_back, 5d);
        AnchorPane.setLeftAnchor(bT_back, 5d);

        AnchorPane.setBottomAnchor(bT_exit, 5d);
        AnchorPane.setRightAnchor(bT_exit, 5d);

        AnchorPane.setTopAnchor(tP_Mx, 3d);
        AnchorPane.setLeftAnchor(tP_Mx, 3d);

        AnchorPane.setTopAnchor(bTN_points, 125d);
        AnchorPane.setRightAnchor(bTN_points, 37d);

        AnchorPane.setBottomAnchor(bTN_congrat, 3d);
        AnchorPane.setRightAnchor(bTN_congrat, 270d);

        AnchorPane.setTopAnchor(gP_timeKeper, 3d);
        AnchorPane.setRightAnchor(gP_timeKeper, 18d);

        //for para las aciones de las cartas
        for (int f = 0; f < a.length; f++) {
            for (int c = 0; c < a[0].length; c++) {

                //Se guardan temporalmente las variables de f y c
                int fila = f;
                int columna = c;

                //Evento para cada click de las cartas
                a[f][c].getbTN().setOnAction((event) -> {

                    //Solo se habilita una vez hayan 2 cartas diferentes
                    if (gate == 1) {

                        a[fGatA][cGatA].getbTN().setGraphic(a[fGatA][cGatA].getiM_Default());
                        a[fGatB][cGatB].getbTN().setGraphic(a[fGatB][cGatB].getiM_Default());

                    }//End if de gate

                    //Se muestra la carta a la que se de click
                    a[fila][columna].getbTN().setGraphic(a[fila][columna].getiMV_differ());

                    //If que controla si se seleccionaron 1 o 2 cartas
                    if (touchCont == 1) {
                        //Se guardan las posiciones de la carta 2 seleccionada
                        fSaveB = fila;
                        cSaveB = columna;

                        //Si se da click a una misma carta la escondera
                        if (fSaveA == fSaveB && cSaveA == cSaveB) {
                            a[fSaveA][cSaveA].getbTN().setGraphic(a[fSaveA][cSaveB].getiM_Default());

                        } else {
                            //Sino comparara las cartas y si son iguales las pone invisibles en caso contrario guarda 
                            //posiciones de las cartas para pasarlas en el gate de arriba

                            if ((a[fSaveA][cSaveA].getID()) == (a[fSaveB][cSaveB].getID())) {
                                //Para puntaje
                                score += 2;
                                String num;
                                num = String.valueOf(score);
                                bTN_points.setText("Marcador\n    " + num + "/20");

                                if (score == 20) {
                                    bTN_congrat.setVisible(true);
                                    e.pararCronometro();
                                }

                                //Si son iguales las pone invisibles y no se pueden tocar
                                a[fSaveA][cSaveA].getbTN().setDisable(true);
                                a[fSaveB][cSaveB].getbTN().setDisable(true);

                            } else {

                                fGatA = fSaveA;
                                cGatA = cSaveA;
                                fGatB = fSaveB;
                                cGatB = cSaveB;
                                gate = 1;

                            }//End if else de comparacion

                        }//End if else 

                        //Reinicia el contador de toques a 0
                        touchCont = 0;

                    } else {

                        if (touchCont == 0) {
                            //Guarda las posiciones de la carta 1
                            fSaveA = fila;
                            cSaveA = columna;
                            touchCont++;
                            gate = 0;
                        }

                    }//End else

                });//End de acciones de cartas

            }//End de c

        }//End de f

        //Accion de boton iniciar
        bTN_start.setOnAction((ActionEvent event) -> {

            //Vuelve a poner todas las cartas visibles 
            for (int f = 0; f < a.length; f++) {
                for (int c = 0; c < a[0].length; c++) {

                    a[f][c].getbTN().setMouseTransparent(false);
                }//End filas
            }//End columnas

            //Si le da boton de iniciar que se desabilite
            bTN_start.setDisable(true);

            //Inicia cronometro
            c.iniciarCronometro();

        });//End de boton de iniciar

        //Accion de boton de juego nuevo
        bTN_reGame.setOnAction((ActionEvent event) -> {

            //Si le da nuevo juego habilita el iniciar
            bTN_start.setDisable(false);

            //Para cronometro
            c.pararCronometro();
            c.lB_Tiempo.setText(c.tiem);

            //Reinicia variables
            score = 0;
            bTN_points.setText("Marcador");

            //Se quita boton de felcitaciones
            bTN_congrat.setVisible(false);

            //Pone cartas denuevo hacia abajo
            for (int f = 0; f < a.length; f++) {
                for (int c = 0; c < a[0].length; c++) {

                    a[f][c].getbTN().setVisible(true);
                    a[f][c].getbTN().setGraphic(a[f][c].getiM_Default());

                }//End filas

            }//End columnas

            //Vuelve a cargar las escenas al anchirpane para que se genere un nuevo mazo de cartas
            AnchorPane aP_update = new AnchorPane();
            aP_update.getChildren().addAll(setUser(), setgameMode(lM.cardSame(lM.parRandom())));
            aP_Unificate.getChildren().addAll(aP_update);

        });//End de boton de juego nuevo

        //Accion de boton de regreso
        bT_back.setOnAction((event) -> {

            aP_gM.setVisible(false);
            aP_Name.setVisible(true);

            //Si le da nuevo juego habilita el iniciar
            bTN_start.setDisable(false);

            //Para cronometro
            c.pararCronometro();
            c.lB_Tiempo.setText(c.tiem);

            //Reinicia variables
            score = 0;
            bTN_points.setText("Marcador");

            //Se quita boton de felcitaciones
            bTN_congrat.setVisible(false);

            //Pone cartas denuevo hacia abajo
            for (int f = 0; f < a.length; f++) {
                for (int c = 0; c < a[0].length; c++) {

                    a[f][c].getbTN().setVisible(true);
                    a[f][c].getbTN().setGraphic(a[f][c].getiM_Default());

                }//End filas

            }//End columnas

            //Vuelve a cargar las escenas al anchirpane para que se genere un nuevo mazo de cartas
            AnchorPane aP_update = new AnchorPane();
            aP_update.getChildren().addAll(setUser(), setgameMode(lM.cardSame(lM.parRandom())));
            aP_Unificate.getChildren().addAll(aP_update);

        });//End de accion de boton de regresar

        //cierra la app
        bT_exit.setOnMouseExited((event) -> {
            Platform.exit();
            JOptionPane.showMessageDialog(null, "GRACIAS POR JUGAR", "JD Memory card", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(getClass().getResource("/images/thanks.png")));
        });

        //Se agregan nodos del gridPane cronometro
        gP_timeKeper.add(bTN_start, 1, 1);
        gP_timeKeper.add(bTN_reGame, 1, 3);
        gP_timeKeper.add(c.lB_Tiempo, 1, 15);

        //Agrego nodos a AnchorPane
        aP_gM.getChildren().addAll(bT_back, bT_exit, tP_Mx, bTN_points, bTN_congrat, gP_timeKeper);

        return aP_gM;
    }//End setgameMode(Card[][] a)

}//End ScenesMain
