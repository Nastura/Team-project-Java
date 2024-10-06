package ru.netology.javaqadiplom;
//тесты

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test //Пополнение при положительном балансе, больше 0
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test //Пополнение на ноль
    public void addZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test //пополнение на сумму,после которой баланс больше максимального
    public void addSumUnderMax() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(9000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test //пополнение к максимальному балансу
    public void addToMax() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8000);

        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    @Test //пополнение при балансе  = 0
    public void addingWhenNoBalance() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );
        account.add(5000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test // Тест IllegalArgumentException - проверка создания счета с отрицательной ставкой
    public void savingAccountPositiv() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -3
            );
            System.out.println(account.getBalance());
        });
    }

    @Test // Тест IllegalArgumentException Минимальный баланс не может быть отрицательным
    public void exceptionForMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    3
            );
            System.out.println(account.getBalance());
        });
    }

    @Test // Тест IllegalArgumentException Минимальный баланс не может быть больше максимального
    public void exceptionForMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    20_000,
                    10_000,
                    3
            );
            System.out.println(account.getBalance());
        });
    }

    @Test // Тест IllegalArgumentException Начальный баланс не может быть отрицательным
    public void exceptionForInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -2_000,
                    20_000,
                    30_000,
                    3
            );
            System.out.println(account.getBalance());
        });
    }

    @Test //Тест IllegalArgumentException Начальный баланс не может быть меньше минимального
    public void exceptionForInitialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    20_000,
                    30_000,
                    3
            );
            System.out.println(account.getBalance());
        });
    }

    @Test //Тест IllegalArgumentException Начальный баланс не может быть больше максимального значения
    public void exceptionForInitialBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    40_000,
                    20_000,
                    30_000,
                    3
            );
            System.out.println(account.getBalance());
        });
    }

    @Test //уменьшение баланса на сумму покупки
    public void shouldChangeBalanceAfterPaying() {
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                10_000,
                5
        );
        account.pay(1000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test //Покупка ниже минимального баланса
    public void PayingLessMinBalance() {
        SavingAccount account = new SavingAccount(
                1_500,
                1_000,
                10_000,
                5
        );
        account.pay(5000);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test //расчет процентов за год
    public void shouldCalculateYearProcent() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(400, account.yearChange());
    }
}
