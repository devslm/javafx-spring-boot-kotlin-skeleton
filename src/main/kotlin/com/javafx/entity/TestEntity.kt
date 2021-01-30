package com.javafx.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "test_table")
data class TestEntity(
    @Id
    var id: UUID?,
    var dateCreate: LocalDateTime?
)
