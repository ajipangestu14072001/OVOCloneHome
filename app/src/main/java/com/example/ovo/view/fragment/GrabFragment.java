package com.example.ovo.view.fragment;

import static com.example.ovo.helper.MenuDataUtil.getData;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ovo.R;
import com.example.ovo.adapter.MainMenuAdapter;
import com.example.ovo.adapter.MenuFinanceAdapter;
import com.example.ovo.databinding.FragmentFinansialBinding;
import com.example.ovo.databinding.FragmentGrabBinding;
import com.example.ovo.helper.MenuDataUtil;
import com.example.ovo.model.MenuItem;

import java.util.ArrayList;

public class GrabFragment extends Fragment {

    private FragmentGrabBinding binding;
    private MainMenuAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGrabBinding.inflate(inflater, container, false);

        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 4);
        binding.grabRecycler.setLayoutManager(layoutManager);
        binding.grabRecycler.post(() -> adapter.justifyItems(binding.grabRecycler));
        adapter = new MainMenuAdapter(requireContext(), getData());
        binding.grabRecycler.setAdapter(adapter);

        return binding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}