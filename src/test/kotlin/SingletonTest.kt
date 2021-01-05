import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import singleton.NetworkDriver

class SingletonTest {
    @Test
    fun testSingleton() {
        val networkDriver1 = NetworkDriver.log()
        val networkDriver2 = NetworkDriver.log()
        Assertions.assertThat(networkDriver1).isSameAs(NetworkDriver)
        Assertions.assertThat(networkDriver2).isSameAs(NetworkDriver)
    }
}
