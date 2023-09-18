package HomeTask5;

import HomeTask5.ui.Editor3D;

import java.util.Scanner;
public class Program {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();
        boolean flag = true;

        while (flag) {
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("=======================");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Отобразить все модели проекта");
            System.out.println("41. Создать новую модель");
            System.out.println("42. Добавить к модели текстуру");
            System.out.println("43. Удалить текстуру из модели");
            System.out.println("44. Удалить модель");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("51. Создать новую текстуру");
            System.out.println("52. Удалить текстуру из проекта");
            System.out.println("6. Выполнить рендер всех моделей");
            System.out.println("7. Выполнить рендер модели");
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

                        // Открыть проект
                        case 1:
                            System.out.print("Укажите наименование файла проекта: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("Проект успешно открыт.");
                            break;

                        // Сохранить проект
                        case 2:
                            editor3D.saveProject();
                            break;

                        // Отобразить параметры проекта
                        case 3:
                            editor3D.showProjectSettings();
                            break;

                        // Отобразить все модели проекта
                        case 4:
                            editor3D.printAllModels();
                            break;

                        // Отобразить все текстуры проекта
                        case 5:
                            editor3D.printAllTextures();
                            break;

                        // Выполнить рендер всех моделей
                        case 6:
                            editor3D.renderAll();
                            break;

                        // Выполнить рендер модели
                        case 7:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;

                        // Создать новую модель
                        case 41:
                            editor3D.createModel();
                            break;

                        // Добавить к модели текстуру
                        case 42:
                            System.out.print("Укажите номер модели, к которой Вы хотите добавить текстуру: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                int textureNo = -1;
                                scanner.nextLine();
                                System.out.print("Укажите номер текстуры, которую Вы хотите добавить к модели: ");
                                if (scanner.hasNextInt()) {
                                    textureNo = scanner.nextInt();
                                    scanner.nextLine();
                                } else {
                                    System.out.println("Номер модели указан некорректно.");
                                }
                                editor3D.addTextureToModel(modelNo, textureNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;

                        // Удалить текстуру из модели
                        case 43:
                            System.out.print("Укажите номер модели, из которой Вы хотите удалить текстуру: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                int textureNo = -1;
                                scanner.nextLine();
                                System.out.print("Укажите номер текстуры, которую Вы хотите удалить из модели: ");
                                if (scanner.hasNextInt()) {
                                    textureNo = scanner.nextInt();
                                    scanner.nextLine();
                                } else {
                                    System.out.println("Номер модели указан некорректно.");
                                }
                                editor3D.removeTextureFromModel(modelNo, textureNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;

                        // Удалить модель
                        case 44:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.deleteModel(modelNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;

                        // Создать новую текстуру
                        case 51:
                            editor3D.createTexture();
                            break;

                        // Удалить текстуру из проекта
                        case 52:
                            System.out.print("Укажите номер текстуры: ");
                            if (scanner.hasNextInt()) {
                                int textureNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.deleteTexture(textureNo);
                            } else {
                                System.out.println("Номер текстуры указан некорректно.");
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