package com.javafx.service

import com.javafx.dto.TestDto

interface TestService {
    fun getAll(): List<TestDto>

    fun createNewData()
}