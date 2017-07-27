package com.example.android.iseebeer.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.android.iseebeer.R
import com.example.android.iseebeer.adapater.PlaceAdapter
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.Places
import com.google.android.gms.location.places.ui.PlacePicker
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    val LOG_TAG: String = "MainActivity"
    val GOOGLE_API_CLIENT_ID: Int = 1
    val PLACE_PICKER_REQUEST: Int = 1001

    @Inject


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val googleClient = GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(Places.GEO_DATA_API)
                .build()

        placesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        fab.setOnClickListener{
//            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show()
//            }

            val builder = PlacePicker.IntentBuilder()
            val intent: Intent = builder.build(this)
            startActivityForResult(intent, PLACE_PICKER_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == PLACE_PICKER_REQUEST && resultCode == Activity.RESULT_OK) {
            val place = PlacePicker.getPlace(this, data)
            val places: MutableList<Place> = arrayListOf()
            val adapter = PlaceAdapter(places)

            placesRecyclerView.adapter = adapter
            places.add(place)
            adapter.notifyDataSetChanged()

//            Toast.makeText(this, "Place: " + place.name, Toast.LENGTH_SHORT).show()
//            Toast.makeText(this, "Address: " + place.address, Toast.LENGTH_SHORT).show()


        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onConnected(p0: Bundle?) {
        Log.d(LOG_TAG, "Connection Successful!")
    }

    override fun onConnectionSuspended(p0: Int) {
        Log.d(LOG_TAG, "Connection Suspended!")
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.d(LOG_TAG, "Connection Failed!")
    }
}

