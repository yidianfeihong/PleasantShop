package com.example.ming.pleasantshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ming.pleasantshop.R;


/**
 * Created by Ivan on 15/9/25.
 */
public class HomeFragment extends Fragment {


    private static  final  String TAG="HomeFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home,container,false);
        return  view;
    }
}
