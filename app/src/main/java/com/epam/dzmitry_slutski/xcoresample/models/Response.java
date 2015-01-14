package com.epam.dzmitry_slutski.xcoresample.models;

import android.content.ContentValues;
import android.provider.BaseColumns;

import com.google.gson.annotations.SerializedName;

import by.istin.android.xcore.annotations.dbEntity;
import by.istin.android.xcore.annotations.dbLong;
import by.istin.android.xcore.db.IDBConnection;
import by.istin.android.xcore.db.entity.IBeforeUpdate;
import by.istin.android.xcore.db.entity.IGenerateID;
import by.istin.android.xcore.db.impl.DBHelper;
import by.istin.android.xcore.source.DataSourceRequest;
import by.istin.android.xcore.utils.HashUtils;

/**
 * Response
 * Version info
 * 13.01.2015
 * Created by Dzmitry_Slutski.
 */
public class Response implements BaseColumns, IBeforeUpdate, IGenerateID {

    @dbLong
    public static final String ID = _ID;

    @dbEntity(clazz = Counter.class)
    @SerializedName(value = "response")
    public static final String RESPONSE = "response";

    @Override
    public void onBeforeUpdate(DBHelper dbHelper, IDBConnection db, DataSourceRequest dataSourceRequest, ContentValues contentValues) {
        contentValues.put(ID, HashUtils.generateId(contentValues));
    }

    @Override
    public long generateId(DBHelper dbHelper, IDBConnection db, DataSourceRequest dataSourceRequest, ContentValues contentValues) {
        return 0;
    }
}
