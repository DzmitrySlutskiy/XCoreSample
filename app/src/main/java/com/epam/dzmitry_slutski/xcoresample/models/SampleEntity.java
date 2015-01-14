package com.epam.dzmitry_slutski.xcoresample.models;

import android.content.ContentValues;
import android.provider.BaseColumns;

import com.google.gson.annotations.SerializedName;

import by.istin.android.xcore.annotations.dbLong;
import by.istin.android.xcore.annotations.dbString;
import by.istin.android.xcore.db.IDBConnection;
import by.istin.android.xcore.db.entity.IBeforeUpdate;
import by.istin.android.xcore.db.entity.IGenerateID;
import by.istin.android.xcore.db.impl.DBHelper;
import by.istin.android.xcore.source.DataSourceRequest;
import by.istin.android.xcore.utils.HashUtils;

/**
 * SampleEntity
 * Version info
 * 13.01.2015
 * Created by Dzmitry_Slutski.
 */
public class SampleEntity implements BaseColumns, IBeforeUpdate, IGenerateID {
    @dbLong
    public static final String SAMPLE_ENTITY_PARENT = DBHelper.getForeignKey(Counter.class);

    @dbLong
    @SerializedName(value = "id")
    public static final String ID = _ID;

    @dbString
    @SerializedName(value = "first_name")
    public static final String FIRST_NAME = "first_name";

    @dbString
    @SerializedName(value = "last_name")
    public static final String LAST_NAME = "last_name";

    @dbString
    public static final String FULL_NAME = "full_name";

    @dbString
    @SerializedName(value = "bdate")
    public static final String BIRTH_DATE = "bdate";

    @dbString
    @SerializedName("photo_200_orig")
    public static final String PHOTO = "photo_200_orig";

    @dbString
    @SerializedName("city:title")
    public static final String CITY = "city";

    @Override
    public void onBeforeUpdate(DBHelper dbHelper, IDBConnection db, DataSourceRequest dataSourceRequest, ContentValues contentValues) {
        contentValues.put(FULL_NAME, contentValues.getAsString(FIRST_NAME) + " " + contentValues.getAsString(LAST_NAME));
    }

    @Override
    public long generateId(DBHelper dbHelper, IDBConnection db, DataSourceRequest dataSourceRequest, ContentValues contentValues) {
        return HashUtils.generateId(contentValues);
    }
}