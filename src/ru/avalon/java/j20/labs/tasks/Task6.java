package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;
import ru.avalon.java.j20.labs.models.Country;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Задание №6
 *
 * <p>Тема: "Потоковый ввод-вывод. Получение объекта на
 * основании прочитанных данных".
 */
public class Task6 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        File input = new File("assets/countries.txt");
        Collection<Country> countries = read(input);

        /*
         * TODO(Студент): Выполнить задание №6
         *
         * 1. Реализовать метод read.
         *
         * 2. При реализации следует пользоваться классами:
         *    BufferedReader и Country.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение коллекции объектов типа {@link Country}
     * из указанного файла.
     *
     * <p>Выполняет чтение файла построчно. Преобразование
     * из текста в объект выполняется с использованием
     * метода {@code valueOf} класса {@link Country}.
     *
     * @param file файл
     * @return коллекция объектов типа {@link Country}
     * @throws IOException в случае ошибки ввода-вывода.
     */
    private Collection<Country> read(File file) throws IOException {
        ArrayList<Country> arrayList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String temp = "";
            while ((temp = br.readLine()) != null){
                arrayList.add(Country.valueOf(temp));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println("IOexception");
            e.printStackTrace();
        }
        catch (ParseException e) {
            System.out.println("ParseException");
            e.printStackTrace();
        }
        return arrayList;
    }
}
