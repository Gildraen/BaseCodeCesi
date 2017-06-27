package fr.cesi.base.ui.orthographe.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.cesi.base.ui.orthographe.Theme;

/**
 * Created by Gildraen on 27/06/2017.
 */
@Table(name = "Word", database = WordDatabase.class)
public class Word extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    public int _id;

    @Column
    public String correct;

    @Column
    public String false1;

    @Column
    public String false2;

    @Column
    public String false3;

    @Column
    public String theme;

    public Word() {

    }

    public Word(Theme theme, String correct, String false1, String false2, String false3) {
        this.correct = correct;
        this.false1 = false1;
        this.false2 = false2;
        this.false3 = false3;
        this.theme = theme.toString();
    }
}
