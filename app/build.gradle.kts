plugins {
    alias(libs.plugins.kotlin.jvm) // <1>
    application // <2>
}

repositories {
    mavenCentral() // <3>
}

dependencies {
    implementation("ai.koog:koog-agents:0.1.0")
    implementation("org.slf4j:slf4j-simple:2.0.17")

    implementation(libs.guava) // <6>
}

application {
    mainClass = "kooglmstudio.AppKt" // <7>
}
