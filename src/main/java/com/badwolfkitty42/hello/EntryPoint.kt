package com.badwolfkitty42.hello

object EntryPoint {
    @JvmStatic
    fun main(args: Array<String>) {
        DependencyInjection(args).runner.run()
    }
}