import java.util.Scanner;

class Main {

    public static int taxEarnings(int earnings) {
        // код метода по расчету налога
        int taxMdohod = (earnings) * 6 / 100;
        if (taxMdohod >= 0) {
            return taxMdohod;
        } else {
            return 0;
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        // код метода по расчету налога
        int taxMdohodMinusRashod = (earnings - spendings) * 15 / 100;
        if (taxMdohodMinusRashod >= 0) {
            return taxMdohodMinusRashod;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0; //Доход
        int spendings = 0; //Расход
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");
            System.out.println();

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }


            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода: ");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода: ");
                    String cashFlowStr = scanner.nextLine();
                    int cashFlow = Integer.parseInt(cashFlowStr);
                    spendings += cashFlow;
                    break;
                case 3:
                    int tax1 = taxEarnings(earnings); //УСН доходы
                    int tax2 = taxEarningsMinusSpendings(earnings, spendings); //УСН доходы минус расходы
                    if (tax1 < tax2) {
                        System.out.println("Мы советуем Вам УСН Доходы");
                        System.out.println("Ваш налог составит: " + tax1 + " руб.");
                        System.out.println("Налог на другой системе: " + tax2 + " руб.");
                        System.out.println("Экономия: " + (tax2 - tax1) + " руб.");
                        System.out.println();
                    } else if (tax1 > tax2) {
                        System.out.println("Мы советуем Вам УСН Доходы минус расходы");
                        System.out.println("Ваш налог составит: " + tax2 + " руб.");
                        System.out.println("Налог на другой системе: " + tax1 + " руб.");
                        System.out.println("Экономия: " + (tax1 - tax2) + " руб.");
                        System.out.println();
                    } else if (tax1 == tax2) {
                        System.out.println("налог по обеим системам налогообложения одинаков");
                        System.out.println("Ваш налог УСН Доходы составит: " + tax1 + " руб.");
                        System.out.println("Ваш налог УСН Доходы минус расходы составит: " + tax1 + " руб.");
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
                    System.out.println();
                    break;
            }
        }
        System.out.println("Программа завершена");
    }

}