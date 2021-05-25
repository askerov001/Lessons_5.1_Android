package com.example.lessons_5_android.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.example.lessons_5_android.MainActivity;
import com.example.lessons_5_android.R;
import com.example.lessons_5_android.databinding.FragmentFormBinding;


public class FormFragment extends Fragment {
   private MainActivity activity;
    private FragmentFormBinding binding;

    public FormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = (MainActivity) requireActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater,container,false);
        activity.hideBottomNav();
        activity.hideToolbar();
        return binding.getRoot();
    }
}