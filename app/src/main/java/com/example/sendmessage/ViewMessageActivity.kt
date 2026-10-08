package com.example.sendmessage

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sendmessage.model.Message

/**
 * Pantalla receptora: recupera el objeto [Message] del Intent y muestra sus datos.
 *
 * @autor Sergio AS
 * @version 1.0
 */
class ViewMessageActivity : AppCompatActivity() {

    companion object {
        /** Etiqueta propia para filtrar los mensajes de esta Activity en Logcat. */
        const val TAG = "ViewMessageActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "ViewMessageActivity -> onCreate()")
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_message)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val receivedMessageView = findViewById<TextView>(R.id.tvReceivedMessage)
        val message = readMessageExtra()
        receivedMessageView.text = message?.let {
            getString(
                R.string.received_message_format,
                it.sender.name,
                it.sender.surname,
                it.content,
                it.receiver.name,
                it.receiver.surname
            )
        } ?: getString(R.string.received_placeholder)
    }

    /** Recupera el extra Parcelable, devolviendo null si falta o no es un [Message]. */
    @Suppress("DEPRECATION")
    private fun readMessageExtra(): Message? {
        val extraKey = SendMessageActivity.EXTRA_MESSAGE
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(extraKey, Message::class.java)
        } else {
            intent.getParcelableExtra(extraKey) as? Message
        }
    }

    //region Ciclo de vida de una Activity

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ViewMessageActivity -> onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ViewMessageActivity -> onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ViewMessageActivity -> onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ViewMessageActivity -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ViewMessageActivity -> onDestroy()")
    }

    //endregion
}
