package fr.cesi.base.ui.orthographe;

/**
 * Created by Gildraen on 27/06/2017.
 */

public enum Theme {

    Maison,
    Famille,
    CorpsHumain,
    Couleurs,
    Animaux;


    @Override
    public String toString() {
        switch(this) {
            case Maison: return "Maison";
            case Famille: return "Famille";
            case CorpsHumain: return "CorpsHumain";
            case Couleurs: return "Couleurs";
            case Animaux: return "Animaux";
        }
        return "";
    }
}
