# JavaFX with Spring Boot and Kotlin skeleton
This is a skeleton project for JavaFX with Spring Boot and Kotlin.

# Included components
  - JDK 15
  - Kotlin 1.4.21
  - JavaFX SDK 15
  - CSS theme **JMetroLightTheme** by **Pedro Duque Vieira**
  - Spring Boot 2.4.2
  - Jpa (Embedded SQLite DB 3.34.0)
  - Jackson data mapper 2.11.3
  - Mapstruct for data mapping 1.4.1.Final ([See documentation](https://mapstruct.org/))

# Run via Intellij Idea
If project doesn't start properly you can try the next steps depends on your environment:

  - Download the latest JavaFX SDK 15 ([Download page](https://gluonhq.com/products/javafx/))
  - Add to Idea project VM Options flags:
```
    --module-path="<path-to-javafx-sdk>/lib" 
    --add-modules=javafx.controls,javafx.fxml 
    --enable-preview -XX:+ShowCodeDetailsInExceptionMessages
```

# Troubleshooting
If app doesn't start and ask about some JavaFX modules you could try to add these possible exports to VM Options:

```
    --add-exports javafx.graphics/com.sun.javafx.sg.prism=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.scene=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.util=ALL-UNNAMED 
    --add-exports javafx.base/com.sun.javafx.logging=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.prism=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.glass.ui=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.geom.transform=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.tk=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.glass.utils=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.font=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED 
    --add-exports javafx.controls/com.sun.javafx.scene.control=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.scene.input=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.geom=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.prism.paint=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.scenario.effect=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.text=ALL-UNNAMED 
    --add-exports javafx.graphics/com.sun.javafx.iio=ALL-UNNAMED 
    --add-exports javafx.web/com.sun.javafx.webkit=ALL-UNNAMED 
```

Also, you can find some explanation on how to run JavaFX apps in Idea IDE [here](https://www.jetbrains.com/help/idea/javafx.html#add-javafx-lib).

# License
Please see [LICENSE](https://github.com/seregaSLM/javafx-spring-boot-kotlin-skeleton/blob/main/LICENSE).

## I do not support any other IDE except for Intellij Idea!
