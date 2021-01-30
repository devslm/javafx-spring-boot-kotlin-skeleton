package com.javafx.service

import com.javafx.component.mapper.TestMapper
import com.javafx.dto.TestDto
import com.javafx.repository.TestRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TestServiceImpl(
    private val testRepository: TestRepository,
    private val testMapper: TestMapper,
): TestService {
    override fun getAll(): List<TestDto> {
        return testMapper.toDto(
            testRepository.findAll()
        )
    }

    override fun createNewData() {
        testRepository.deleteAll()

        listOf(
            TestDto(id = UUID.randomUUID()),
            TestDto(id = UUID.randomUUID()),
        ).forEach {
            testRepository.save(
                testMapper.toEntity(it)
            )
        }
    }
}