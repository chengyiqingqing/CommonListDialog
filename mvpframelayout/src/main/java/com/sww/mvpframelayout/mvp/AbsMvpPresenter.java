package com.sww.mvpframelayout.mvp;

/**
 * @author ShaoWenWen
 * @date 2019-08-06
 */
public abstract class AbsMvpPresenter<T extends IMvpView> implements IMvpPresenter {

    private T mView;

    public void attachView(T view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }

}
