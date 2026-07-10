package com.zulfiqar.cineverse.core.platform

import android.content.Context
import android.content.Intent
import android.net.Uri

actual object UrlLauncher {

    lateinit var context: Context

    actual fun openUrl(url: String) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}