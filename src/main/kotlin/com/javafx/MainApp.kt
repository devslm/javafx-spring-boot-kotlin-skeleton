package com.javafx

import javafx.application.Application
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.WindowEvent
import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class MainApp: Application() {
    private val savedArgs: Array<String> = arrayOf()

    private lateinit var configurableApplicationContext: ConfigurableApplicationContext
    private var root: Parent? = null

    @Value("\${ui.window.main.title}")
    private val appName: String? = null

    companion object {
        var stage: Stage? = null
    }

    override fun init() {
        this.configurableApplicationContext = runApplication<MainApp>(*savedArgs)
        this.configurableApplicationContext.getAutowireCapableBeanFactory()
            .autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true)

        val loader = FXMLLoader(MainApp::class.java.getClassLoader().getResource("view/base.fxml"))
        loader.setControllerFactory {
            configurableApplicationContext.getBean(it)
        }
        this.root = loader.load()
    }

    override fun start(primaryStage: Stage) {
        val scene = Scene(root)
        scene.stylesheets.add("view/css/JMetroLightTheme.css")

        primaryStage.title = appName
        primaryStage.scene = scene
        primaryStage.isResizable = false
        primaryStage.centerOnScreen()
        primaryStage.show()
        primaryStage.onHiding = EventHandler { windowEvent: WindowEvent? -> }

        stage = primaryStage

        Platform.setImplicitExit(true)
    }

    override fun stop() {
        super.stop()

        configurableApplicationContext.close()
    }
}

fun main(args: Array<String>) = Application.launch(MainApp::class.java, *args)
