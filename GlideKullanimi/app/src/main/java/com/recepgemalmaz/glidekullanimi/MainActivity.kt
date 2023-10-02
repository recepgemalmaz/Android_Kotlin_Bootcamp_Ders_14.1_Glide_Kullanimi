package com.recepgemalmaz.glidekullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.recepgemalmaz.glidekullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //http://kasimadalan.pe.hu/yemekler/resimler/pizza.png

        resimGoster("kofte")

        binding.buttonResim1.setOnClickListener {

            resimGoster("ayran")

        }
        binding.buttonResim2.setOnClickListener {

            resimGoster("su")

        }
        binding.buttonRastgele.setOnClickListener {
            val yemeklerListesi = arrayOf(
                "ayran",
                "baklava",
                "fanta",
                "izgarasomon",
                "izgaratavuk",
                "kadayif",
                "kahve",
                "kofte",
                "lazanya",
                "makarna",
                "pizza",
                "su",
                "sutlac",
                "tiramisu"
            )
            val rastgeleSayi = (0..13).random()
            val rastgeleYemek = yemeklerListesi[rastgeleSayi]
            resimGoster(rastgeleYemek)

        }
    }

    fun resimGoster(resimAdi: String) {

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${resimAdi}.png"
        Glide.with(this).load(url).override(500, 500).into(binding.imageViewYemek)
    }
}