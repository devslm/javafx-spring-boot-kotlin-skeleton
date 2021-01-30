package com.javafx.component.mapper

import com.javafx.dto.TestDto
import com.javafx.entity.TestEntity
import org.mapstruct.IterableMapping
import org.mapstruct.Mapper
import org.mapstruct.Named
import org.mapstruct.ReportingPolicy
import java.util.*

@Mapper(
    imports = [
        UUID::class
    ],
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface TestMapper {
    fun toEntity(order: TestDto): TestEntity

    @IterableMapping(qualifiedByName = ["toDto"])
    fun toDto(orderEntity: List<TestEntity>): List<TestDto>

    @Named("toDto")
    fun toDto(orderEntity: TestEntity): TestDto
}