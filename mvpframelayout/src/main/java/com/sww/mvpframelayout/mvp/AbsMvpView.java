package com.sww.mvpframelayout.mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.sww.mvpframelayout.InstanceUtils;

/**
 * @author ShaoWenWen
 * @date 2019-08-06
 */
public class AbsMvpView<T extends AbsMvpPresenter & IMvpPresenter, U extends IMvpPresenter> extends FrameLayout implements IMvpView<U> {

    private U mPresenter;

    public AbsMvpView(@NonNull Context context) {
        super(context);
    }

    public AbsMvpView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void initPresenter() {
        T presenterInstance = InstanceUtils.getInstance(this, InstanceUtils.POSITION_FIRST);
        if (presenterInstance == null) {
            throw new RuntimeException("presenter is null");
        } else if (!(presenterInstance instanceof AbsMvpPresenter)) {
            throw new RuntimeException("Presenter实例需要继承BasePresenter");
        } else if (!(presenterInstance instanceof IMvpPresenter)) {
            throw new RuntimeException("Presenter实例需要实现MvpPresenter");
        }
         mPresenter = (U) presenterInstance;
        presenterInstance.attachView(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPresenter != null) ((AbsMvpPresenter) mPresenter).detachView();
    }
}
