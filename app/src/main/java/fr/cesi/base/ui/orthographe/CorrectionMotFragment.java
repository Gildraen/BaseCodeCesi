package fr.cesi.base.ui.orthographe;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.R;

public class CorrectionMotFragment extends Fragment implements IPopableFragment {
    @BindView(R.id.wordtocorrect)
    TextView _wordtocorrect;

    @BindView(R.id.messerror2)
    TextView _messerror2;

    boolean _testButton;

    public CorrectionMotFragment() {
        // Required empty public constructor
    }

    public static CorrectionMotFragment newInstance() {

        CorrectionMotFragment fragment = new CorrectionMotFragment();
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
        return inflater.inflate(R.layout.fragment_correction_mot, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        showCurrentWord();
    }

    @Override
    public boolean hasParent() {
        return true;
    }

    @Override
    public boolean onBackPressed() {
        boolean valid = true;
        if (!valid) {
            return true;
        }
        else
            return false;
    }

    public void showCurrentWord() {
        OrthographeActivity activity = (OrthographeActivity) getActivity();
        _wordtocorrect.setText(activity.getCurrentWordChosen());
    }

    public void  showErrorMessage(){
        _messerror2.setVisibility(View.VISIBLE);
    }
}
