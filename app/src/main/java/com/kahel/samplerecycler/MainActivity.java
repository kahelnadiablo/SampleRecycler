package com.kahel.samplerecycler;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    GridLayoutManager layoutManager;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getBaseContext(),2); //set grid layout manager with 2 columns. You can make it dynamic using dimens and add integer values there
        adapter = new Adapter(getBaseContext());

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            /*This will span your views based on the item type provided*/
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getItemViewType(position)) {
                    case 1:
                        return 1; //if adapter type is 1 use 1 span else use 2
                    default:
                        return 2;
                }
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
