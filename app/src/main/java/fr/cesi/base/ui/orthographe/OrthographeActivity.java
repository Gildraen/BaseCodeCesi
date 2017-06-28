package fr.cesi.base.ui.orthographe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cesi.base.controllers.fragment.AbstractPopableActivity;
import fr.cesi.base.controllers.fragment.IActivityListener;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.base.controllers.fragment.StackController;
import fr.cesi.base.ui.orthographe.database.Word;
import fr.cesi.base.ui.orthographe.database.WordController;
import fr.cesi.basecode.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class OrthographeActivity extends AbstractPopableActivity implements IActivityListener {

    private static final String TAG = OrthographeActivity.class.getSimpleName();

    @BindView(R.id.main_content)
    LinearLayout _main_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orthographe);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/ec.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );

        //init the database manager
        //must be called once in the app
        FlowManager.init(this);
        WordController.getInstance().checkCreateWords();

        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IPopableFragment current_stack_head = getStackController().head();
        if (current_stack_head == null) {
            TestMotFragment fragment = TestMotFragment.newInstance();
            getStackController().push(fragment);
        }

    }

    @Override
    protected StackController createStackController() {
        return new StackController(this, _main_content);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void showFamilyFragment(Theme theme) {
        //getStackController().push(ShowWord.newInstance(oeirieurty))
        List<Word> list_to_load = WordController.getInstance().listFromTheme(theme);
        Log.d(TAG, "showFamilyFragment: list_to_load size := "+list_to_load.size() + " for " + theme);
    }


}