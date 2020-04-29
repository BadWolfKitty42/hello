package com.badwolfkitty42.hello

import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path

class FilesFromOperatingSystem : FilesContract{
    override fun readString(path: Path, charset: Charset): String = Files.readString(path, charset)
}
