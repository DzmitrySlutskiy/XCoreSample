package com.epam.dzmitry_slutski.xcoresample.models;

import android.content.ContentValues;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.istin.android.xcore.annotations.db;
import by.istin.android.xcore.annotations.dbEntities;
import by.istin.android.xcore.annotations.dbEntity;
import by.istin.android.xcore.annotations.dbLong;
import by.istin.android.xcore.annotations.dbString;
import by.istin.android.xcore.db.IDBConnection;
import by.istin.android.xcore.db.entity.IBeforeUpdate;
import by.istin.android.xcore.db.entity.IGenerateID;
import by.istin.android.xcore.db.impl.DBHelper;
import by.istin.android.xcore.processor.IOnProceedEntity;
import by.istin.android.xcore.source.DataSourceRequest;
import by.istin.android.xcore.utils.HashUtils;

/**
 * Result
 * Version info
 * 14.01.2015
 * Created by Dzmitry_Slutski.
 */

public class Result implements BaseColumns, IGenerateID, IOnProceedEntity {
    @Override
    public long generateId(DBHelper dbHelper, IDBConnection db, DataSourceRequest dataSourceRequest, ContentValues contentValues) {
        return HashUtils.generateId(contentValues);
    }

    @Override
    public boolean onProceedEntity(DBHelper dbHelper, IDBConnection db, DataSourceRequest dataSourceRequest, @Nullable ContentValues parent, ContentValues contentValues, int position, JsonElement jsonElement) {
        Log.d("Result","position: "+position);
        return false;
    }


    public static class Response {

        @db()
        @SerializedName(value = "items")
        List<Item> items;
    }

    @dbEntity(clazz = Response.class)
    @SerializedName(value = "response")
    public Response response;

//    @dbLong
//    public static final String ID = _ID;
//
    public class Item implements BaseColumns, IBeforeUpdate, IGenerateID {

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
            Log.d("Entity", "onBeforeUpdate");
            contentValues.put(FULL_NAME, contentValues.getAsString(FIRST_NAME) + " " + contentValues.getAsString(LAST_NAME));
        }

        @Override
        public long generateId(DBHelper dbHelper, IDBConnection db, DataSourceRequest dataSourceRequest, ContentValues contentValues) {
            long result = HashUtils.generateId(contentValues);
            Log.d("Entity", "generateId: " + result);
            return result;
        }
    }
}
