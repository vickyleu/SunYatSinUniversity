package com.superfactory.library.Context

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.superfactory.library.Bridge.Anko.Adapt.BaseAnko
import com.superfactory.library.Bridge.Anko.BindingComponent
import com.superfactory.library.Bridge.Anko.DslView.BaseToolBar
import com.superfactory.library.Debuger
import org.jetbrains.anko.AnkoContextImpl

/**
 * Created by vicky on 2018.01.18.
 *
 * @Author vicky
 * @Date 2018年01月18日  11:11:39
 * @ClassName 这里输入你的类名(或用途)
 */
abstract class BaseFragment<V, A : BaseFragment<V, A>> : Fragment(), BaseAnko<V, A> {
    protected var toolbar: BaseToolBar<A, V>? = null
    protected var toobarAnko: View? = null

    private var layout: BindingComponent<A, V>? = null
    var viewModel: V? = null

    protected var showToolBar: Boolean = false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        var view: View? = null
//        viewModel = newViewModel().apply {
//            layout = newComponent(this).apply {
//                view = createView(AnkoContextImpl(this@BaseFragment.context, this@BaseFragment as A, false))
//                notifyChanges()
//            }
//        }
//        if (view == null) {
//            throw RuntimeException(javaClass.simpleName + "创建view为空")
//        }


        var view: View? = null
        viewModel = newViewModel().apply {
            if (showToolBar) {
                val tc = newToolBarComponent(this)
                if (tc != null) {
                    toolbar = tc.apply {
                        toobarAnko = createView(AnkoContextImpl(this@BaseFragment.context, this@BaseFragment as A, false))
                        notifyChanges()
                    } as BaseToolBar<A, V>
                }
            }
            layout = newComponent(this).apply {
                if (toobarAnko != null) {
                    Debuger.printMsg(this,"妈卖批")
                    view = createView(
                            AnkoContextImpl(this@BaseFragment.context, this@BaseFragment as A, false),
                            toobarAnko,
                            this@BaseFragment.context,
                            this@BaseFragment
                    )
                    if (toobarAnko is Toolbar && toolbar != null) {
                        toolbar!!.initToolbar(this@BaseFragment, toobarAnko!! as Toolbar)
                    }
                } else {
                    view = createView(AnkoContextImpl(this@BaseFragment.context, this@BaseFragment as A, false))
                }
                notifyChanges()
            }
        }
        if (view == null) {
            throw RuntimeException(javaClass.simpleName + "创建view为空")
        }
        return view;
    }

    open fun newToolBarComponent(v: V): BindingComponent<A, V>? {
        return null
    }

    override fun ankoToolBar(viewModel: V): BaseToolBar<V, A>? {
        return null
    }

    abstract fun newViewModel(): V

    abstract fun newComponent(v: V): BindingComponent<A, V>

    override fun onDestroy() {
        super.onDestroy()
        layout?.destroyView()
        layout = null
    }

}