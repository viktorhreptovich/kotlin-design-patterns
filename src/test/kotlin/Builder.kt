import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Component private constructor(builder: Builder) {

    var param1: String? = null
    var param2: Int? = null
    var param3: Boolean? = null

    class Builder {
        var param1: String? = null
            private set
        var param2: Int? = null
            private set
        var param3: Boolean? = null
            private set

        fun setParam1(param1: String) = apply { this.param1 = param1 }
        fun setParam2(param2: Int) = apply { this.param2 = param2 }
        fun setParam3(param3: Boolean) = apply { this.param3 = param3 }
        fun build() = Component(this)
    }

    init {
        param1 = builder.param1
        param2 = builder.param2
        param3 = builder.param3
    }

}

class BuilderTest {
    @Test
    fun builderTest() {
        val component = Component.Builder()
            .setParam1("Some value")
            .setParam3(true)
            .build()

        Assertions.assertThat(component.param1).isEqualTo("Some value")
        Assertions.assertThat(component.param2).isNull()
        Assertions.assertThat(component.param3).isEqualTo(true)
    }
}
