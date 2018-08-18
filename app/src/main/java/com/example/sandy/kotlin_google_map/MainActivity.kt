package com.example.sandy.kotlin_google_map

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    var lat:Double?=null
    var long:Double?=null

    @SuppressLint("MissingPermission")  //ignore runtime permission
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var lManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager

        lManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,1.toFloat(),
                object : LocationListener {
                    override fun onLocationChanged(p0: Location?) {

                       lat=p0!!.latitude
                       long=p0!!.longitude


                    }

                    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderEnabled(p0: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderDisabled(p0: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }


                })


        //for getting current location

        var frag:SupportMapFragment=supportFragmentManager.findFragmentById(R.id.frag) as SupportMapFragment

        frag.getMapAsync(object : OnMapReadyCallback {
            override fun onMapReady(p0: GoogleMap?) {


                if(lat !=null&&long !=null){

                    var options = MarkerOptions()
                    options.position(LatLng(lat!!, long!!))
                    options.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))
                    options.title("live location")
                    p0!!.addMarker(options)
                    p0!!.animateCamera(CameraUpdateFactory.newLatLngZoom(
                            LatLng(lat!!,long!!), 15f))



                }else {
                    var options = MarkerOptions()
                    options.position(LatLng(17.4406571, 78.4499841))
                    options.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))
                    options.title("live location")
                    p0!!.addMarker(options)
                    p0!!.animateCamera(CameraUpdateFactory.newLatLngZoom(
                            LatLng(17.4406571, 78.4499841), 15f))
                }

            }


        })

    }
}
