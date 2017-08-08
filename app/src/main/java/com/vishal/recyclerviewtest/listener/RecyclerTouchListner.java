package com.vishal.recyclerviewtest.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.vishal.recyclerviewtest.MainActivity;

/**
 * Created by Vishal Aroor on 08-Aug-17.
 */

public class RecyclerTouchListner implements RecyclerView.OnItemTouchListener {


    private MyCustomClickListener clickListener;
    private GestureDetector gestureDetector;

    public RecyclerTouchListner(Context context, final RecyclerView recyclerView0, final MyCustomClickListener clickListener) {

        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                //super.onLongPress(e);

                View child = recyclerView0.findChildViewUnder(e.getX(), e.getY());
                if(child != null && clickListener != null ) {
                    clickListener.onLongClick(child, recyclerView0.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if(child != null && clickListener != null) {
            clickListener.onClick(child, rv.getChildAdapterPosition(child));
        }


        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
