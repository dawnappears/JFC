package Task;

public class Word {
    public Word(String word){
        this.value = word;
        this.length = word.length();
    }

    public Word(){}

    public int getLength(){ return length; }

    public String value = "";
    private int length = 0;
}
