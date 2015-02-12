package com.ci.general.facebookmanager;

/**
 * Created by Alex on 2/7/15.
 */
public interface GenericCallback<A, B, C> {
    public void onStart(A a);
    public void onProgress(B b);
    public void onEnd(C... c);
}
