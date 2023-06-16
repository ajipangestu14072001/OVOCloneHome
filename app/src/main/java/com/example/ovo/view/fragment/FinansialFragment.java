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
import com.example.ovo.databinding.FragmentFinansialBinding;
import com.example.ovo.helper.MenuDataUtil;
import com.example.ovo.model.MenuItem;

import java.util.ArrayList;

public class FinansialFragment extends Fragment {

    private FragmentFinansialBinding binding;
    private MainMenuAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFinansialBinding.inflate(inflater, container, false);

        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 4);
        binding.finRecycler.setLayoutManager(layoutManager);
        binding.finRecycler.post(() -> adapter.justifyItems(binding.finRecycler));
        adapter = new MainMenuAdapter(requireContext(), getData());
        binding.finRecycler.setAdapter(adapter);

        return binding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}