package com.epam.dzmitry_slutski.xcoresample.ui.activities;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.epam.dzmitry_slutski.xcoresample.R;
import com.epam.dzmitry_slutski.xcoresample.models.SampleEntity;
import com.epam.dzmitry_slutski.xcoresample.processors.SampleEntityProcessor;

import by.istin.android.xcore.fragment.XListFragment;
import by.istin.android.xcore.provider.ModelContract;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, createFragment())
                    .commit();
        }
    }

    protected Fragment createFragment() {
        return new SampleListFragment();
    }

    public static class SampleListFragment extends XListFragment {

        //        private static final String PAGE1 = "https://dl.dropboxusercontent.com/u/30468926/friendserror.get";
        private static final String PAGE1 = "https://dl.dropboxusercontent.com/u/30468926/friends.get";

        @Override
        public void onListItemClick(Cursor cursor, View view, int i, long l) {

        }

        @Override
        public int getViewLayout() {
            return R.layout.fragment_main;
        }

        @Override
        public Uri getUri() {
            return ModelContract.getUri(SampleEntity.class);
        }

        @Override
        public String getUrl() {
            return PAGE1;
        }

        @Override
        protected void onPageLoad(int newPage, int totalItemCount) {
            loadData(getActivity(), PAGE1, PAGE1);
        }

        @Override
        protected boolean isPagingSupport() {
            return true;
        }

        @Override
        public String getProcessorKey() {
            return SampleEntityProcessor.APP_SERVICE_KEY;
        }

        @Override
        public String[] getAdapterColumns() {
            return new String[]{SampleEntity.ID, SampleEntity.FULL_NAME,
                    SampleEntity.BIRTH_DATE, SampleEntity.PHOTO, SampleEntity.CITY};
        }

        @Override
        public int[] getAdapterControlIds() {
            return new int[]{R.id.title, R.id.name, R.id.bdate, R.id.thumbnail
                    , R.id.city};
        }

        @Override
        public int getAdapterLayout() {
            return R.layout.adapter_sample_entity;
        }

        @Override
        public long getCacheExpiration() {
            return 1l;
        }
    }
}
