package com.example.sendmessage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sendmessage.model.Message
import com.example.sendmessage.model.Person

/**
 * Pantalla inicial: recoge el texto y lo envía a [ViewMessageActivity].
 *
 * @autor Sergio AS
 * @version 1.0
 */
class SendMessageActivity : AppCompatActivity() {

    companion object {
        /** Clave compartida para incluir el objeto [Message] en el [Intent]. */
        const val EXTRA_MESSAGE = "com.example.sendmessage.EXTRA_MESSAGE"

        /** Etiqueta para filtrar en Logcat los mensajes de esta Activity. */
        const val TAG = "SendMessageActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "SendMessageActivity -> onCreate()")
        enableEdgeToEdge()
        setContentView(R.layout.activity_send_message)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val messageInput = findViewById<EditText>(R.id.etMessage)
        val sendButton = findViewById<Button>(R.id.btnSend)

        sendButton.setOnClickListener {
            sendMessage(messageInput.text.toString())
        }
    }

    /** Crea el objeto del dominio y lo entrega a la pantalla receptora mediante un Intent. */
    private fun sendMessage(content: String) {
        val sender = Person(dni = "123456789A", name = "María", surname = "Cortés Martínez")
        val receiver = Person(dni = "98765432A", name = "Paco", surname = "Rodriguez")
        val message = Message(id = 1, content = content, sender = sender, receiver = receiver)

        val messageIntent = Intent(this, ViewMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(messageIntent)
    }

    //region Ciclo de vida de una Activity

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SendMessageActivity -> onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SendMessageActivity -> onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SendMessageActivity -> onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SendMessageActivity -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SendMessageActivity -> onDestroy()")
    }

    //endregion
}
