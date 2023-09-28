package HomeTask8;

import HomeTask8.model.TableModel;
import HomeTask8.model.User;
import HomeTask8.presenters.BookingPresenter;
import HomeTask8.presenters.Model;
import HomeTask8.presenters.View;
import HomeTask8.views.BookingView;

import java.util.Date;
import java.util.Scanner;

public class Program {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        System.out.println("*** Добро пожаловать в Ресторан 'Плакучая Ива!' ***");
        System.out.println("=======================");
        System.out.print("Укажите Ваше имя: ");
        String name = scanner.nextLine();
        User user = new User(name);

        presenter.updateUIShowTables();

        boolean flag = true;
        
        while (flag) {
            System.out.println("*** МЕНЮ ПРИЛОЖЕНИЯ ***");
            System.out.println("=======================");
            System.out.println("1. Посмотреть свободные столики");
            System.out.println("2. Забронировать столик");
            System.out.println("3. Посмотреть мои бронирования");
            System.out.println("4. Отменить бронь столика");
            System.out.println("5. Изменить бронь столика");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");

            if (scanner.hasNextInt()) {
                int answer = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (answer) {
                        // ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ
                        case 0:
                            System.out.println("Завершение работы приложения");
                            flag = false;
                            break;

                        // Посмотреть свободные столики
                        case 1:
                            presenter.updateUIShowTables();
                            break;

                        // Забронировать столик
                        case 2:
                            System.out.print("Укажите номер столика, который Вы хотите забронировать: ");
                            if (scanner.hasNextInt()) {
                                int tableNo = scanner.nextInt();
                                scanner.nextLine();
                                view.reservationTable(user, new Date(), tableNo, name);
                            } else {
                                System.out.println("Номер столика указан некорректно.");
                            }
                            break;

                        // Посмотреть мои бронирования
                        case 3:
                            view.showUserReservations(user);
                            break;

                        // Отменить бронь столика
                        case 4:
                            System.out.print("Укажите id Вашего бронирования столика, которое Вы хотите отменить: ");
                            if (scanner.hasNextInt()) {
                                int bookingId = scanner.nextInt();
                                scanner.nextLine();
                                view.closeReservationTable(user, bookingId);
                            } else {
                                System.out.println("Номер id бронирования указан некорректно.");
                            }
                            break;

                        // Изменить бронь столика
                        case 5:
                            System.out.print("Укажите id Вашего бронирования столика, которое Вы хотите изменить: ");
                            if (scanner.hasNextInt()) {
                                int bookingId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Укажите номер столика, который Вы хотите забронировать: ");
                                if (scanner.hasNextInt()) {
                                    int tableNo = scanner.nextInt();
                                    scanner.nextLine();
                                    view.changeReservationTable(user, bookingId, new Date(), tableNo, name);
                                } else {
                                    System.out.println("Номер столика указан некорректно.");
                                }
                            } else {
                                System.out.println("Номер id бронирования указан некорректно.");
                            }
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }
}