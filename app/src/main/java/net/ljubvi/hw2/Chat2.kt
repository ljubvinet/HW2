package net.ljubvi.hw2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_chat2.*

import kotlinx.android.synthetic.main.activity_chat2.button
import kotlinx.android.synthetic.main.activity_chat2.message_box

class Chat2 : AppCompatActivity() {
    companion object {
        const val EXTRA_ZINA = "net.ljubvi.hw2.test_message"
        const val EXTRA_REPLY = "net.ljubvi.hw2.test_message"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat2)
        val message1 = intent.getStringExtra(EXTRA_ZINA)

        textView.text = textView.text.toString() +  "\n"+getString(R.string.Someone_wrote)+"\n\t" +   message1

        backToMenu2.setOnClickListener {
            val intent = Intent(this, Navigation::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val message = message_box.text.toString()
            textView.text =  textView.text.toString() + "\n"+getString(R.string.I_replied)+"\n\t" + message

         /*   val intenta = Intent(this,Chat1::class.java).apply{
                putExtra(Chat2.EXTRA_ZINA, message)
            }
            startActivity(intenta) */
            val result = Intent().apply {
                putExtra(EXTRA_REPLY, message)
            }
            setResult(Activity.RESULT_OK,result)
            finish()
        }

    }


}