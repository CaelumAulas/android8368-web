package br.com.caelum.twittelumappweb

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices

class GPS(context: Context) : LocationCallback() {
    private var lastLocation: Location? = null
    private val client = LocationServices.getFusedLocationProviderClient(context)


    @SuppressLint("MissingPermission")
    fun fazRequisicao() {
        val request = LocationRequest()

        request.interval = 1000
        request.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        client.requestLocationUpdates(request,this, null)
    }

    fun cancela() {
        client.removeLocationUpdates(this)
    }

    override fun onLocationResult(location: LocationResult?) {
        lastLocation = location?.lastLocation
    }

    fun getCoordenadas(): Pair<Double, Double> {
        val latitude = lastLocation?.latitude
        val longitude = lastLocation?.longitude
        return Pair(latitude?: 0.0, longitude?: 0.0)
    }
}