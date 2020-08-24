package net.ljubvi.hw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_chat1.*
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"
private var clicks =0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Toast.makeText(this,getString(R.string.welcome_clicker),Toast.LENGTH_LONG).show()

        backToMenu3.setOnClickListener {
            val intent = Intent(this, Navigation::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener{
            clicks = 0
            textView1.text = "$clicks"
            Log.i(TAG,"reset done")
        }

        Poga.setOnClickListener{
            clicks++
            textView1.text = "$clicks"
            if (clicks % 10 == 0) {
                Toast.makeText(this, "$clicks", Toast.LENGTH_SHORT).show()
            }
            Log.i(TAG,getString(R.string.click_true))
            Log.i(TAG,"$clicks")

        }






    }


}



