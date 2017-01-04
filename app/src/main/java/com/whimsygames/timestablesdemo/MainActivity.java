package com.whimsygames.timestablesdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> results = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(19);
        seekBar.setProgress(0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                calculateProducts(progress);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        ListView listView = (ListView) findViewById(R.id.listView);

        calculateProducts(1);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results);

        listView.setAdapter(arrayAdapter);

    }

    private void calculateProducts(final int table) {

        results.clear();

        for (int i = 1; i < 10; i++) {
            results.add(Integer.toString((table + 1) * i));
        }
    }
}
