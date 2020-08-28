package com.milkit;

public class UserInput {
    
    public static class TextInput {
        private StringBuilder sb = null;

        public TextInput() {
            sb = new StringBuilder();
        }

        public void add(char c) {
            sb.append(c);
        }

        public String getValue() {
            return sb.toString();
        }
    }

    public static class NumericInput extends TextInput {
        public void add(char c) {
            if(Character.isDigit(c)) {
                super.add(c);
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}