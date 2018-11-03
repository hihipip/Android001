package com.ani.mytest.loader;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.ani.mytest.R;
import com.ani.mytest.loader.dao.BaseDao;
import com.ani.mytest.loader.dao.LoginDao;

/**
 * Created by ghost on 2018/11/3.
 */

public abstract class BaseActivity<T> extends AppCompatActivity implements LoaderManager.LoaderCallbacks<T>  {

    private ProgressBar progressBar;
    protected BaseDao baseDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initContent();
    }


    /**
     * 利用Loader處理耗時的工作
     */
    public void DoSync(BaseDao... params) {

        if (params.length != 0) {
            for (int i = 0; i < params.length; i++) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Data", params[i]);
                getSupportLoaderManager().restartLoader(i, bundle, this);
            }
        }
    }



    @Override
    public Loader<T> onCreateLoader(int id, Bundle args) {
        return new MyLoader(this,(BaseDao)args.getSerializable("Data"));
    }

    @Override
    public void onLoadFinished(Loader<T> loader, T data) {
        LoaderResult(data);
    }

    @Override
    public void onLoaderReset(Loader<T> loader) {

    }

    abstract public void initView();
    abstract public void initContent();
    abstract public void LoaderResult(T data);
}


