package Task;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    public Sentence(String stringSentence){
        String[] wordsString = stringSentence.split("\\s+");
        for (String item : wordsString){
            value.add(new Word(item));
        }
    }

    public List<Word> value = new ArrayList<>();

    public Word getLastWord(){
        try{
            return value.get(value.size()-1);
        }
        catch (IndexOutOfBoundsException ex){
            return new Word();
        }
    }


    public Word getWord(int index){
        if (index < 0 || index >= value.size()){
            throw new IllegalArgumentException();
        }
        return value.get(index);
    }

    public List<Word> getSameLength(int length){
        List<Word> output = new ArrayList<>();
        for (Word item : value){
            if (item.getLength() == length){
                output.add(item);
            }
        }
        return output;
    }
}
