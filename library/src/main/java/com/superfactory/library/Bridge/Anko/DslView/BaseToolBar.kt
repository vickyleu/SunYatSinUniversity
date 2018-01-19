package com.superfactory.library.Bridge.Anko.DslView

import android.content.Context
import android.os.Build
import android.support.v7.widget.Toolbar
import android.view.View
import com.superfactory.library.Bridge.Anko.BindingComponent
import com.superfactory.library.Context.BaseActivity
import com.superfactory.library.Context.BaseFragment
import com.superfactory.library.R
import com.superfactory.library.Utils.StatusBarUtil
import org.jetbrains.anko.*


/**
 * Created by vicky on 2018.01.19.
 *
 * @Author vicky
 * @Date 2018年01月19日  15:57:43
 * @ClassName 这里输入你的类名(或用途)
 */
open class BaseToolBar<V, A>(model: V) : BindingComponent<A, V>(model) {
    override fun createViewWithBindings(ui: AnkoContext<A>): View = with(ui) {
        themedToolbar(R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {
            id = R.id.toolbar
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                popupTheme = R.style.ThemeOverlay_AppCompat_Light
            }
            lparams {
                width = matchParent
                height = wrapContent
                topPadding = StatusBarUtil.getStatusBarHeight(ctx)
                backgroundColorResource = R.color.colorPrimary
                minimumHeight = getActionBarSize(ctx)
            }
        }
    }

    fun <V, A : BaseActivity<V, A>> initToolbar(owner: A, toolbar: Toolbar) {
        owner.setSupportActionBar(toolbar);
    }

    fun <V, A : BaseFragment<V, A>> initToolbar(owner: A, toolbar: Toolbar) {
        (owner.activity as BaseActivity<*, *>).setSupportActionBar(toolbar);
    }


    protected fun getActionBarSize(context: Context): Int {
        val attrs = intArrayOf(android.R.attr.actionBarSize)
        val values = context.getTheme().obtainStyledAttributes(attrs)
        try {
            return values.getDimensionPixelSize(0, 0)//第一个参数数组索引，第二个参数 默认值
        } finally {
            values.recycle()
        }
    }
}
