package com.example.ovo.helper;

import com.example.ovo.R;
import com.example.ovo.model.MenuItem;

import java.util.ArrayList;

public class MenuDataUtil {
    public static ArrayList<MenuItem> getData() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("Pulsa", R.drawable.baseline_blur_circular_24));
        menuItems.add(new MenuItem("PLN", R.drawable.baseline_blur_circular_24));
        menuItems.add(new MenuItem("Air PDAM", R.drawable.baseline_blur_circular_24));
        menuItems.add(new MenuItem("E-Money", R.drawable.baseline_blur_circular_24));
        menuItems.add(new MenuItem("Pascabayar", R.drawable.baseline_blur_circular_24));
        menuItems.add(new MenuItem("BPJS", R.drawable.baseline_blur_circular_24));
        menuItems.add(new MenuItem("Pajak PBB", R.drawable.baseline_blur_circular_24));
        menuItems.add(new MenuItem("Internet", R.drawable.baseline_blur_circular_24));

        return menuItems;
    }
}

