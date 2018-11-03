package com.ani.mytest.loader;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.ani.mytest.loader.dao.BaseDao;


public class MyLoader<T> extends AsyncTaskLoader<T> {
    private BaseDao<T> baseDao;
    public MyLoader(Context context,BaseDao baseDao) {
        super(context);
        this.baseDao=baseDao;
        onContentChanged();
    }


    @Nullable
    @Override
    public T loadInBackground() {
        return this.baseDao.getDataFromUrl();
    }

    @Override
    public void deliverResult(T data) {
        super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged()) {
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
    }
}
