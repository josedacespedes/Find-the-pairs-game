package projectprogra;

import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LogicMx {

    Card cD[][] = new Card[4][5];

    //Ide de cada carta para ser comparda entre ellas
    int iDe = 0;

    //Metodo que crea dos arreglos con randoms sin repetir del 1 al 10 y luego en otro arreglo se unifican los 2
    public int[] parRandom() {

        //Tamaños de arreglos
        int sizeArray = cD.length * cD[0].length;
        int arraysLittle = sizeArray / 2;

        //Guardo temporalmente tamaño de arreglo pequeño
        int k = arraysLittle;

        //Creacion de arreglos
        int[] a_Numbers = new int[arraysLittle];
        int[] a_Result = new int[arraysLittle];
        int[] b_Numbers = new int[arraysLittle];
        int[] b_Result = new int[arraysLittle];
        int[] arrayUnificate = new int[sizeArray];

        //Creo objeto que genera randoms
        Random rnd = new Random();

        //Declaro variables e inicializo
        int res;
        int cont_a = 0;
        int cont_b = 0;

        //se rellena matriz a y b ordenadas del 1 al 10
        for (int i = 0; i < a_Numbers.length; i++) {
            a_Numbers[i] = i + 1;
        }//End for que rellena ordenadamente

        //se rellena matriz a y b ordenadas del 1 al 10
        for (int i = 0; i < b_Numbers.length; i++) {
            b_Numbers[i] = i + 1;
        }//End for que rellena ordenadamente

        //for que llena  matriz con numeros del 1 al 10 sin repetir
        for (int i = 0; i < a_Numbers.length; i++) {

            res = rnd.nextInt(k); //Genera random de 0 hasta k-1 

            a_Result[i] = a_Numbers[res]; //Asigno a arreglo result lo que tiene a_numbers en la posicion "res" generada por el random
            a_Numbers[res] = a_Numbers[k - 1]; //Sustituyo lo que estaba en res por lo que esta en k-1

            k--; //Disminuye k para generar ramdon disitinto

        }//End de for para a_result

        k = arraysLittle; //Guardo temporalmente tamaño de arreglo pequeño

        //for que llena  matriz con numeros del 1 al 10 sin repetir(misma funcion que el for de arriba)
        for (int i = 0; i < b_Numbers.length; i++) {

            res = rnd.nextInt(k);

            b_Result[i] = b_Numbers[res];
            b_Numbers[res] = b_Numbers[k - 1];

            k--;

        }//End de for para b_result

        //for  para unificar el arreglo result a y b
        for (int i = 0; i < arrayUnificate.length; i++) {

            //If que acomoda intercaladamente los arreglos a y b en arrayUnificate
            if (i % 2 == 0) {
                arrayUnificate[i] = a_Result[cont_a];
                cont_a++;

            } else {
                arrayUnificate[i] = b_Result[cont_b];
                cont_b++;

            }//End if de acomodo 

        }//End de for de arrayUnificate

        return arrayUnificate;
    }//End parRandom()

    //Metodo que llena matriz con las bootn default, imagen default, imagen diferente, ide
    public Card[][] cardSame(int[] numberPosition) {

        int i = 0;

        for (int f = 0; f < cD.length; f++) {
            for (int c = 0; c < cD[0].length; c++) {

                //Ide que se le asingna numero que venga del arreglo numberPosition
                iDe = numberPosition[i];

                //cargar al boton una imagen por default
                Button bTN_cardDefault = new Button();
                bTN_cardDefault.setGraphic(new ImageView(new Image("images/cA.png")));

                //Imagen diferente
                ImageView iV_differ = new ImageView(new Image("difer/" + numberPosition[i] + ".png"));

                //imagen igual
                ImageView iV_same = new ImageView(new Image("images/cA.png"));

                cD[f][c] = new Card(iDe, bTN_cardDefault, iV_differ, iV_same);

                i++;

            }//End for de columnas

        }//End for de filas

        return cD;
    }//End cardSame()

}//End class LogicMx
