package com.epam.dzmitry_slutski.xcoresample.models;

import android.content.ContentValues;
import android.provider.BaseColumns;

import com.google.gson.annotations.SerializedName;

import by.istin.android.xcore.annotations.dbEntities;
import by.istin.android.xcore.annotations.dbLong;
import by.istin.android.xcore.annotations.dbString;
import by.istin.android.xcore.db.IDBConnection;
import by.istin.android.xcore.db.entity.IBeforeUpdate;
import by.istin.android.xcore.db.entity.IGenerateID;
import by.istin.android.xcore.db.impl.DBHelper;
import by.istin.android.xcore.source.DataSourceRequest;
import by.istin.android.xcore.utils.HashUtils;

/**
 * Counter
 * Version info
 * 13.01.2015
 * Created by Dzmitry_Slutski.
 */
public class Counter implements BaseColumns, IBeforeUpdate, IGenerateID {
    @dbLong
    public static final String ID = _ID;

    @dbString
    @SerializedName(value = "count")
    public static final String COUNT = "count";

    @dbEntities(clazz = SampleEntity.class)
    @SerializedName(value = "items")
    public static final String ITEMS = "items";

    //local
    @dbLong
    public static final String COUNTER_PARENT = DBHelper.getForeignKey(Response.class);


    @Override
    public void onBeforeUpdate(DBHelper dbHelper, IDBConnection db, DataSourceRequest dataSourceRequest, ContentValues contentValues) {
        contentValues.put(ID, HashUtils.generateId(contentValues, COUNT));
    }

    @Override
    public long generateId(DBHelper dbHelper, IDBConnection db, DataSourceRequest dataSourceRequest, ContentValues contentValues) {
        return HashUtils.generateId(contentValues);
    }
}
