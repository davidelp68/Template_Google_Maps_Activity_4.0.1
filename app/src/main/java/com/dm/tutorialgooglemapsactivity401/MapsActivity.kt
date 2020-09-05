package com.dm.tutorialgooglemapsactivity401

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Ottieni SupportMapFragment e ricevi una notifica quando la mappa è pronta per essere utilizzata.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipola la mappa una volta disponibile.
     * Questo callback viene attivato quando la mappa è pronta per essere utilizzata.
     * Qui è possibile aggiungere marcatori o linee, aggiungere ascoltatori o spostare la videocamera. In questo caso,
     * aggiungiamo solo un marker vicino a Sydney, in Australia.
     * Se i servizi di Google Play non sono installati sul dispositivo, all'utente verrà richiesto di installare
     * all'interno del SupportMapFragment. Questo metodo verrà attivato solo una volta che l'utente ha
     * installato i servizi di Google Play e restituito all'app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Aggiungi un pennarello a Sydney e sposta la fotocamera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Segnaposto: Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
