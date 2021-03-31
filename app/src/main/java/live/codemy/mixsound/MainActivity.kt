package live.codemy.mixsound

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.speech.RecognizerIntent
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import live.codemy.mixsoundlib.MixSound
import live.codemy.mixsoundlib.SoundType

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

            MixSound.getInstance(this).recordSound()
            "Mic clicked " extShowToast this
        }

        imgbFast.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.Fast)
            "imgbFast clicked " extShowToast this
        }

        imgbSlow.setOnClickListener {

            MixSound.getInstance(this).changeSound(SoundType.Slow)
            "imgbSlow clicked " extShowToast this
        }

        imgbDarthVader.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.DarthVader)
            "imgbDarthVader clicked " extShowToast this
        }

        imgbChimpmonk.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.Chipmunk)
            "imgbChimpmonk clicked " extShowToast this
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            MixSound.CODE_SPEECH_RECOGNIZER -> {
                data?.let {
                    val result = it.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    MixSound.recordSound = """Kimseler duymasın içimde sen varsın
                                              ben yokum ya şimdi o gözler ağlasın""".trimIndent()
                }
            }
        }
    }

    override fun onStop() {


        MixSound.getInstance(this).textToSpeech.stop()
        MixSound.getInstance(this).textToSpeech.shutdown()
        super.onStop()
    }
}

infix fun String.extShowToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}