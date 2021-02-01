package codeTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class TextEditor {
    String plaidTextEditor(String[][] input) {
        Arrays.sort(input, new Comparator<String[]>() {
            public int compare(String[] a1, String[] a2) {
                return Long.compare(Long.parseLong(a1[0]), Long.parseLong(a2[0]));
            }
        });
        Stack<String> stack = new Stack<>();
        Stack<String[]> undo = new Stack<>();
        Stack<String[]> redo = new Stack<>();

        for (int i = 0; i < input.length; i++) {

            String operation[] = input[i];

            switch (operation[1]) {

                case "INSERT":
                    for (char ch : operation[2].toCharArray())
                        stack.push(Character.toString(ch));
                    undo.push(operation);
                    break;

                case "DELETE":
                    if (!stack.isEmpty())
                        undo.push(new String[]{operation[1], stack.pop()});
                    break;

                case "UNDO":
                    if (!undo.isEmpty()) {
                        String[] temp = undo.pop();
                        if (temp[1].equals("INSERT")) {
                            int j = 0;
                            while (j < temp[2].length()) {
                                stack.pop();
                                j++;
                            }
                        } else {
                            stack.push(temp[1]);
                        }
                        redo.push(temp);
                    }

                    break;

                case "REDO":
                    if (!redo.isEmpty() && i > 0 && (input[i - 1][1].equals("UNDO") || input[i - 1][1].equals("REDO"))) {
                        String[] temp = redo.pop();
                        if (temp[1].equals("INSERT")) {
                            for (char ch : temp[2].toCharArray()) {
                                stack.push(Character.toString(ch));
                            }
                            undo.push(temp);
                        } else {
                            temp[1] = stack.pop();
                            undo.push(temp);
                        }
                    }

                    break;

                case "SELECT":

                    if ((i + 1 < input.length) && input[i + 1][1].equals("BOLD")) {
                        int start = Integer.parseInt(input[i][2]);
                        int end = Integer.parseInt(input[i][3]);
                        String str = getString(stack);
                        String newString = str.substring(0, start) + "*" + str.substring(start, end) + "*" + str.substring(end);
                        stack = updateStack(newString);

                    } else if ((i + 1 < input.length) && input[i + 1][1].equals("INSERT")) {
                        int start = Integer.parseInt(input[i][2]);
                        int end = Integer.parseInt(input[i][3]);
                        String str = getString(stack);
                        System.out.println(str);
                        String remaining = "";
                        if (end < str.length())
                            remaining = str.substring(end);

                        String newString = str.substring(0, start) + input[i + 1][2] + remaining;
                        stack = updateStack(newString);
                        i++;
                    }

                    break;


            }
        }

        return getString(stack);


    }

    private static String getString(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private static Stack<String> updateStack(String str) {
        Stack<String> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(Character.toString(ch));
        }
        return stack;
    }

    public static void main(String[] args) {
        TextEditor s = new TextEditor();
        System.out.println(s.plaidTextEditor(new String[][]{{"INSERT", "a"},
                {"INSERT", "b"},
                {"UNDO"},
                {"REDO"}}));

        System.out.println(s.plaidTextEditor(new String[][]{{"INSERT", "a"},
                {"INSERT", "b"},
                {"UNDO"},
                {"REDO"},
                {"DELETE"},
        }));

        System.out.println(s.plaidTextEditor(new String[][]{{"INSERT", "a"},
                {"INSERT", "b"},
                {"UNDO"},
                {"REDO"},
                {"DELETE"},
                {"UNDO"}
        }));

        System.out.println(s.plaidTextEditor(new String[][]{{"INSERT", "a"},
                {"INSERT", "b"},
                {"UNDO"},
                {"REDO"},
                {"REDO"}
        }));
    }

}
