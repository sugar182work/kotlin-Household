package jp.ne.sugar182.household1.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.util.Log
import java.io.IOException

class InnerStorage(private val fileName: String, private val context: Context) {

    // 内部ストレージへの書き込み
    fun saveFile(saveData: String) {
        // 全然動かない記述 おそらくパスを指定する必要あり。/data/data/hogehoge? Contextから取得
        // ファイルの書き込み
        /*
        val writeFile = File(fileName)
        writeFile.writeText(saveData)
        */

        // java風に書いてみる
        try {
            val fileOutputStream = context.openFileOutput(fileName, Context.MODE_APPEND)
            fileOutputStream.write(saveData.toByteArray())
            fileOutputStream.write("\n".toByteArray())
            fileOutputStream.close()
        } catch (e: IOException) {
            Log.d("IOException", e.stackTrace.toString())
        }
    }
    // 内部ストレージからの読み込み contextを使用してみる
    fun readFile(): ArrayList<String> {
        var datas = arrayListOf<String>()

        try {

            val fileInputStream = context.openFileInput(fileName)
            val reader = fileInputStream.bufferedReader()
            for (lineBuffer in reader.readLines()) {
                Log.d("readLine:", lineBuffer)
                datas.add(lineBuffer)
            }
            reader.close()
            fileInputStream.close()
        } catch (e: IOException) {
            Log.d("IOException", e.stackTrace.toString())
        }
        return datas
    }

}