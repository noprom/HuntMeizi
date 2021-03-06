package com.huntdreams.huntmeizi;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.huntdreams.huntmeizi.model.Meizi;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends SwipeRefreshBaseActivity {

    RecyclerView mRecyclerView;
    MeizhiListAdapter mMeiziListAdapter;
    List<Meizi> mMeiziList;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();
        mMeiziList = new ArrayList<>();
        mMeiziList.addAll(OldMeizi.init());
        setUpRecyclerView();
    }


    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }, 358);
    }


    private void setUpRecyclerView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_meizhi);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mMeiziListAdapter = new MeizhiListAdapter(this, mMeiziList);
        mRecyclerView.setAdapter(mMeiziListAdapter);
    }

    private void getData(){
        // TODO getData()
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
