package com.boo.sample.sampleworkmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams){
    val TAG = this::class.java.simpleName

    override fun doWork(): Result {
        Log.e(TAG, "doWork: Hello!")
        return Result.success()
    }
}