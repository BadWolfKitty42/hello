package com.badwolfkitty42.hello

import java.nio.charset.Charset
import java.nio.file.Path

interface FilesContract {
    fun readString(path: Path, charset: Charset):String
}