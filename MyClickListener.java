package com.tnielsen9082.hanafuda;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MyClickListener implements View.OnClickListener{
    private LinearLayout drawPile;
    private LinearLayout hand;
    public void id(LinearLayout tag1, LinearLayout tag2){
        drawPile=tag1;
        hand=tag2;
    }
    @Override
    public void onClick(View v) {
        View card;
        if(drawPile.getChildCount()!=0){
            card= drawPile.getChildAt(0);
            drawPile.removeView(card);
            hand.addView(card);
        }
    }
}
