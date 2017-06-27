package fr.cesi.base.ui.orthographe;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ChoixRubriqueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChoixRubriqueFragment extends Fragment implements IPopableFragment {
    
    @BindView(R.id.button1)
    Button _button1;

    @BindView(R.id.button2)
    Button _button2;

    @BindView(R.id.button3)
    Button _button3;

    @BindView(R.id.button4)
    Button _button4;

    @BindView(R.id.button5)
    Button _button5;

    @OnClick(R.id.button1)
    void onChooseThemeFamily(){
        ((OrthographeActivity)getActivity()).showFamilyFragment(Theme.Famille);
    }

    public ChoixRubriqueFragment() {
        // Required empty public constructor
    }

    public static ChoixRubriqueFragment newInstance() {
        ChoixRubriqueFragment fragment = new ChoixRubriqueFragment();
        return fragment;
    }

    public static ChoixRubriqueFragment newInstance(String param1, String param2) {
        ChoixRubriqueFragment fragment = new ChoixRubriqueFragment();
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
        return inflater.inflate(R.layout.fragment_choix_rubrique, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }



    @Override
    public boolean hasParent() {
        return false;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }



}
