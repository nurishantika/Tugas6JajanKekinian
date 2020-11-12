package com.example.jajankekinian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var intentThatStartedThisActivity = getIntent()

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            isiTampilan(intentThatStartedThisActivity)
        }
    }
    private fun isiTampilan(intentThatStartedThisActivity: Intent) {
            var judul = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var gambar = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER)?.toInt()
            var harga = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
            var deskripsi = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TITLE)
            itemName.text = judul
            itemPrice.text = harga
            itemDesc.text = deskripsi
            if (gambar != null) {
                itemImg.setImageResource(gambar)
            }
        }
    }
