package ufc.smd.placar_tenis
import ufc.smd.placar_tenis.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap // Use lateinit para inicialização posterior

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps) // Certifique-se de que está usando o layout correto
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as? SupportMapFragment // Use o operador de chamada segura
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latitude = intent.getStringExtra("latitude")?.toDoubleOrNull() ?: -34.0
        val longitude = intent.getStringExtra("longitude")?.toDoubleOrNull() ?: 151.0

        val location = LatLng(latitude, longitude)
        mMap.addMarker(
            MarkerOptions()
                .position(location)
                .title("Local da Partida")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
    }

}
