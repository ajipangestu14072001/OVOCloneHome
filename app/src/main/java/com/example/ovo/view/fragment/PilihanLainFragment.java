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
import com.example.ovo.databinding.FragmentFavoritBinding;
import com.example.ovo.databinding.FragmentPilihanLainBinding;

public class PilihanLainFragment extends Fragment {
    private FragmentPilihanLainBinding binding;

    private MainMenuAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPilihanLainBinding.inflate(inflater, container, false);
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 4);
        binding.othersRecycler.setLayoutManager(layoutManager);
        binding.othersRecycler.post(() -> adapter.justifyItems(binding.othersRecycler));
        adapter = new MainMenuAdapter(requireContext(), getData());
        binding.othersRecycler.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}