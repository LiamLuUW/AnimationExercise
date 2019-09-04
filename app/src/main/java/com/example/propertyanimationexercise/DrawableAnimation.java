package com.example.propertyanimationexercise;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class DrawableAnimation extends Fragment {

    AnimationDrawable rocketAnimation;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_drawable_animation, container, false);
        ImageView image = (ImageView) view.findViewById(R.id.drawable_animation_image);
        image.setBackgroundResource(R.drawable.animated_button);
        rocketAnimation = (AnimationDrawable) image.getBackground();
        Animation hyperspaceJump = AnimationUtils.loadAnimation(getContext(), R.anim.hyperspaxe_jump);
        image.startAnimation(hyperspaceJump);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rocketAnimation.start();
            }
        });
        return view;
    }



}
