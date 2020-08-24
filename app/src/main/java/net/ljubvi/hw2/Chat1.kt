package net.ljubvi.hw2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_chat1.*
import kotlinx.android.synthetic.main.activity_chat1.button
import kotlinx.android.synthetic.main.activity_chat1.message_box


class Chat1 : AppCompatActivity() {
    companion object {
        const val EXTRA_ZINA = "net.ljubvi.hw2.test_message"
        const val EXTRA_REPLY = "net.ljubvi.hw2.test_message"
        const val DETAIL_REQUEST = 1234
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat1)
        Toast.makeText(this,getString(R.string.welcome_chatter), Toast.LENGTH_LONG).show()

        backToMenu.setOnClickListener {
            val intent = Intent(this, Navigation::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {

            val message = message_box.text.toString()
            message_box.text.clear()
            textView2.text =  textView2.text.toString() + "\n"+getString(R.string.I_wrote)+"\n\t" + message

            val intenta = Intent(this,Chat2::class.java).apply{
                putExtra(EXTRA_ZINA, message)
            }
            startActivityForResult(intenta, DETAIL_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == DETAIL_REQUEST && resultCode == Activity.RESULT_OK){
            data?.let{
                val reply = data.getStringExtra(EXTRA_REPLY)
                textView2.text =
                    textView2.text.toString() + "\n"+getString(R.string.Someone_replied)+"\n\t" + reply
            }
        }
    }
}