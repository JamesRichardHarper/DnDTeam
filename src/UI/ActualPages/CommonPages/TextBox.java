package UI.ActualPages.CommonPages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TextBox {
    int whiteSpace = 1;
    int length;
    String text;
    String finalText;
    ArrayList<String> textList;

    public TextBox(String text){
        this.text = text;
        this.length = text.length()+whiteSpace*4;
        this.finalText = addCoat(text, length);
    }
    public TextBox(ArrayList<String> textList){
        this.textList = textList;
        this.length = textList.stream().max(
                Comparator.comparingInt(String::length)
        ).orElse("").length();
        this.finalText = addCoat(textList, length);
    }

    public String getFinalText(){
        return finalText;
    }

    public int getLength(){
        return length;
    }

    public int getWhiteSpace(){
        return whiteSpace;
    }

    public String addCoat(String text, int length){
        return "*".repeat(length) + "\n" +
                "* " + text + " *" + "\n" +
                "*".repeat(length);
    }

    public String addCoat(ArrayList<String> textList, int length){
        String finalText = textList.parallelStream().collect(
                StringBuilder::new,
                (collected, newText) ->
                        collected.append("*").append("".repeat(getWhiteSpace())).append(newText).append("".repeat(getWhiteSpace())).append("*"),
                (collected, newText) ->
                        collected.append("\n").append(newText)).toString();

        return
                "*".repeat(length) + "\n" + finalText + "\n" + "*".repeat(length);
    }
}
