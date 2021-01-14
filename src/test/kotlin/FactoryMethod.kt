import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

sealed class Country {
    object Canada : Country()
}

object Spain : Country()
class Greece(val someProperty: String) : Country()
data class USA(val someProperty: String) : Country()

class Currency(val code: String)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency =
        when (country) {
            is Spain -> Currency("EUR")
            is Greece -> Currency("EUR")
            is USA -> Currency("USD")
            is Country.Canada -> Currency("CAD")
        }
}

class FactoryMethodTest {
    @Test
    fun currencyFactoryTest() {
        val spainCurrency = CurrencyFactory.currencyForCountry(Spain).code
        val greekCurrency = CurrencyFactory.currencyForCountry(Greece("")).code
        val usaCurrency = CurrencyFactory.currencyForCountry(USA("")).code
        val canadianCurrency = CurrencyFactory.currencyForCountry(Country.Canada).code

        Assertions.assertThat(spainCurrency).isEqualTo("EUR")
        Assertions.assertThat(greekCurrency).isEqualTo("EUR")
        Assertions.assertThat(usaCurrency).isEqualTo("USD")
        Assertions.assertThat(canadianCurrency).isEqualTo("CAD")
    }
}
