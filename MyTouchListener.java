package com.tnielsen9082.hanafuda;


import android.content.ClipData;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;


public final class MyTouchListener implements View.OnTouchListener {
    //the action that the class performs
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //makes the class motionEvent perform the getAction function
        //motionEvents track what is touching the screen
        //ACTION_DOWN means that someone just started touching it
        //so this if is checking if the square has been tapped
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            //makes a clipData
            //since we are just using pictures there is no data
            //but there could be data
            //this is how you copy/paste things
            ClipData data;
            data = ClipData.newPlainText("", view.getContentDescription()+"");
            //make a custom drag shadow
            //once I create it
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 1);
            Log.e("TAG",""+data);
            return true;
        }
        else {
            return false;
        }
    }
}

