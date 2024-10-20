import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class FormTest extends TestBase{



    @Test
    @Tag("formTest")
    @DisplayName("Заполнение всех полей форы")
    void formTest() {

        step("Открытие страницы регистрации в браузере", () ->
        open("/automation-practice-form"));

        step("Заполнение ФИО", () -> {
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Test");
    });

        step("Заполнение Email", () ->
        $("#userEmail").setValue("111@11.ru"));

        step("Заполнение пола", () ->
        $("#genterWrapper").$(byText("Male")).click());

        step("Заполнение номера телефона", () ->
        $("#userNumber").setValue("1111111111"));

        step("Заполнение даты рождения", () -> {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$("option[value='2000']").click();
        $(".react-datepicker__month-select").$("option[value='7']").click();
        $(".react-datepicker__day--013").click();
    });

        step("Заполнение предмета", () ->
        $("#subjectsInput").setValue("ma").pressEnter());

        step("Заполнение хобби", () ->
        $("#hobbiesWrapper").$(byText("Sports")).click());

        step("Загрузка картинки", () ->
        $("#uploadPicture").uploadFromClasspath("tst.png"));

        step("Заполнение адресса", () ->
        $("#currentAddress").setValue("Kutuzovskaya"));

        step("Заполнение штата и города", () -> {
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Del").pressEnter();
        $("#submit").click();
    });

        step("Результирующая таблица", () -> {
        $(".table-responsive").shouldHave(text("Egor Test"));
        $(".table-responsive").shouldHave(text("111@11.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1111111111"));
        $(".table-responsive").shouldHave(text("13 August,2000"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sport"));
        $(".table-responsive").shouldHave(text("tst.png"));
        $(".table-responsive").shouldHave(text("Kutuzovskaya"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
        });
    }
}
