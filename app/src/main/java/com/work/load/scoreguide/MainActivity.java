package com.work.load.scoreguide;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

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
