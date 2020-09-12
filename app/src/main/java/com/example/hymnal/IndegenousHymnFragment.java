package com.example.hymnal;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hymnal.databinding.FragmentIndegenousHymnBinding;

public class IndegenousHymnFragment extends Fragment {

    FragmentIndegenousHymnBinding binding;

    public IndegenousHymnFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_indegenous_hymn, container, false);

        return binding.getRoot();
    }
}