package com.work.load.scoreguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isExit = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onBackPressed() {
        if(isExit){
            SccorePopupWindow sccorePopupWindow = new SccorePopupWindow(this);
            sccorePopupWindow.show(findViewById(R.id.tv),"ljllklkl");
        }
    }
}
