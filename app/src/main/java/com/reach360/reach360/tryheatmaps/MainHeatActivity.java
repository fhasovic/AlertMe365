package com.reach360.reach360.tryheatmaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.reach360.reach360.R;

public class MainHeatActivity extends Activity implements View.OnClickListener {
    private ViewGroup mListView;

    //Comment to see if I can push to the repository

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainheat);

        mListView = (ViewGroup) findViewById(R.id.list);


        //addDemo("Generating tiles", TileProviderAndProjectionDemo.class);
        addDemo("Heatmaps", HeatmapsDemoActivity.class);

    }

    private void addDemo(String demoName, Class<? extends Activity> activityClass) {
        Button b = new Button(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        b.setLayoutParams(layoutParams);
        b.setText(demoName);
        b.setTag(activityClass);
        b.setOnClickListener(this);
        mListView.addView(b);
    }

    @Override
    public void onClick(View view) {
        Class activityClass = (Class) view.getTag();
        startActivity(new Intent(this, activityClass));
    }
}
