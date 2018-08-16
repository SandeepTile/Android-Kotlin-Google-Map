package com.example.sandy.kotlin_google_map

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var frag:SupportMapFragment=supportFragmentManager.findFragmentById(R.id.frag) as SupportMapFragment

        frag.getMapAsync(object : OnMapReadyCallback {
            override fun onMapReady(p0: GoogleMap?) {


            }


        })

    }
}
