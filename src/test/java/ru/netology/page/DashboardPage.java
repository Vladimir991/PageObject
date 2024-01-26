package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement firstCard = $$(".list__item div").first();
    private SelenideElement secondCard = $$(".list__item div").last();
    private SelenideElement firstCardButton = $$("[data-test-id='action-deposit']").first();
    private SelenideElement secondCardButton = $$("[data-test-id='action-deposit']").last();
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public TransactionPage firstCardButton() {
        firstCardButton.click();
        return new TransactionPage();

    }

    public TransactionPage secondCardButton() {
        secondCardButton.click();
        return new TransactionPage();
    }

    public int getFirstCardBalance() {
        val text = firstCard.text();
        return extractBalance(text);
    }


    public int getSecondCardBalance() {
        val text = secondCard.text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }


}