package com.nhom3.appdulich.utils

import android.app.Dialog
import android.app.NotificationManager
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.nhom3.appdulich.R
import dagger.hilt.android.qualifiers.ApplicationContext
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Helpers @Inject constructor(
    @ApplicationContext private val _context : Context,
    private val _notification : Notification
){
    private var _dialogLoading : Dialog? = null

    fun showAlertDialog(title : String, msg: String) {
        androidx.appcompat.app.AlertDialog.Builder(_context).apply {
            setTitle(title)
            setMessage(msg)
            setIcon(R.mipmap.ic_launcher)
            setPositiveButton(R.string.btn_ok) { dialog, _ -> dialog.cancel() }
            setCancelable(false)
            show()
        }
    }


    fun showProgressLoading() {
        if (_dialogLoading?.isShowing == true) {
            _dialogLoading?.dismiss()
            _dialogLoading = null
        }
        _dialogLoading = Dialog(_context).apply {
            setContentView(R.layout.progress)
            setCancelable(false)
            show()
        }
    }

    fun dismissProgress() {
        if (_dialogLoading?.isShowing == true) {
            _dialogLoading?.dismiss()
        }
    }

    fun isNetworkConnected(): Boolean {
        val cm = _context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.isDefaultNetworkActive
    }

    fun showToast(message: String?) {
        Toast.makeText(_context, message, Toast.LENGTH_SHORT).show()
    }

    fun roundOffDecimal(number: Double): Double {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.FLOOR
        return df.format(number).replace(",",".").toDouble()
    }

    fun showNotification(str : String) {
        val manager = _context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(Const.ID_NOTIFICATION, _notification.createNotification(str))
    }
}