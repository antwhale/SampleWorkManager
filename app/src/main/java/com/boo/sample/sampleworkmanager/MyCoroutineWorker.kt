package com.boo.sample.sampleworkmanager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class MyCoroutineWorker(context: Context, workerParams: WorkerParameters) : CoroutineWorker(context, workerParams) {
    val TAG = this::class.java.simpleName

    override suspend fun doWork(): Result {
        delay(500L)
        Log.e(TAG, "Hello!")
        return Result.success()
    }
}