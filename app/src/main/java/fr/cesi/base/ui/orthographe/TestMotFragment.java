package fr.cesi.base.ui.orthographe;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.base.ui.orthographe.database.Word;
import fr.cesi.basecode.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestMotFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestMotFragment extends Fragment implements IPopableFragment {

    @BindView(R.id.theme)
    TextView _theme;

    @BindView(R.id.testword)
    TextView _testword;

    @BindView(R.id.correct)
    Button _correct;

    @BindView(R.id.incorrect)
    Button _incorrect;

    @BindView(R.id.passe)
    Button _passe;

    @OnClick(R.id.passe)
    void getPassed() {
        ((OrthographeActivity) getActivity()).startGameWithTest();
    }

    @OnClick(R.id.correct)
    void getLinkCorrect() {

        if (isWordCorrect()){
            ((OrthographeActivity) getActivity()).startGameWithTest(true);
        }
        else {
            ((OrthographeActivity) getActivity()).showCorrectionWord(false);
        }
    }

    @OnClick(R.id.incorrect)
    void getLinkIncorrect() {
        if (isWordCorrect()){
            ((OrthographeActivity) getActivity()).startGameWithTest(false);
        }
        else {
            ((OrthographeActivity) getActivity()).showCorrectionWord(true);
        }
    }

    public TestMotFragment() {
        // Required empty public constructor
    }
    public static TestMotFragment newInstance() {
        TestMotFragment fragment = new TestMotFragment();
        return fragment;
    }
    public static TestMotFragment newInstance(Theme theme) {
        TestMotFragment fragment = new TestMotFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_mot, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        loadWord();
    }

    private void loadWord() {
        OrthographeActivity activity = (OrthographeActivity) getActivity();

        Word current_word = activity.getCurrentWord();
        String current_word_chosen = activity.getCurrentWordChosen();

        _theme.setText(activity.getCurrentTheme().toString());
        _testword.setText(current_word_chosen);
    }

    public boolean isWordCorrect(){
        OrthographeActivity activity = (OrthographeActivity) getActivity();
        if ( activity.getCurrentWordChosen() == activity.getCurrentWord().correct) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean hasParent() {
        return true;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}

