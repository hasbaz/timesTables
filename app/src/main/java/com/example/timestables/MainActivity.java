package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ListView timesView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timesView = (ListView) findViewById(R.id.timesListView);
        SeekBar setNumber = (SeekBar) findViewById(R.id.seekBar);
        setNumber.setMax(19);
        updateTimesView(0);
        setNumber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimesView(i+1);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    /*
    This method creates the array adapter with the times table when called and then sets this adapter to the times view
    @param  timesNum The number of the times table you wish generate
    @param  maxMultiple the highest number you wish to times the initial imputed number against
    @return     A string array of times table up to the maxMultiple
     */
    }
    public String[] generateTimesArray(int timesNum,int maxMultiple){
        String[] output = new String[maxMultiple];
        for(int i = 0; i <maxMultiple; i++){
            output[i] = String.valueOf(timesNum*(i+1));
        }
        return output;
    }
    /*
    This method creates the array adapter with the times table when called and then sets this adapter to the times view
    @param  i The number of the times table you wish to see output
     */
    public void updateTimesView(int i){

        ArrayAdapter<String> timesAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, generateTimesArray(i,12));
        timesView.setAdapter(timesAdapter);
    }
}