package com.example.ovo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ovo.R;
import com.example.ovo.databinding.ItemChipBinding;

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.ViewHolder> {

    private final String[] itemList;
    private int selectedItem = -1;
    private final ViewPager2 viewPager;

    private OnChipClickListener onChipClickListener;

    public ChipAdapter(String[] itemList, ViewPager2 viewPager) {
        this.itemList = itemList;
        this.viewPager = viewPager;
    }

    public void setOnChipClickListener(OnChipClickListener listener) {
        this.onChipClickListener = listener;
    }

    public interface OnChipClickListener {
        void onChipClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemChipBinding binding;

        public ViewHolder(ItemChipBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String item, boolean isSelected) {
            binding.chipText.setText(item);

            if (isSelected) {
                binding.chipText.setBackgroundResource(R.drawable.chip_outline_selected);
                binding.chipText.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.white));
            } else {
                binding.chipText.setBackgroundResource(R.drawable.chip_outline);
                binding.chipText.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.black));
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        setSelectedItem(position);
                        viewPager.setCurrentItem(position, true);
                        if (onChipClickListener != null) {
                            onChipClickListener.onChipClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChipBinding binding = ItemChipBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = itemList[position];
        boolean isSelected = position == selectedItem;
        holder.bind(item, isSelected);
    }

    @Override
    public int getItemCount() {
        return itemList.length;
    }

    public void setSelectedItem(int position) {
        int previousSelectedItem = selectedItem;
        selectedItem = position;
        notifyItemChanged(previousSelectedItem);
        notifyItemChanged(selectedItem);
    }
}
