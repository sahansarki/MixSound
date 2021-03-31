package live.codemy.mixsound

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val imgMic = findViewById<ImageButton>(R.id.imgbt_mic)
        val imgbFast = findViewById<ImageButton>(R.id.imgbt_bird)
        val imgbSlow = findViewById<ImageButton>(R.id.imgbt_bird2)
        val imgbDarthVader = findViewById<ImageButton>(R.id.imgbt_bird3)
        val imgbChimpmonk = findViewById<ImageButton>(R.id.imgbt_bird4)

        imgMic.setOnClickListener {

            "Mic clicked " extShowToast this
        }

        imgbFast.setOnClickListener {
            "imgbFast clicked " extShowToast this
        }

        imgbSlow.setOnClickListener {
            "imgbSlow clicked " extShowToast this
        }

        imgbDarthVader.setOnClickListener {
            "imgbDarthVader clicked " extShowToast this
        }

        imgbChimpmonk.setOnClickListener {
            "imgbChimpmonk clicked " extShowToast this
        }
    }
}

infix fun String.extShowToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}