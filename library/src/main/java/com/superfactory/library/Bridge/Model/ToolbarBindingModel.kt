package com.superfactory.library.Bridge.Model

import android.view.View
import com.superfactory.library.Bridge.Anko.BaseObservable
import com.superfactory.library.Bridge.Anko.ObservableFieldImpl
import com.superfactory.library.Bridge.Anko.observable
import com.superfactory.library.Bridge.Anko.observableNullable
import kotlin.reflect.full.memberProperties

/**
 * Created by vicky on 2018/1/19.
 */
abstract class ToolbarBindingModel : BaseObservable() {
    val displayNavigator = observable(false)
    val title = observable("")
    val navigationIcon = observable(Any())
    val backgroundColor = observable(1)
    val titleColor = observable(0)
    val titleSize = observable(0)
    val navigationText = observable("")
    val navigationTextSize = observable(0)
    val navigationTextColor = observable(0)
    val leftPadding = observable(0)
    val rightPadding = observable(0)
    val rightIcon = observable(Any())
    val rightText = observable("")
    val rightTextSize = observable(0)
    val rightTextColor = observable(0)
    val rightView = observableNullable<View?>(null)

    init {
        apply {
            setToolbar(this@ToolbarBindingModel)
        }
    }

    abstract fun setToolbar(toolbarBindingModel: ToolbarBindingModel)

    companion object {
        fun <Value, Input> toModel(any: Value, input: Input, model: ToolbarBindingModel): ObservableFieldImpl<Value>? {
            var field: ObservableFieldImpl<Value>? = null
            val memberProperties = ToolbarBindingModel::class.memberProperties
            memberProperties.forEach {
                if (it.equals(input)) {
                    field = it.get(model) as ObservableFieldImpl<Value>
                    return field
                }
            }
            return field
        }
    }

}