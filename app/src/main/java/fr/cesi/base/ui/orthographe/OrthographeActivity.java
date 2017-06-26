package fr.cesi.base.ui.orthographe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cesi.base.controllers.fragment.AbstractPopableActivity;
import fr.cesi.base.controllers.fragment.IActivityListener;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.base.controllers.fragment.StackController;
import fr.cesi.basecode.R;

public class OrthographeActivity extends AbstractPopableActivity implements IActivityListener {

    @BindView(R.id.main_content)
    LinearLayout _main_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orthographe);

        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IPopableFragment current_stack_head = getStackController().head();
        if (current_stack_head == null) {
            CorrectionMotFragment fragment = CorrectionMotFragment.newInstance();
            getStackController().push(fragment);
        }

    }

    @Override
    protected StackController createStackController() {
        return new StackController(this, _main_content);
    }

}