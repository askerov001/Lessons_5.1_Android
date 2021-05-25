package com.example.lessons_5_android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.lessons_5_android.databinding.FragmentDashBinding;
import com.example.lessons_5_android.databinding.FragmentNotifBinding;


public class NotifFragment extends Fragment {

   private FragmentNotifBinding binding;
    public NotifFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotifBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}