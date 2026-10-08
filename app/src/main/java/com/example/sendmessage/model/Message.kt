package com.example.sendmessage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Representa un mensaje enviado de una persona a otra.
 *
 * Agrupa el *contenido* con las personas que participan: `sender` es quien
 * lo envía y `receiver` es quien lo recibe.
 *
 * @property id Identificador del mensaje.
 * @property content Texto del mensaje.
 * @property sender Persona que envía el mensaje.
 * @property receiver Persona que recibe el mensaje.
 */

@Parcelize
data class Message(
    val id: Int,
    val content: String,
    val sender: Person,
    val receiver: Person
) : Parcelable
