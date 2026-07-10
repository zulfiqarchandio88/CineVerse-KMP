package com.zulfiqar.cineverse.core.platform

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual object UrlLauncher {
    actual fun openUrl(url: String) {

        NSURL.URLWithString(url)?.let {
            UIApplication.sharedApplication.openURL(it)
        }
    }
}