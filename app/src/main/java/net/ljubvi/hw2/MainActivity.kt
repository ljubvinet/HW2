package net.ljubvi.hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Toast.makeText(this,"Welcome, dear clicker!",Toast.LENGTH_LONG).show()
        val poga: Button = findViewById(R.id.Poga)
        val teksts: TextView = findViewById(R.id.textView1)
        var clicks = 0
        poga.text = "Spaidi mani!"
        teksts.text = "Vēl nau spaidīc!"

        poga.setOnClickListener{
            clicks++;
            teksts.text = "$clicks"
            Toast.makeText(this,"$clicks",Toast.LENGTH_SHORT).show()
            Log.i(TAG,"klikšķis ir")
            Log.i(TAG,"$clicks")
        }






    }


}



