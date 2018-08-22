package jp.ne.sugar182.household1

import java.io.File

class InnerStorage {

    fun saveFile(fileName: String, saveData: String ) {
        // 全然動かない記述
        // ファイルの書き込み
        val writeFile = File(fileName)
        writeFile.writeText(saveData)
    }
}