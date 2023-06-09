package cloud.playio.gradle

import com.adarshr.gradle.testlogger.TestLoggerExtensionProperties
import org.gradle.api.Action
import org.gradle.api.model.ObjectFactory
import org.gradle.kotlin.dsl.mapProperty
import org.gradle.kotlin.dsl.property

open class OSSExtension(objects: ObjectFactory) {

    companion object {

        const val NAME = "oss"
    }

    /**
     * Project base name
     */
    val baseName = objects.property<String>()

    /**
     * Project title
     */
    val title = objects.property<String>()

    /**
     * Project description
     */
    val description = objects.property<String>()

    /**
     * Publishing info for Maven publication
     */
    val publishingInfo = PublishingInfo(objects)

    /**
     * Jar manifest
     */
    val manifest = objects.mapProperty<String, String>().convention(emptyMap())

    /**
     * Define developer is zero88
     */
    val zero88 = objects.property<Boolean>().convention(false)

    /**
     * Define developer is org:playio
     */
    val playio = objects.property<Boolean>().convention(false)

    /**
     * Test Logger configuration
     */
    val testLogger = objects.newInstance(TestLoggerExtensionProperties::class.java)

    fun publishingInfo(configuration: Action<PublishingInfo>) {
        configuration.execute(publishingInfo)
    }

    fun testLogger(configuration: Action<TestLoggerExtensionProperties>) {
        configuration.execute(testLogger)
    }
}
