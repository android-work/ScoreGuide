package com.work.load.scoreguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView feedback_left;
    private TextView tv_feedback_send;
    private EditText edit_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        feedback_left = findViewById(R.id.feedback_left);
        tv_feedback_send = findViewById(R.id.tv_feedback_send);
        edit_feedback = findViewById(R.id.edit_feedback);

        feedback_left.setOnClickListener(this);
        tv_feedback_send.setOnClickListener(this);

        edit_feedback.setGravity(Gravity.TOP);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.feedback_left) {
            finish();
        } else if (i == R.id.tv_feedback_send) {
            String content = edit_feedback.getText().toString();
            if (!TextUtils.isEmpty(content)) {
                Toast.makeText(FeedbackActivity.this, getString(R.string.submitt_successful), Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(FeedbackActivity.this, getString(R.string.content_null), Toast.LENGTH_SHORT).show();
            }
        }
    }



}
