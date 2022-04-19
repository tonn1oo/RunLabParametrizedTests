package runLab;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchTest {

    @ValueSource(strings = {
            "VaporFly",
            "Pegasus"

    })
    @ParameterizedTest(name = "Search in the store runLab {0}")
    void runLabSearchTest(String testData) {

        Selenide.open("https://www.runlab.ru");
        $("#yw8").setValue(testData);
        $(".search-go").submit();

        $$(".items").find(Condition.text(testData))
                .shouldBe(Condition.visible);
    }

    @CsvSource({
            "VaporFly, Ekiden",
            "Pegasus, Trail"

    })
    @ParameterizedTest(name = "Search in the store runLab {0} Expected result {1}")
    void runLabSearchParamTest(String testData, String result ) {

        Selenide.open("https://www.runlab.ru");
        $("#yw8").setValue(testData);
        $(".search-go").submit();

        $$(".product-name").find(Condition.text(result))
                .shouldBe(Condition.visible);

    }

}


