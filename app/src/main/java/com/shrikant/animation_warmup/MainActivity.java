package com.shrikant.animation_warmup;

import com.shrikant.animation_warmup.databinding.ActivityMainBinding;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                binding.ivBike.animate().setDuration(1000).x(600).start();
//
//                binding.ivBike.animate()
//                        //.setDuration(1000)
//                        .translationX(600)
//                        .translationY(200)
//                        .setInterpolator(new BounceInterpolator())
//                        .start();

                ObjectAnimator moveAhead =
                        ObjectAnimator.ofFloat(binding.ivBike, View.TRANSLATION_X, 500);
                moveAhead.setDuration(3000);
                moveAhead.setInterpolator(new BounceInterpolator());

                ObjectAnimator turnAround =
                        ObjectAnimator.ofFloat(binding.ivBike, View.ROTATION_Y, 180);

                ObjectAnimator comeBack =
                        ObjectAnimator.ofFloat(binding.ivBike, View.TRANSLATION_X, 50);
                comeBack.setDuration(4000);
                comeBack.setInterpolator(new DecelerateInterpolator());

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveAhead, turnAround, comeBack);
                animatorSet.start();

            }
        });
    }
}
