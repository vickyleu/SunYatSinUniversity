package com.superfactory.sunyatsin.Bean

import com.superfactory.sunyatsin.Bean.BaseBean.MultipartBean

/**
 * Created by vicky on 2018.02.04.
 *
 * @Author vicky
 * @Date 2018年02月04日  14:44:45
 * @ClassName 这里输入你的类名(或用途)
 */
data class LoginBean(val oldPassword: String, val newPassword: String) : MultipartBean()