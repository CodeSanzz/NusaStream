
package com.LayarKacaProvider

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class LayarKacaPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(LayarKacaProvider())
        registerExtractorAPI(Lk21TurboExtractor())
        registerExtractorAPI(PlayCdnP2PExtractor())
        registerExtractorAPI(HowNetworkExtractor())
        registerExtractorAPI(CastExtractor())
        registerExtractorAPI(AbyssExtractor())
    }
}
