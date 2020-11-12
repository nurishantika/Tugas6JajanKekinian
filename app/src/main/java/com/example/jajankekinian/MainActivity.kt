package com.example.jajankekinian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createSnackData()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = DataAdapter(testData, { snackItem : SnackData -> snackItemClicked(snackItem) })
    }
    private fun snackItemClicked(snackItem : SnackData) {
        val showDetailActivityIntent = Intent(this, DetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER, snackItem.foto.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, snackItem.nama.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, snackItem.harga.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, snackItem.deskripsi.toString())
        startActivity(showDetailActivityIntent)
    }
    private fun createSnackData() : List<SnackData> {
        val partList = ArrayList<SnackData>()
        partList.add(
            SnackData(
            "Brown Sugar Boba Milk Tea", R.drawable.boba, "Rp 25.000 - Rp 40.000",
                "Minuman ini terbuat dari tepung tapioka, teh, gula aren dan susu. " +
                        "Rasanya jelas manis, namun kamu bisa merasakan kesegaran saat meminumnya " +
                        "apalagi di tengah hari yang suhunya lumayan panas karena Brown Sugar Boba Milk Tea disajikan dingin."
            )
        )
        partList.add(
            SnackData(
                "Baso Aci", R.drawable.boci, "Rp 10.000 - Rp 26.000",
                "Salah satu kuliner khas Garut yang sampai saat ini masih digandrungi " +
                        "oleh banyak kalangan. Kuliner ini terbuat dari tepung kanji atau yang biasa orang sunda sebut aci."
            )
        )
        partList.add(
            SnackData(
                "Dessert Box", R.drawable.bsbn, "Rp 10.000 - Rp 100.000",
                "Seperti namanya, dessert box merupakan makanan penutup (cake) yang ada di dalam kotak makanan. " +
                        "Berbeda dengan dessert biasa yang disajikan di piring, dessert box bisa langsung dimakan dari tempatnya."
            )
        )
        partList.add(
            SnackData(
                "Korean Cheese Garlic Bread", R.drawable.kcgb, "Rp 10.000 - Rp 50.000",
                "Bentuknya serupa dengan burger yang dipotong enam sisi, sekilas tampak seperti bawang putih. " +
                        "Pada bagian tengah Korean Cheese Garlic Bread terdapat isian krim keju yang dilumuri dengan saus sebelum proses pemanggangan."
            )
        )
        partList.add(
            SnackData(
                "Kopi Susu Kekinian", R.drawable.kopsus, "Rp 18.000~",
                "Es kopi susu kekinian adalah istilah untuk mencakup jenis racikan kopi yang " +
                        "mengandung susu dan gula aren. Racikan ini umumnya disajikan dingin dengan es dalam kemasan gelas plastik bertutup."
            )
        )
        partList.add(
            SnackData(
                "Salmon Mentai", R.drawable.mentai, "Rp 50.000 - Rp 100.000+",
                "Makanan yang menjadi menu jagoan dari beberapa restoran Jepang ternama ini " +
                        "terdiri dari nasi, salmon, dan topping saus mentai yang di-torch. Aromanya yang " +
                        "smoky akan membuat kalian mendadak lapar. Apalagi saat disantap, kombinasi antara " +
                        "gurihnya salmon, dan creamynya saus mentai seakan menyatu di mulut."
            )
        )
        return partList
    }
}