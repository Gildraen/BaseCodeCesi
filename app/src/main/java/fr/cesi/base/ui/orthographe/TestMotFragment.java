package fr.cesi.base.ui.orthographe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestMotFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestMotFragment extends Fragment implements IPopableFragment {


    public TestMotFragment() {
        // Required empty public constructor
    }
    public static TestMotFragment newInstance() {
        TestMotFragment fragment = new TestMotFragment();
        return fragment;
    }
    public static TestMotFragment newInstance(String param1, String param2) {
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
    public boolean hasParent() {
        return false;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
