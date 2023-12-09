package com.example.firstproject.irregularverb.videoEndWithT

import android.content.Context
import android.media.MediaPlayer
import android.speech.tts.TextToSpeech
import android.widget.Toast

class Util {

    companion object {
        var mediaPlayer: MediaPlayer? = null
        var textToSpeech: TextToSpeech? = null

        // Initialize TextToSpeech if not already initialized
        fun initTextToSpeech(context: Context) {
            if (textToSpeech == null) {
                textToSpeech = TextToSpeech(context, null)
            }
        }

        fun speak(context: Context, text: String, audio: Int) {
            Toast.makeText(context, "speaking $text", Toast.LENGTH_SHORT).show()
            // Ensure TextToSpeech is initialized
            initTextToSpeech(context)

            if (audio == 0) {

                Toast.makeText(context, "speaking $text", Toast.LENGTH_SHORT).show()
                textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            } else {
                mediaPlayer?.release() // Release previous MediaPlayer instance if any
                mediaPlayer = MediaPlayer.create(context, audio)
                mediaPlayer?.start()
            }
        }

        // Release resources when they are no longer needed
        fun releaseResources() {
            mediaPlayer?.release()
            textToSpeech?.stop()
            textToSpeech?.shutdown()
        }
    }
}
