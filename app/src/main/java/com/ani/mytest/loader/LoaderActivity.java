package com.ani.mytest.loader;

import android.util.Log;

import com.ani.mytest.R;
import com.ani.mytest.loader.dao.LoginDao;
import com.ani.mytest.loader.dao.MemberDao;
import com.ani.mytest.loader.pojo.Login;
import com.ani.mytest.loader.pojo.Member;

public class LoaderActivity<T> extends BaseActivity<T> {




    @Override
    public void initView(){
        setContentView(R.layout.activity_loader);

    }
    @Override
    public void initContent(){
        //this.baseDao = new LoginDao(this);
        //DoSync(this.baseDao);
        DoSync(new LoginDao(this),new MemberDao(this));
    }
    @Override
    public void LoaderResult(T data){
        if( data instanceof Login) {
            Log.e("TEST", "HttpCode =" + ((Login) data).getHttp_code());
            Log.e("TEST", "Login =" + data);
        }
        else if( data instanceof Member) {
            Log.e("TEST", "Member =" + data);
        } else {
            Log.e("TEST", "error data=" + data);
        }
    }

}
