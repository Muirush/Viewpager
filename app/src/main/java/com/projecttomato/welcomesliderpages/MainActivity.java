 package com.projecttomato.welcomesliderpages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
        private ViewPager viewPager;
        private LinearLayout mDotLayout;
        private  sliderAdapter sliderAdapter;
        private TextView[] mDots;
        private Button btSkip, btNext;
        private ImageView imBack;
        private  int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mDotLayout = (LinearLayout) findViewById(R.id.linear);

        sliderAdapter = new sliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewChangeListener);

        btNext = findViewById(R.id.Next);
        btSkip = findViewById(R.id.Skip);
        imBack = findViewById(R.id.sliderBack);
        btSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, home.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public  void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++){
        mDots[i] = new TextView(this);
        mDots[i]. setText(Html.fromHtml("&#8226;"));
        mDots[i].setTextSize(35);
        mDots[i].setTextColor(getResources().getColor(R.color.purple_500));
        mDotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.black));
        }
    }
    ViewPager.OnPageChangeListener viewChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage= position;
            if (position == 0){
                imBack.setEnabled(false);
                imBack.setVisibility(View.INVISIBLE);
                btNext.setEnabled(true);
            } else if(position == mDots.length -1){
                imBack.setEnabled(true);
                imBack.setVisibility(View.VISIBLE);
                btNext.setEnabled(true);
                btNext.setText("Finish");
            }else {
                btNext.setEnabled(true);
                imBack.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                btNext.setText("Next");
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}