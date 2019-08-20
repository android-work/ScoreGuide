package com.work.load.scoreguide;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class SccorePopupWindow extends PopupWindow {

    private ImageView star_2,star_1,star_4,star_3,star_5;
    private LinearLayout score_ll;
    private ImageView hand;
    private Context context;
    private final TextView score_1;

    public SccorePopupWindow(final Context context){
        this.context = context;

        final View inflate = LayoutInflater.from(context).inflate(R.layout.score_guide_layout, null);
        setContentView(inflate);

        star_1 = inflate.findViewById(R.id.star_1);
        star_2 = inflate.findViewById(R.id.star_2);
        star_3 = inflate.findViewById(R.id.star_3);
        star_4 = inflate.findViewById(R.id.star_4);
        star_5 = inflate.findViewById(R.id.star_5);

        score_ll = inflate.findViewById(R.id.ll);
        hand = inflate.findViewById(R.id.hand);

        score_1 = inflate.findViewById(R.id.score_1);

        setOutsideTouchable(false);
        setFocusable(true);
        setTouchable(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
        setBackgroundDrawable(colorDrawable);
        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        setHeight(LinearLayout.LayoutParams.MATCH_PARENT);

        //点击5星进gp
        star_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goGooglePlay(context);
                dismiss();
            }
        });

        score_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FeedbackActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                dismiss();
            }
        });

    }




    public void goGooglePlay(Context context) {
        String packageName = context.getPackageName();
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            context.startActivity(intent);
        } catch (Exception anfe) {
            anfe.printStackTrace();
            Intent launchIntent = new Intent(Intent.ACTION_VIEW);
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            launchIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            context.startActivity(launchIntent);


        }

    }

    public void show(View view,String app_name){
        showAtLocation(view, Gravity.CENTER,0,0);

        createAniamtor();

        score_1.setText(context.getString(R.string.score_1,app_name));
        Log.e("tag","弹窗，动画");
    }

    public void cancel(){
        dismiss();
    }

    public void createAniamtor(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, dip2px(230));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int offset = (int) animation.getAnimatedValue();
                if (offset>= dip2px(30)){
                    star_1.setImageResource(R.mipmap.star_select);
                }if (offset>= dip2px(65)){
                    star_2.setImageResource(R.mipmap.star_select);
                }if (offset>= dip2px(115)){
                    star_3.setImageResource(R.mipmap.star_select);
                }if (offset>= dip2px(165)){
                    star_4.setImageResource(R.mipmap.star_select);
                }if (offset>= dip2px(200)){
                    star_5.setImageResource(R.mipmap.star_select);
                }

            }
        });
        valueAnimator.setDuration(3000);
        valueAnimator.start();

        ObjectAnimator translationX = ObjectAnimator.ofFloat(hand, "translationX", 0f, dip2px(220));
        translationX.setDuration(3000);
        translationX.start();


        translationX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(hand, "scaleX", 1f,0, 1f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(hand, "scaleY", 1f,0, 1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(scaleX).with(scaleY);
                animatorSet.setDuration(3000);
                animatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });



    }

    public int dip2px( float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
