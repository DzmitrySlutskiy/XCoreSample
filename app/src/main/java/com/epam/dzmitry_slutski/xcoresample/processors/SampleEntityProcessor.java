package com.epam.dzmitry_slutski.xcoresample.processors;

import android.content.ContentValues;
import android.util.Log;

import com.epam.dzmitry_slutski.xcoresample.models.Counter;
import com.epam.dzmitry_slutski.xcoresample.models.Response;
import com.epam.dzmitry_slutski.xcoresample.models.SampleEntity;

import by.istin.android.xcore.ContextHolder;
import by.istin.android.xcore.db.IDBConnection;
import by.istin.android.xcore.processor.impl.AbstractGsonBatchProcessor;
import by.istin.android.xcore.provider.IDBContentProviderSupport;
import by.istin.android.xcore.source.DataSourceRequest;

/**
 * SampleEntityProcessor
 * Version info
 * 13.01.2015
 * Created by Dzmitry_Slutski.
 */
public class SampleEntityProcessor extends AbstractGsonBatchProcessor<ContentValues> {

    public static final String APP_SERVICE_KEY = "core:sampleentity:processor";

    public SampleEntityProcessor(IDBContentProviderSupport contentProviderSupport) {
        super(Response.class, ContentValues.class, contentProviderSupport);
    }

    @Override
    public String getAppServiceKey() {
        return APP_SERVICE_KEY;
    }

    @Override
    protected void onStartProcessing(DataSourceRequest dataSourceRequest, IDBConnection dbConnection) {
        Log.d(APP_SERVICE_KEY, "onStartProcessing");
//        if (dataSourceRequest.getParam("page").equals("1")) {
//        getHolderContext().getContentResolver().delete(ModelContract.getUri(SampleEntity.class), null, null);
//        getHolderContext().getContentResolver().delete(ModelContract.getUri(Counter.class), null, null);
//        getHolderContext().getContentResolver().delete(ModelContract.getUri(Response.class), null, null);

//        dbConnection.delete(DBHelper.getTableName(SampleEntity.class), null, null);
//        dbConnection.delete(DBHelper.getTableName(Counter.class), null, null);
//        dbConnection.delete(DBHelper.getTableName(Response.class), null, null);
        super.onStartProcessing(dataSourceRequest, dbConnection);
//        }
    }

    @Override
    protected void onProcessingFinish(DataSourceRequest dataSourceRequest, ContentValues contentValueses) throws Exception {
        super.onProcessingFinish(dataSourceRequest, contentValueses);
        Log.d(APP_SERVICE_KEY, "onProcessingFinish");
        notifyChange(ContextHolder.get(), Response.class);
        notifyChange(ContextHolder.get(), Counter.class);
        notifyChange(ContextHolder.get(), SampleEntity.class);
    }
}