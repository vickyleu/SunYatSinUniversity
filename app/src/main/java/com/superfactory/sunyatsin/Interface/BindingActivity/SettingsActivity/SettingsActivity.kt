package com.superfactory.sunyatsin.Interface.BindingActivity.SettingsActivity

import android.graphics.Color
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import com.superfactory.library.Bridge.Adapt.startActivityForResult
import com.superfactory.library.Communication.Sender.senderAsync
import com.superfactory.library.Context.BaseToolBarActivity
import com.superfactory.library.Context.Extensions.takeApi
import com.superfactory.library.Debuger
import com.superfactory.library.Graphics.KDialog.CircleDialog
import com.superfactory.library.Graphics.KDialog.callback.ConfigButton
import com.superfactory.library.Graphics.KDialog.callback.Interrupter
import com.superfactory.library.Graphics.KDialog.params.ButtonParams
import com.superfactory.library.Utils.ConfigXmlAccessor
import com.superfactory.library.Utils.SizeConverter
import com.superfactory.sunyatsin.Communication.RetrofitImpl
import com.superfactory.sunyatsin.Interface.BindingActivity.AccountActivity.AccountActivity
import com.superfactory.sunyatsin.Interface.BindingActivity.PasswordActivity.PasswordActivity
import com.superfactory.sunyatsin.Struct.Const
import com.superfactory.sunyatsin.Struct.Login.LoginStruct


/**
 * Created by vicky on 2018.01.31.
 *
 * @Author vicky
 * @Date 2018年01月31日  17:19:54
 * @ClassName 这里输入你的类名(或用途)
 */
class SettingsActivity : BaseToolBarActivity<SettingsActivityViewModel, SettingsActivity>() {
    override fun newViewModel() = SettingsActivityViewModel()

    override fun newComponent(v: SettingsActivityViewModel) = SettingsActivityComponent(v).apply {
        viewModelSafe.ownerNotifier = { _, any ->
            if (any == null) {
                Debuger.printMsg(this, "数据不能为空啊")
            } else {
                Debuger.printMsg("simpleName", "987654311212121" + any.javaClass.simpleName)
                startActivityForResult<PasswordActivity>(101, { intent ->

                })
            }
        }
    }

    override fun onLoadedModel(viewModel: SettingsActivityViewModel) {
        viewModel.cacheSize.value = SizeConverter.B.convert(10f)
        viewModel.version.value = "v" + getVerName()
        viewModel.onItemClicked = { idx, model ->
            when (idx) {
                0/*个人资料*/ -> {
                    startActivityForResult<AccountActivity>(101, { intent ->

                    })
                }
                1/*密码修改*/ -> {

                }
                2/*清除缓存*/ -> {

                }
                3/*版本说明*/ -> {

                }

            }
        }
    }
}