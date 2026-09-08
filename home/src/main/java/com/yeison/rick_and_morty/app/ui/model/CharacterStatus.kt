package com.yeison.rick_and_morty.app.ui.model

import androidx.compose.ui.graphics.Color
import com.yeison.core.theme.StatusAlive
import com.yeison.core.theme.StatusDead
import com.yeison.core.theme.StatusUnknown

enum class CharacterStatus(val status: String, val color: Color) {
    ALIVE("alive", StatusAlive),
    DEAD("dead", StatusDead),
    UNKNOWN("unknown", StatusUnknown);

    companion object {
        fun fromString(value: String): CharacterStatus {
            return entries.firstOrNull { it.status.equals(value, ignoreCase = true) } ?: UNKNOWN
        }
    }
}