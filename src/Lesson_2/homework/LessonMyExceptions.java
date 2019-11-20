package Lesson_2.homework;

public class LessonMyExceptions {
//   1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//   2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
//   3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.

        private static final int ARRAY_SIZE = 4;

        private static final String[][] CorrectArray = new String[][]{
                {"10", "20", "30", "40"},
                {"50", "60", "70", "80"},
                {"90", "100", "110", "120"},
                {"130", "140", "150", "160"},
        };
        private static final String[][] InCorrectArraySize = new String[][]{
                {"10", "20", "30", "40"},
                {"50", "60", "80"},
                {"90", "100", "110", "120"},
                {"130", "140", "150", "160"},
        };
        private static final String[][] InCorrectArraySymbol = new String[][]{
                {"10", "20", "30", "40"},
                {"50", "60", "7Z", "80"},
                {"90", "100", "110", "120"},
                {"130", "140", "150", "160"},
        };

        private static void checkArraySize(String[][] data) {
            if (data.length != ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
            for (String[] row : data) {
                if (row.length != ARRAY_SIZE) {
                    throw new MyArraySizeException();
                }
            }

        }

        ;

        private static int sumArrayValues(String[][] data) {
            checkArraySize(data);

            int sumResult = 0;

            for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
                String[] row = data[rowIndex];
                for (int colIndex = 0; colIndex < row.length; colIndex++) {
                    String value = row[colIndex];
                    try {
                        sumResult += Integer.parseInt(value);

                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(value, rowIndex, colIndex);
                    }

                }
            }
            return sumResult;
        }

        public static void main(String[] args) {
            try{
                //int result = sumArrayValues(CorrectArray);
                //int result = sumArrayValues(InCorrectArraySize);
                int result = sumArrayValues(InCorrectArraySymbol);
                System.out.println("Сумма массива" + result);
            } catch (MyArrayDataException e){
                System.out.println("Некорректные данные в массиве");
                e.printStackTrace();
            } catch (MyArraySizeException e){
                System.out.println("Некорреткный размер массива");
                e.printStackTrace();
            }
        }

    }
