package Lesson_2.homework;


public class MyArraySizeException extends IllegalArgumentException {

    public MyArraySizeException() {
        super("Неверный размер массива. Не равен 4x4");
    }

}
