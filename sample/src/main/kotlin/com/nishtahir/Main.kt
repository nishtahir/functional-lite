package com.nishtahir

import com.nishtahir.functional.Result
import java.io.FileNotFoundException
import java.io.IOException
import java.net.URL

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = Main().readFileFromResources("sample.txt")
            when (result) {
                is Result.Ok -> println(result.value)
                is Result.Error -> result.error.printStackTrace()
            }
        }
    }

    fun readFileFromResources(fileName: String): Result<String, IOException> {
        return try {
            val path: URL = this.javaClass.classLoader.getResource(fileName) ?: throw FileNotFoundException()
            Result.ok(path.readText())
        } catch (e: IOException) {
            Result.error(e)
        }
    }

}
