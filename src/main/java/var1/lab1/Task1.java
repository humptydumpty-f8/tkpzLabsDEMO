package var1.lab1;

import java.util.Stack;

public class Task1 {
    /**
     * 1. Сформировать и вывести на дисплей одномерный массив b, в котором первыми элементами являются  элементы
     * исходного одномерного массива a с отрицательными значениями (с сохранением порядка следования), а затем
     * элементы a с нулевыми и положительными значениями.
     */

    private static String[] originalArray;

    public Task1(String[] args) {
        originalArray = args;
    }

     int printArray(String[] array) {
        int flag = 1;
        String arrText = "";
        for (int i = 0; i < array.length; i++) {
            arrText += array[i] + " ";
        }
        System.out.println("[" + arrText + "]");
        flag=0;
        return flag;
    }

     boolean originalArrayIsNumeric(String[] arr) {
        boolean originalArrayIsNumeric = true;
        for (int i = 0; i < arr.length; i++) {
            try {
                Double.parseDouble(arr[i]);
                continue;
            } catch (Exception e) {
                originalArrayIsNumeric = false;
            }
        }
        return originalArrayIsNumeric;
    }


     String[] getFinalArray() {
        String[] finalArray = new String[originalArray.length];
        Stack<String> negativeElements = new Stack();
        Stack<String> zeroElements = new Stack();
        Stack<String> positiveElements = new Stack();
        double buffer;

        for (int i = 0; i < finalArray.length; i++) {
            buffer = Double.parseDouble(originalArray[i]);
            if (buffer < 0) negativeElements.push(originalArray[i]);
            else if (buffer == 0) zeroElements.push(originalArray[i]);
            else positiveElements.push(originalArray[i]);
        }

        Stack<String> stack = new Stack();
        stack.addAll(negativeElements);
        stack.addAll(zeroElements);
        stack.addAll(positiveElements);

        if (stack.capacity() == finalArray.length) {
            for (int i = finalArray.length - 1; i >= 0; i--) {
                finalArray[i] = stack.pop();
            }
        }
        return finalArray;
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1(args);

        System.out.println("Original array:");
        task1.printArray(originalArray);

        if (task1.originalArrayIsNumeric(originalArray))
            System.out.println("Original array is OK!\n");
        else System.exit(1);
        System.out.println("Final array:");
        task1.printArray(task1.getFinalArray());
    }
}
