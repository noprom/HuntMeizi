package com.huntdreams.huntmeizi;

import android.database.sqlite.SQLiteDatabase;

import org.litepal.LitePalApplication;
import org.litepal.tablemanager.Connector;

/**
 * Created by noprom on 15/6/25.
 */
public class App extends LitePalApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        SQLiteDatabase db = Connector.getDatabase();    // 初始化数据库
    }
}
