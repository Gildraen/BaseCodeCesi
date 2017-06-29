package fr.cesi.base.ui.orthographe;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.R;

public class CorrectionMotFragment extends Fragment implements IPopableFragment {

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

}
