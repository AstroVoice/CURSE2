package Lesson_2.homework;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String CellValue, int rowIndex, int colIndex) {
        super(String.format("Неверный формат значения '%s' в ячейке по адресу [%d][%d], требуется целое число", CellValue, rowIndex, colIndex));

    }

    ;
}
