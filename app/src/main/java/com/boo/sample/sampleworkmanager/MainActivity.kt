package com.boo.sample.sampleworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager = WorkManager.getInstance(this)
        startWorkRequests(workManager)
    }

    fun startWorkRequests(workManager: WorkManager) {
        workManager.cancelAllWork()
//        OneTimeWorkRequest(workManager)
        PeriodicWorkRequest(15, workManager)
    }

    fun OneTimeWorkRequest(workManager: WorkManager) {
        val workRequest = OneTimeWorkRequestBuilder<MyWorker>().build()
        workManager.enqueue(workRequest)
    }

    fun PeriodicWorkRequest(period: Long, workManager: WorkManager) {
        val workRequest = PeriodicWorkRequestBuilder<MyWorker>(period, TimeUnit.MINUTES).build()
        workManager.enqueue(workRequest)
    }

    fun OneTimeCoroutineWorkRequest(workManager: WorkManager) {
        val workRequest = OneTimeWorkRequestBuilder<MyCoroutineWorker>().build()
        workManager.enqueue(workRequest)
    }

    fun PeriodicCoroutineWorkRequest(period: Long, workManager: WorkManager) {
        val workRequest = PeriodicWorkRequestBuilder<MyCoroutineWorker>(period, TimeUnit.MINUTES).build()
        workManager.enqueue(workRequest)
    }
}