package runLab;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import runLab.wrapper.MenuItem;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
                .shouldBe(visible);
    }

    @CsvSource({
            "VaporFly, Ekiden",
            "Pegasus, Trail"
    })
    @ParameterizedTest(name = "Search in the store runLab {0} Expected result {1}")
    void runLabSearchParamTest(String testData, String result) {

        Selenide.open("https://www.runlab.ru");
        $("#yw8").setValue(testData);
        $(".search-go").submit();

        $$(".product-name").find(Condition.text(result))
                .shouldBe(visible);
    }

    @EnumSource(MenuItem.class)
    @ParameterizedTest(name = "Search Menu Item in the store runLab ")
    void runLabMenuSearchTest(MenuItem testData) {

        Selenide.open("https://www.runlab.ru");
        $$(".hd-menu-wrapper").find(Condition.text(testData.rusName)).click();

    }

    static Stream<Arguments> methodSourceTest() {
        return Stream.of(
                Arguments.of("Sale", "Акции и скидки"),
                Arguments.of("Отзывы", "Спасибо, что выбрали")
        );
    }

    @MethodSource()
    @ParameterizedTest
    void methodSourceTest(String testData) {
        Selenide.open("https://www.runlab.ru");
        $(".icn-menu-menu8").hover();
        $(".dropdown").$(byText(testData)).click();

        $$("#site-container").find(Condition.text(testData)).shouldBe(visible);
        $$("#site-container").find(Condition.text(testData)).shouldBe(visible);
    }


}





