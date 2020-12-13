package com.indahputrihartanti.instagramsaya

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.indahputrihartanti.instagramsaya.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val  REQUEST_CODE = 100

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple_intent.setOnClickListener {
            val SimpleIntent = Intent(this@MainActivity, SimpleActivity::class.java)
            startActivity(SimpleIntent)
        }
        btn_intent_with_data.setOnClickListener {
            val dataIntent = Intent (this@MainActivity, ExplicitIntentActivity::class.java)
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_NAME,"Honda Vario 150 eSP")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_HARGA,"Rp 25.000.000")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_DESKRIPSI,"Honda Vario 150 eSP – “Ride The Perfection” merupakan skutik flagship AHM dengan desain dan fitur yang tercanggih di Indonesia. Motor ini sudah menggunakan mesin Honda terbaru berteknologi eSP dan berbagai fitur lainnya seperti Answer Back System, lampu depan LED, PGM-FI, Combi Brake System, ISS dan lainnya.")
            startActivity(dataIntent)
        }

        btn_intent_parcelabel.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, ParcelActivity::class.java)
            val user = User("Indah Putri Hartanti", "indahph@gmail.com", "19 Tahun")
            parcelIntent.putExtra(ParcelActivity.EXTRA_PRODUCT, user)
            startActivity(parcelIntent)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "089521667080"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200) {
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }
}