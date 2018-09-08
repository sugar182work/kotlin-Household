package jp.ne.sugar182.household1.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class DateUtilEx {

    // 現在時刻を YYYY/MM/DD形式で返す
    fun getNowString() : String {
        val now = SimpleDateFormat("yyyy/MM/dd").format(Date())
        return now
    }
    // 現在時刻を YYYY/MM/DD形式で返す
    fun getNowMonthString() : String {
        val month = SimpleDateFormat("yyyy/MM").format(Date())
        return month
    }

    fun nextMonth(month: String): String {
        var y = month.substring(0, 4).toInt()
        var m = month.substring(5, 7).toInt()
        if (m + 1 > 12) {
            y = y + 1
            m = 1
        } else {m = m + 1}
        Log.d("month",String.format("%04d", y) + "/" + String.format("%02d", m))
        return String.format("%04d", y) + "/" + String.format("%02d", m)
    }


    fun preMonth(month: String): String {
        var y = month.substring(0, 4).toInt()
        Log.d("y", y.toString())
        var m = month.substring(5, 7).toInt()
        Log.d("m", m.toString())
        if (m - 1 < 1) {
            y = y -1
            m = 12
        } else {m = m - 1}
        Log.d("month",String.format("%04d", y) + "/" + String.format("%02d", m))
        return String.format("%04d", y) + "/" + String.format("%02d", m)
    }
}