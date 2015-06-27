package com.huntdreams.huntmeizi;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.huntdreams.huntmeizi.widget.MultiSwipeRefreshLayout;

/**
 * Created by noprom on 15/6/27.
 */
public abstract class SwipeRefreshBaseActivity extends AppCompatActivity {

    MultiSwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState);
        trySetupSwipeRefresh();
    }

    void trySetupSwipeRefresh() {
        mSwipeRefreshLayout = (MultiSwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setColorSchemeResources(
                    R.color.refresh_progress_3,
                    R.color.refresh_progress_2,
                    R.color.refresh_progress_1
            );
            mSwipeRefreshLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            requestDataRefresh();
                        }
                    }
            );
        }
    }

    public void requestDataRefresh() {
    }

    public void setRefreshing(boolean refreshing) {
        if (mSwipeRefreshLayout == null) {
            return;
        }
        if (!refreshing) {
            mSwipeRefreshLayout.setRefreshing(false);
        } else {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    public void setProgressViewOffset(boolean scale, int start, int end) {
        mSwipeRefreshLayout.setProgressViewOffset(scale, start, end);
    }

    public void setSwipeableChildren(MultiSwipeRefreshLayout.CanChildScrollUpCallback canChildScrollUpCallback) {
        mSwipeRefreshLayout.setCanChildScrollUpCallback(canChildScrollUpCallback);
    }

}
