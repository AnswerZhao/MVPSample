package me.zwdroid.mvpsample.base;

/**
 * Author: zhaowenda
 * Email:  zwdroid@gmail.com
 * Date:   16/10/15 下午12:15
 *
 */

public interface BaseView<T> {
    // 关联Presenter
    void setPresenter(T presenter);
}
