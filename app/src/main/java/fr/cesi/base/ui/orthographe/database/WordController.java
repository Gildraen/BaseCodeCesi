package fr.cesi.base.ui.orthographe.database;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

import fr.cesi.base.database.AbstractModelController;
import fr.cesi.base.ui.orthographe.Theme;

import static android.content.ContentValues.TAG;


public class WordController extends AbstractModelController<Word> {

    private static WordController _sinstance = new WordController();

    public static WordController getInstance() {
        return _sinstance;
    }

    @Override
    protected Property getColumnId() {
        return Word_Table._id;
    }

    @Override
    protected Class<? extends BaseModel> getTableClass() {
        return Word.class;
    }

    public void checkCreateWords() {
        List<Word> all = listAll();

        if(all == null || all.size() == 0) {
            Theme[] themes = new Theme[]{ Theme.Famille, Theme.Animaux, Theme.CorpsHumain, Theme.Couleurs, Theme.Maison};

            createTempo(Theme.Maison, "Chambre", "Chanbre", "Chambrre", "Chanbre");
            createTempo(Theme.Maison, "Cuisine", "Cuizine", "Cousine", "Cuizin");
            createTempo(Theme.Maison, "Salon", "Sallon", "Salong", "Calon");
            createTempo(Theme.Maison, "Lit", "Lie", "Lis", "Lir");
            createTempo(Theme.Maison, "Télévision", "Télévizion", "Télévission", "Télevision");
            createTempo(Theme.Maison, "Table", "Tabble", "Tablet", "Tablee");
            createTempo(Theme.Maison, "Fauteuil", "Foteuil", "Fauteuille", "Fauteille");
            createTempo(Theme.Maison, "Salle de bain", "Salle deux bain", "Sale de bain", "Salle de bin");
            createTempo(Theme.Maison, "Douche", "Douchee", "Doushe", "Duche");
            createTempo(Theme.Maison, "Chaise", "Cheze", "Chèse", "Chêse");

            createTempo(Theme.Famille, "Père", "Paire", "Pêreu", "Pere");
            createTempo(Theme.Famille, "Mère", "Mere", "Maire", "Mére");
            createTempo(Theme.Famille, "Soeur", "Seur", "Sore", "Soeure");
            createTempo(Theme.Famille, "Frère", "Frere", "Frêre", "Frèrre");
            createTempo(Theme.Famille, "Grand-mère", "Gran-mère", "Grant-mère", "Grand-maire");
            createTempo(Theme.Famille, "Grand-père", "Gran-père", "Grant-père", "Grand-paire");
            createTempo(Theme.Famille, "Tante", "Tente", "Tainte", "Tinte");
            createTempo(Theme.Famille, "Oncle", "Onccle", "Onqule", "Onkle");
            createTempo(Theme.Famille, "Fille", "File", "Fiille", "Filleu");
            createTempo(Theme.Famille, "Fils", "Filse", "Fise", "Filce");

            createTempo(Theme.CorpsHumain, "Nez", "Né", "Net", "Nés");
            createTempo(Theme.CorpsHumain, "Main", "Min", "Maint", "Mauin ");
            createTempo(Theme.CorpsHumain, "Tête", "Tète", "Teteu", "Têtte");
            createTempo(Theme.CorpsHumain, "Jambe", "Janbe", "Jembe", "Gambe");
            createTempo(Theme.CorpsHumain, "Bras", "Bra", "Brat", "Braz");
            createTempo(Theme.CorpsHumain, "Doigt", "Doit", "Doitg", "Doig");
            createTempo(Theme.CorpsHumain, "Oreille", "Orêille", "Orreille", "Oreille");
            createTempo(Theme.CorpsHumain, "Genou", "Jenou", "Gennou", "Geunou");
            createTempo(Theme.CorpsHumain, "Coude", "Coudde", "Koude", "Coudee");
            createTempo(Theme.CorpsHumain, "Oeil", "Oil", "Oel", "Oils");

            createTempo(Theme.Couleurs, "Vert", "Verre", "Vers", "Ver");
            createTempo(Theme.Couleurs, "Rouge", "Rouge", "Rougee", "Rouje");
            createTempo(Theme.Couleurs, "Mauve", "Move", "Mouve", "Mauvee");
            createTempo(Theme.Couleurs, "Jaune", "Jone", "Gone", "Jaunne");
            createTempo(Theme.Couleurs, "Violet", "Voilet", "Violét", "Viaulet");
            createTempo(Theme.Couleurs, "Blanc", "Blen", "Blan", "Blant");
            createTempo(Theme.Couleurs, "Bleu", "Ble", "Bleuh", "Bleux");
            createTempo(Theme.Couleurs, "Orange", "Orrange", "Orenge", "Oranje");
            createTempo(Theme.Couleurs, "Rose", "Rause", "Roze", "Rosse");
            createTempo(Theme.Couleurs, "Gris", "Gri", "Guris", "Grie");

            createTempo(Theme.Animaux, "Chien", "Shien", "Chiun", "Chihen");
            createTempo(Theme.Animaux, "Chat", "Shat", "Cha", "Chas");
            createTempo(Theme.Animaux, "Hamster", "Hamester", "Amster", "Hamstère");
            createTempo(Theme.Animaux, "Oiseau", "Ouaseau", "Oizeau", "Oisot");
            createTempo(Theme.Animaux, "Chèvre", "Chevre", "Chêvre", "Shèvre");
            createTempo(Theme.Animaux, "Vache", "Vache", "Vahce", "Vâche");
            createTempo(Theme.Animaux, "Cochon", "Cochonn", "Kochon", "Cochun");
            createTempo(Theme.Animaux, "Tortue", "Tortu", "Torttue", "Tortuee");
            createTempo(Theme.Animaux, "Poisson", "Poison", "Pouasson", "Poissont");
            createTempo(Theme.Animaux, "Furet", "Furé", "Furêt", "Furët");
        }
    }

    public List<Word> listFromTheme(Theme theme) {
        return (List<Word>) new Select()
                .from(getTableClass())
                .where(Word_Table.theme.eq(theme.toString()))
                .queryList();
    }

    public Word getRandomAndRemoveFromList(List<Word> list) {
        if (list.size()>0) {

            int index = (int) Math.floor(Math.random() * (list.size()));
            Word word = list.get(index);
            list.remove(index);
            return word;
        }
        else {
            return null;
        }
    }


    public Word createTempo(Theme theme, String correct, String false1, String false2, String false3) {
        Word instance = new Word(theme, correct, false1, false2, false3);

        instance.save();

        return instance;
    }
}
