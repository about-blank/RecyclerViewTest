package com.vishal.recyclerviewtest.listener;

import android.view.View;

/**
 * Created by Vishal Aroor on 08-Aug-17.
 */

public interface MyCustomClickListener {
    void onClick(View view, int position);
    void onLongClick(View view, int position);

}
