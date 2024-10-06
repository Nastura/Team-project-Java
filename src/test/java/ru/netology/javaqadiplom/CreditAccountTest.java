package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    //>>>>>>>>> Тесты Конструктора CreditAccount
    @Test // 1. Выброс исключения вида IllegalArgumentException на отрицательную ставку кредитования
    public void negativeLendingRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreditAccount(20_000, 50_000, -15));
    }

    @Test // 2. Выброс исключения вида IllegalArgumentException на отрицательный кредитный лимит
    public void negativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreditAccount(20_000, -50_000, 15));
    }

    @Test // 3. Выброс исключения вида IllegalArgumentException на отрицательный баланс
    public void negativeBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreditAccount(-20_000, 50_000, 15));
    }

    //>>>>>>>>> Тесты метода оплаты с карты
    @Test // 4. Покупка на сумму при начальном балансе в 20_000
    public void purchaseAmount() {
        CreditAccount credit = new CreditAccount(20_000, 50_000, 15);
        credit.pay(10_000);
        int actual = credit.balance;
        int expected = 10_000;
        Assertions.assertEquals(expected, actual);
    }

    @Test // 5. Покупка на сумму при начальном балансе в 10_000
    public void purchaseAmount10000() {
        CreditAccount credit = new CreditAccount(10_000, 50_000, 15);
        credit.pay(10_000);
        int actual = credit.balance;
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test // 6. Покупка на сумму при начальном балансе в 0
    public void purchaseAmountNull() {
<<<<<<< HEAD
        CreditAccount credit = new CreditAccount(0, 5000, 15);
=======
        CreditAccount credit = new CreditAccount(0, 50_000, 15);
>>>>>>> 295ae425fe891b964ff4956df05380ea0c68f95b
        credit.pay(10_000);
        int actual = credit.balance;
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test // 7. Покупка на сумму при начальном балансе больше чем сам кредитный лимит
    public void purchaseAmountMax() {
        CreditAccount credit = new CreditAccount(60_000, 50_000, 15);
        credit.pay(10_000);
        int actual = credit.balance;
        int expected = 50_000;
        Assertions.assertEquals(expected, actual);
    }

    @Test // 8. Покупка на сумму 0 рублей
    public void purchaseAmountNullAmount() {
        CreditAccount credit = new CreditAccount(20_000, 50_000, 15);
        credit.pay(0);
        int actual = credit.balance;
        int expected = 20_000;
        Assertions.assertEquals(expected, actual);
    }

    @Test   // 9. Покупка на сумму больше кредитного лимита при начальном балансе в 20_000
    public void moreThanCreditLimit() {
        CreditAccount credit = new CreditAccount(20_000, 50_000, 15);
        credit.pay(100_000);
        int actual = credit.balance;
        int expected = 20_000;
        Assertions.assertEquals(expected, actual);
    }

    //>>>>>>>>> Тесты метода пополнения карты
    @Test   // 10. Пополнение баланса при начальном балансе 0 руб.
    public void initialBalance0() {
        CreditAccount credit = new CreditAccount(0, 50_000, 15);
        credit.add(10_000);
        int actual = credit.balance;
        int expected = 10_000;
        Assertions.assertEquals(expected, actual);
    }

    @Test   // 11. Пополнение баланса на сумму при начальном балансе 10_000
    public void topUpYourBalanceBy10000() {
        CreditAccount credit = new CreditAccount(10_000, 50_000, 15);
        credit.add(10_000);
        int actual = credit.balance;
        int expected = 20_000;
        Assertions.assertEquals(expected, actual);
    }

    @Test   // 12. Пополнение баланса на отрицательную сумму
    public void topUpYourBalanceByNull() {
        CreditAccount credit = new CreditAccount(10_000, 50_000, 15);
        credit.add(-500);
        int actual = credit.balance;
        int expected = 10_000;
        Assertions.assertEquals(expected, actual);
    }

    //>>>>>>>>> Тесты метода расчета ставки
    @Test // 13.Расчет процента на отрицательный баланс на карте в -200 руб.
    public void interestAnNegativeBalance() {
        CreditAccount credit = new CreditAccount(0, 50_000, 15);
        credit.add(300);
        credit.pay(500);
        int actual = credit.yearChange();
        int expected = -30;
        Assertions.assertEquals(expected, actual);
    }

    @Test // 14.Расчет процента при ставке в 15% на положительный баланс на карте в 200 руб.
    public void interestOnPositiveBalance() {
        CreditAccount credit = new CreditAccount(0, 50_000, 15);
        credit.add(300);
        credit.pay(100);
        int actual = credit.yearChange();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 295ae425fe891b964ff4956df05380ea0c68f95b
