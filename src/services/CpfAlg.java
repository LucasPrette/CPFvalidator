
package services;

import java.sql.SQLOutput;

public class CpfAlg {
    private String cpf;
    int[] numbers;
    int firstDigit;
    int secondDigit;
    public CpfAlg() {
    }


    public CpfAlg(String cpf) {
        this.cpf = cpf;
        this.numbers = stringToArray();
        this.firstDigit = validationFirstDigit();
        this.secondDigit = validationSecondDigit();
        checkCpf();
    }

    public int[] stringToArray() {
        int[] numbers = new int[this.cpf.length()];

        for (int i = 0; i < this.cpf.length(); i++) {
            numbers[i] = this.cpf.charAt(i) - '0';
        }
        return numbers;
    }
    private int validationFirstDigit() {
        int sum = 0;
        for (int i = 10; i > 1; i--) {
            sum += numbers[10 - i] * i;
//            System.out.println(numbers[10 - i] + " " + i + " = " + sum);
        }

        sum %= 11;

        if (sum < 2) {
            sum = 0;
        } else {
            sum = 11 - sum;
        }

        return sum;

    }

    private int validationSecondDigit() {
        int sum = 0;
        for (int i = 11; i > 1; i--) {
            sum += (numbers[11 - i]) * i;
//            System.out.println(numbers[11 - i] + " " + i + " = " + sum);
        }

        sum %= 11;

        if (sum < 2) {
            sum = 0;
        } else {
            sum = 11 - sum;
        }

        return sum;
    }

    public void checkCpf() {
        if ( (firstDigit == numbers[9]) && (secondDigit == numbers[10])) {
            System.out.println(this.cpf);
            System.out.println(this.firstDigit + " = " + numbers[9]);
            System.out.println(this.secondDigit + " = " + numbers[10]);
            System.out.println("Valid CPF!!");
        } else {
            System.out.println(this.cpf);
            System.out.println(this.firstDigit + " != " + numbers[9]);
            System.out.println(this.secondDigit + " != " + numbers[10]);
            System.out.println("Invalid CPF!!");
        }
    }

}
