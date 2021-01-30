package com.javafx.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.javafx.service.TestService
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import org.springframework.stereotype.Component

@Component
class MainController(
   private val testService: TestService,
   private val objectMapper: ObjectMapper,
) {
    @FXML
    private lateinit var resultLabel: Label
    @FXML
    private lateinit var resultButton: Button

    @FXML
    fun initialize() {
        testService.createNewData()

        resultButton.setOnAction {
            val datas = objectMapper.writeValueAsString(
                testService.getAll()
            )
            resultLabel.text = datas
        }
    }
}
