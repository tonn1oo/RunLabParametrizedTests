package runLab;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import runLab.wrapper.MenuItem;

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
                .shouldBe(Condition.visible);
    }

    @ValueSource(strings = {
            "14 Апреля",
            "07 Апреля"
    })
    @ParameterizedTest(name = "Search in the store runLab {0}")
    void runLabNewsTest(String testData) {

        Selenide.open("https://www.runlab.ru");
        $(".index-articles-list").$(byText(testData)).click();
        $(".index-articles-list").$(byText(testData)).click();

      ///  $$(".items").find(Condition.text(testData))
             ///   .shouldBe(Condition.visible);
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
    @EnumSource(MenuItem.class)
    @ParameterizedTest(name = "Search Menu Item in the store runLab ")
    void runLabMenuSearchTest(MenuItem testData) {

        Selenide.open("https://www.runlab.ru");
        $$(".hd-menu").find(Condition.text(testData.rusName)).click();

     }


    }





