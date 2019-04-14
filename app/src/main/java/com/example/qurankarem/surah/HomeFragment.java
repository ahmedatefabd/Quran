package com.example.qurankarem.surah;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.qurankarem.Base.BaseFragment;
import com.example.qurankarem.R;

public class HomeFragment extends BaseFragment {

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_surah, container, false);
    }

}
