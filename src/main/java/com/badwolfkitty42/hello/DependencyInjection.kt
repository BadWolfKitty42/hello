package com.badwolfkitty42.hello

import java.time.Clock

class DependencyInjection(commandLineArguments:Array<String>) {
    val clock:Clock = Clock.systemDefaultZone()
    val files: FilesContract = FilesFromOperatingSystem()
    val emitLine:(String)->Unit = ::println
    val runner:Runnable = Application(commandLineArguments , clock,files, emitLine)
}