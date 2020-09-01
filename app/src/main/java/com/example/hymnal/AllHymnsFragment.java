package com.example.hymnal;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hymnal.databinding.FragmentAllHymnsBinding;

public class AllHymnsFragment extends Fragment {

    FragmentAllHymnsBinding binding;

    public AllHymnsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_all_hymns, container, false);

        return binding.getRoot();
    }
}