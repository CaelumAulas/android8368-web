package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.ViewModelProviders
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaFragment : SupportMapFragment(), OnMapReadyCallback {
    private val tweetViewModel: TweetViewModel by lazy {
        ViewModelProviders.of(activity!!, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val lista = tweetViewModel.tweets().value

        lista?.forEach { tweet ->

            val markerOptions = MarkerOptions()
            markerOptions.position(LatLng(tweet.latitude, tweet.longitude))
            tweet.dono?.let {
                markerOptions.title(tweet.dono.nome)
            }
            googleMap?.addMarker(markerOptions)

        }
    }
}