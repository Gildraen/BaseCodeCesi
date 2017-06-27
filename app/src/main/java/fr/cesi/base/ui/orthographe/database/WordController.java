package fr.cesi.base.ui.orthographe.database;

import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

import fr.cesi.base.database.AbstractModelController;
import fr.cesi.base.ui.orthographe.Theme;


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

            for (Theme theme :
                    themes) {
                for (int i = 0; i < 10; i++) {
                    createTempo(theme, "correct"+i, "korrect"+i, "korrect"+i, "korect"+i);
                }
            }
            //createTempo(Theme.Famille, "correct", "korrect1", "korrect2", "korect3");
        }
    }

    public List<Word> listFromTheme(Theme theme) {
        return (List<Word>) new Select()
                .from(getTableClass())
                .where(Word_Table.theme.eq(theme.toString()))
                .queryList();
    }

    public Word getRandomAndRemoveFromList(List<Word> list) {
        int index = (int) Math.floor(Math.random() * (list.size() + 1));
        Word word = list.get(index);
        list.remove(index);
        return word;
    }


    public Word createTempo(Theme theme, String correct, String false1, String false2, String false3) {
        Word instance = new Word(theme, correct, false1, false2, false3);

        instance.save();

        return instance;
    }
}
