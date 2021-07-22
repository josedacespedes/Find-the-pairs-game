package projectprogra;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Card {

    //Atributos de la carta
    private int ID;
    private Button bTN;
    private ImageView iMV_differ;
    private ImageView iM_Default;

    //Constructor
    public Card(int ID, Button bTN, ImageView iMV_differ, ImageView iM_Default) {
        this.ID = ID;
        this.bTN = bTN;
        this.iMV_differ = iMV_differ;
        this.iM_Default = iM_Default;
    }

    //Set y gets de la clase carta
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Button getbTN() {
        return bTN;
    }

    public void setbTN(Button bTN) {
        this.bTN = bTN;
    }

    public ImageView getiMV_differ() {
        return iMV_differ;
    }

    public void setiMV(ImageView iMV_differ) {
        this.iMV_differ = iMV_differ;
    }

    public ImageView getiM_Default() {
        return iM_Default;
    }

    public void setiM_Default(ImageView iM_Default) {
        this.iM_Default = iM_Default;
    }

}
