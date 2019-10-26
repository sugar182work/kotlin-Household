package jp.ne.sugar182.household1
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import java.util.Calendar

// デートピッカーjavaをそのままコトリン化
class DatePick : DialogFragment(), DatePickerDialog.OnDateSetListener {
    // TODO スレッドセーフ意識していない
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // デートピッカーの表示
        return DatePickerDialog(
                activity,
                activity as MainActivity?,
                year,
                month,
                day)
    }

    // TODO Main側に実装しているが、ここにも宣言する必要ありなので空メソッドを記載 Java記載では一か所で済んだ？のちほど検証
    override fun onDateSet(view: android.widget.DatePicker, year: Int,
                           monthOfYear: Int, dayOfMonth: Int) {
    }

}