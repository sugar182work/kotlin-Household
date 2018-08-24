package jp.ne.sugar182.household1

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.OutputStreamWriter

class InnerStorage {

    fun saveFile(fileName: String, saveData: String, context: Context ) {
        // 全然動かない記述
        // ファイルの書き込み
        /*
        val writeFile = File(fileName)
        writeFile.writeText(saveData)
        */

        // java風に書いてみる
        val file = File(context.filesDir, fileName)
        try {
            val writer : OutputStreamWriter = file.writer()
            writer.write(saveData)
        } catch (e: IOException) {
            Log.d("IOException", e.stackTrace.toString())
        }
    }
}