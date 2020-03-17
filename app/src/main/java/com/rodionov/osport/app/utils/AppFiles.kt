package com.rodionov.osport.app.utils

import android.content.Context
import android.media.MediaScannerConnection
import android.net.Uri
import android.util.Log
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

object AppFiles {

    private fun writeToFile(inputStream: InputStream, file: File) {
        try {
            val outputStream = FileOutputStream(file)
            val buffer = ByteArray(1024)
            var length: Int = inputStream.read(buffer)
            while (length > 0) {
                outputStream.write(buffer, 0, length)
                length = inputStream.read(buffer)
            }
            outputStream.close()
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws(IOException::class)
    private fun copyFile(src: File, dst: File) {
        val inputStream = FileInputStream(src)
        writeToFile(inputStream, dst)
    }

    suspend fun copyFilesOnExternalStorage(
        context: Context,
        folderName: String,
        filesToCopy: List<File>
    ) = coroutineScope {
        val copiedFiles = ArrayList<File>()
        var i = 1
        for (fileToCopy in filesToCopy) {
            val dstDir = File(
                context.externalMediaDirs.firstOrNull(),
                folderName
            )
            if (!dstDir.exists()) dstDir.mkdirs()

            val filenameSplit =
                fileToCopy.name.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray()
            val extension = "." + filenameSplit[filenameSplit.size - 1]
            val datePart = SimpleDateFormat(
                "yyyyMMdd_HHmmss",
                Locale.getDefault()
            ).format(Calendar.getInstance().time)
            val filename = "DCIM_${datePart}_$i$extension"
            val dstFile = File(dstDir, filename)
            try {
                dstFile.createNewFile()
                copyFile(fileToCopy, dstFile)
                copiedFiles.add(dstFile)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            i++
        }
        scanCopiedImages(context, copiedFiles)
    }

    suspend fun copyFilesOnCache(
        context: Context,
        folderName: String,
        pathsFileToCopy: List<String>
    ) = coroutineScope {

        val deferreds = mutableListOf<Deferred<Pair<String, String>>>()

        pathsFileToCopy.forEachIndexed { index, pathFileToCopy ->
            val deferred = async {
                val originalFile = File(pathFileToCopy)
                val dstDir = File(context.cacheDir, folderName)

                if (!dstDir.exists()) dstDir.mkdirs()

                val filenameSplit =
                    originalFile.name.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()
                val extension = "." + filenameSplit[filenameSplit.size - 1]
                val datePart = SimpleDateFormat(
                    "yyyyMMdd_HHmmss",
                    Locale.getDefault()
                ).format(Calendar.getInstance().time)
                val filename = "DCIM_${datePart}_$index$extension"
                val dstFile = File(dstDir, filename)
                try {
                    dstFile.createNewFile()
                    copyFile(originalFile, dstFile)
                    return@async pathFileToCopy to dstFile.path
                } catch (e: IOException) {
                    e.printStackTrace()
                    return@async "" to ""
                }
            }
            deferreds.add(deferred)
        }
        deferreds.awaitAll()
    }

    private fun scanCopiedImages(context: Context, copiedImages: List<File>) {
        val paths = arrayOfNulls<String>(copiedImages.size)
        for (i in copiedImages.indices) {
            paths[i] = copiedImages[i].toString()
        }

        MediaScannerConnection.scanFile(context,
            paths, null,
            object : MediaScannerConnection.OnScanCompletedListener {
                override fun onScanCompleted(path: String, uri: Uri) {
                    Log.d(javaClass.simpleName, "Scanned $path:")
                    Log.d(javaClass.simpleName, "-> uri=$uri")
                }
            })
    }
}