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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CorrectionMotFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CorrectionMotFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CorrectionMotFragment extends Fragment implements IPopableFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CorrectionMotFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CorrectionMotFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CorrectionMotFragment newInstance() {
        CorrectionMotFragment fragment = new CorrectionMotFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
