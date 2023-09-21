class Solution {
    public String intToRoman(int num) {
        StringBuilder romanNumeral = new StringBuilder();
        while (num >= 1000) {
            romanNumeral.append("M");
            num -= 1000;
        }
        while (num >= 900) {
            romanNumeral.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            romanNumeral.append("D");
            num -= 500;
        }
        while (num >= 400) {
            romanNumeral.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            romanNumeral.append("C");
            num -= 100;
        }
        while (num >= 90) {
            romanNumeral.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            romanNumeral.append("L");
            num -= 50;
        }
        while (num >= 40) {
            romanNumeral.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            romanNumeral.append("X");
            num -= 10;
        }
        while (num >= 9) {
            romanNumeral.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            romanNumeral.append("V");
            num -= 5;
        }
        while (num >= 4) {
            romanNumeral.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            romanNumeral.append("I");
            num -= 1;
        }

        return romanNumeral.toString();
    }
}