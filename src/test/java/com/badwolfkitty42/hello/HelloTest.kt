package com.badwolfkitty42.hello

import org.junit.jupiter.api.Test
import java.nio.charset.Charset
import java.nio.file.Path
import java.time.Clock
import java.time.Instant
import java.time.ZoneId
import kotlin.test.assertEquals

class HelloTest {
    @Test
    fun testSayHello() {
        // given
        val commandLineArguments = arrayOf("my-file.txt")
        val expected = listOf(
            "Hello, world!",
            "took 123 milliseconds"
        )
        val console = ConsoleStub()
        val clock = ClockStub(1000L, 1123L)
        val fileContentsMap = mapOf(
            "my-file.txt" to "world"
        )
        val files = FilesStub(fileContentsMap)
        val application = Application(
            commandLineArguments,
            clock,
            files,
            console
        )

        // when
        application.run()

        // then
        val actual = console.lines
        assertEquals(expected, actual)
    }

    class ConsoleStub :(String)->Unit{
        val lines = mutableListOf<String>()
        override fun invoke(line: String) {
            lines.add(line)
        }
    }

    class ClockStub(vararg val times:Long): Clock() {
        var timeIndex = 0
        override fun withZone(zone: ZoneId?): Clock {
            TODO("Not yet implemented")
        }

        override fun getZone(): ZoneId {
            TODO("Not yet implemented")
        }

        override fun instant(): Instant {
            return Instant.ofEpochMilli(times[timeIndex++])
        }
    }

    class FilesStub(private val fileContentsMap:Map<String, String>):FilesContract{
        override fun readString(path: Path, charset: Charset):String {
            return fileContentsMap.getValue(path.toString())
        }
    }
}