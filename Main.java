import java.util.Scanner;
import Task.Sentence;
import Task.Word;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a sentence: ");

        Sentence sentence = new Sentence(in.nextLine());

        System.out.print("Amount of first words : ");
        int quantityFirstWords = in.nextInt();

        for (int i = 0; i < quantityFirstWords; i++) {
            System.out.print(sentence.getWord(i).value + " ") ;
        }


        int lastWordLength = sentence.getLastWord().getLength();

        System.out.print("\n\nLength of last: " + lastWordLength);

        System.out.print("\n\nWords with the same length\n\n");

        for (Word item : sentence.getSameLength(lastWordLength)){
            System.out.print(item.value + " ");
        }
    }
}
