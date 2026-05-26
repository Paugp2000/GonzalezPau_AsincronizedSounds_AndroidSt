package com.example.gonzalezpauandroidstudioasincronizesounds

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSo1 = findViewById<Button>(R.id.btnSo1)
        val btnSo2 = findViewById<Button>(R.id.btnSo2)
        val btnSo3 = findViewById<Button>(R.id.btnSo3)

        btnSo1.setOnClickListener {
            playSound(R.raw.so1, "So 1")
        }

        btnSo2.setOnClickListener {
            playSound(R.raw.so2, "So 2")
        }

        btnSo3.setOnClickListener {
            playSound(R.raw.so3, "So 3")
        }
    }

    private fun playSound(soundRes: Int, name: String) {
        Log.d("AUDIO", "Reproduint $name...")

        val player = MediaPlayer.create(this, soundRes)
        if (player == null) {
            Log.e("AUDIO", "Error creant MediaPlayer!")
        } else {
            Log.d("AUDIO", "MediaPlayer creat correctament")
        }
        player?.setOnCompletionListener {
            it.release()
        }
        player?.start()
    }

}
