package projectprogra;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class timeKeper implements Runnable {

    boolean cronometroActivo;
    Thread hilo;
    Label lB_Tiempo = new Label("00:00:000");
    String tiem;

    public void run() {
        Integer minutos = 0, segundos = 0, milesimas = 0;

        //min es minutos, seg es segundos y mil es milesimas de segundo
        String min = "", seg = "", mil = "";
        try {
            //Mientras cronometroActivo sea verdadero entonces seguira
            //aumentando el tiempo
            while (cronometroActivo) {
                Thread.sleep(4);
                //Incrementamos 4 milesimas de segundo
                milesimas += 4;

                //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                //y las milesimas de segundo de nuevo a 0
                if (milesimas == 1000) {
                    milesimas = 0;
                    segundos += 1;
                    //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                    //y los segundos vuelven a 0
                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                }

                //Esto solamente es estetica para que siempre este en formato
                //00:00:000
                if (minutos < 10) {
                    min = "0" + minutos;
                } else {
                    min = minutos.toString();
                }
                if (segundos < 10) {
                    seg = "0" + segundos;
                } else {
                    seg = segundos.toString();
                }

                if (milesimas < 10) {
                    mil = "00" + milesimas;
                } else if (milesimas < 100) {
                    mil = "0" + milesimas;
                } else {
                    mil = milesimas.toString();
                }

                tiem = min + ":" + seg + ":" + mil;

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        lB_Tiempo.setText("" + tiem);
                        lB_Tiempo.setTextFill(Color.RED);
                    }
                });

            }
        } catch (Exception e) {
        }
        //Cuando se reincie se coloca nuevamente en 00:00:000
        //tiem = "00:00:000";
    }

    //Iniciar el cronometro poniendo cronometroActivo 
    //en verdadero para que entre en el while
    public void iniciarCronometro() {
        cronometroActivo = true;
        hilo = new Thread(this);
        hilo.start();
    }

    //Esto es para parar el cronometro
    public void pararCronometro() {
        cronometroActivo = false;
    }

}
