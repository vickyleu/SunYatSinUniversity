package com.superfactory.sunyatsen.Bean

import com.superfactory.sunyatsen.Bean.BaseBean.MultipartBean

/**
 * Created by vicky on 2018/2/7.
 */
data class ChangePswStruct(val oldPassword: String, val newPassword: String) : MultipartBean()