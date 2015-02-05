package com.epam.dzmitry_slutski.xcoresample.provider;

import android.content.Context;

import com.epam.dzmitry_slutski.xcoresample.models.Counter;
import com.epam.dzmitry_slutski.xcoresample.models.Entity;
import com.epam.dzmitry_slutski.xcoresample.models.Response;
import com.epam.dzmitry_slutski.xcoresample.models.Result;
import com.epam.dzmitry_slutski.xcoresample.models.SampleEntity;

import by.istin.android.xcore.provider.DBContentProvider;
import by.istin.android.xcore.provider.IDBContentProviderSupport;
import by.istin.android.xcore.provider.impl.DBContentProviderFactory;

/**
 * ModelContentProvider
 * Version info
 * 13.01.2015
 * Created by Dzmitry_Slutski.
 */
public class ModelContentProvider extends DBContentProvider {

    private static final Class<?>[] ENTITIES = new Class<?>[]{
            Result.class,
            Result.Response.class,
            Result.Item.class
//            Response.class,
//            Counter.class
    };

    @Override
    public Class<?>[] getEntities() {
        return ENTITIES;
    }

    public static IDBContentProviderSupport getDBContentProviderSupport(Context context) {
        return DBContentProviderFactory.getDefaultDBContentProvider(context, ENTITIES);
    }
}
