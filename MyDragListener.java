package com.tnielsen9082.hanafuda;

import android.content.ClipData;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

//this is the class that the receptacles get
public final class MyDragListener implements View.OnDragListener {
    private CharSequence clip;
    private static final String TAG = "MainActivity";
    private LinearLayout tricks;
    public void id(LinearLayout tag){
        tricks = tag;
    }
    @Override
    //when a drag is started this activates
    public boolean onDrag(View v, DragEvent event) {
        //calls getAction on the drag event
        //which tells you if it has:
            /*started
              entered the box
              left the box
              dropped
              still in the box
              or force quit
             */
        //we don't actually use this though
        //int action = event.getAction();
        //a new Java syntax appeared!
        //it looks for the action like I said
        //and then performs whichever case matches that action
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                //stop the code
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                //change the look to show it is droppable in
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                //change the look back
                break;
            case DragEvent.ACTION_DROP:
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);
                // Gets the text data from the item.
                clip = item.getText();
                clip=clip.toString();
                View view = (View) event.getLocalState();

                ViewGroup owner = (ViewGroup) view.getParent();
                LinearLayout container = (LinearLayout)v.getParent();
                //if you are not dropping in your own container
                if(owner!=container) {
                    owner.removeView(view);
                    container.removeView(v);

                    //add the view
                    tricks.addView(view);
                    tricks.addView(v);
                }
                break;
            case DragEvent.ACTION_DRAG_ENDED:

            default:
                //stops if there is no more dragging
                break;
        }
        //this allows you to receive updates on the status of the dragged thing
        return true;
    }
}

