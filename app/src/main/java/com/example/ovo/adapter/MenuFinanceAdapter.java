package com.example.ovo.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ovo.R;
import com.example.ovo.databinding.ItemFinanceBinding;
import com.example.ovo.model.MenuItem;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

public class MenuFinanceAdapter extends RecyclerView.Adapter<MenuFinanceAdapter.ViewHolder> {

    private final ArrayList<MenuItem> rvData;
    private final LayoutInflater inflater;
    private final Context context;


    public MenuFinanceAdapter(Context context, ArrayList<MenuItem> inputData) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        rvData = inputData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemFinanceBinding binding;

        public ViewHolder(ItemFinanceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MenuItem item) {
            binding.img.setImageResource(item.getImageResource());
            binding.title.setText(item.getTitle());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFinanceBinding binding = ItemFinanceBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuItem item = rvData.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public void justifyItems(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof FlexboxLayoutManager) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) layoutManager;
            flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);
            flexboxLayoutManager.setJustifyContent(JustifyContent.CENTER);
            flexboxLayoutManager.setAlignItems(AlignItems.STRETCH);
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new JustifySpaceItemDecoration(context));
    }

    private static class JustifySpaceItemDecoration extends RecyclerView.ItemDecoration {
        private final int itemSpacing;

        public JustifySpaceItemDecoration(Context context) {
            itemSpacing = context.getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = itemSpacing;
            outRect.right = itemSpacing;
            outRect.top = itemSpacing;
            outRect.bottom = itemSpacing;
        }
    }
}
