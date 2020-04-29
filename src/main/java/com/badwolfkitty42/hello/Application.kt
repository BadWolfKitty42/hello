package com.badwolfkitty42.hello

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.time.Clock

class Application(private val commandLineArguments:Array<String>,
                  private val clock:Clock,
                  private val files:FilesContract,
                  private val emitLine:(String)->Unit):Runnable{
    override fun run(){
        val startTime = clock.instant().toEpochMilli()
        val fileName = commandLineArguments[0]
        val path = Paths.get(fileName)
        val charset = StandardCharsets.UTF_8
        val target = files.readString(path, charset)
        val endTime = clock.instant().toEpochMilli()
        val duration = endTime - startTime
        emitLine("Hello, $target!")
        emitLine("took $duration milliseconds")
    }
}