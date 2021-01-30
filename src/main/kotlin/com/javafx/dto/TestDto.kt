package com.javafx.dto

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

data class TestDto(
    var id: UUID? = null,
    var dateCreate: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
)
