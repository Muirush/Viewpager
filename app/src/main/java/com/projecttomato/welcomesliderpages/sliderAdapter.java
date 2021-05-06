package com.projecttomato.welcomesliderpages;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class sliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public  sliderAdapter(Context context){

        this.context = context;
    }

    //arrays for
    public  int[] slide_images = {
            R.drawable.school1,
            R.drawable.school2,
            R.drawable.school3
    };


    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container, false);
        ImageView slide_imageView = (ImageView) view.findViewById (R.id.imageView);
        Button button = (Button) view.findViewById(R.id.Skip);


        slide_imageView.setImageResource(slide_images[position]);
        container.addView(view);
        return  view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
