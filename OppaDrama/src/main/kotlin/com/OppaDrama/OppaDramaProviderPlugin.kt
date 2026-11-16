
package com.OppaDrama

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class OppaDramaPlugin : Plugin() {
    override fun load(context: Context) {
        val ok = runCatching { LocalProxy.start() }.getOrElse { e ->
            LocalProxy.obs("START-THROW", "${e.javaClass.simpleName}: ${e.message}")
            false
        }
        LocalProxy.obs("PLUGIN-LOAD", "started=$ok port=${LocalProxy.port}")

        registerMainAPI(OppaDramaProvider())
    }
}
