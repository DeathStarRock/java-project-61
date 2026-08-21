plugins {
    java
    application
    checkstyle
    id("com.diffplug.spotless") version "6.25.0"
}

application {
    applicationName = "app"
    mainClass.set("hexlet.code.App")
    applicationDefaultJvmArgs = listOf("-Dfile.encoding=UTF-8") // кириллица
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

checkstyle {
    toolVersion = "10.12.4"

}

tasks.named("checkstyleMain") {
    enabled = true
}

spotless {
    java {
        importOrder()              // сортировка импортов
        removeUnusedImports()      // удаление неиспользуемых импортов
        googleJavaFormat()         // формат от Google
            .aosp()                // версия AOSP (4 пробела, а не 2)
        formatAnnotations()        // форматирование аннотаций
        leadingTabsToSpaces<Any>(4)     // заменяет табуляции на 4 пробела
    }
}

fun <JavaExtension> leadingTabsToSpaces(i: Int) {

}
