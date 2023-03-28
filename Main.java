import TUI.Menu;
import Task.Sentence;
import Task.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> menuItems = new ArrayList<>(Arrays.asList(
                "Ввести предложение",               // 0
                "Первые N слов",                    // 1
                "Длина последнего слова",           // 2
                "Слова той же длины, что последнее" // 3
        ));


        Menu mainMenu = new Menu(menuItems);

        Sentence sentence = null; // предложение для работы с ним

        int choice = -1; // выбор пункта меню
        do{
            mainMenu.show();
            try {
                choice = mainMenu.select();
            }
            catch (IndexOutOfBoundsException ex){
                continue;
            }
            switch (choice)
            {
                case 0:
                    System.out.print("Введите предложение >> ");
                    sentence = new Sentence(in.nextLine());
                    break;
                case 1:
                    if (sentence != null){
                        System.out.print("Количество первых N слов >> ");
                        int quantityFirstWords = in.nextInt();
                        if (quantityFirstWords < 0 || quantityFirstWords >= sentence.value.size())
                        {
                            System.out.println("Слишком малое или чрезчур большое значение N");
                            continue;
                        }

                        for (int i = 0; i < quantityFirstWords; i++) {
                            System.out.print(sentence.getWord(i).value + " ") ;
                        }
                    }
                    else{
                        System.out.println("Пожалуйста, введите предложение");
                    }
                    break;
                case 2:
                    if(sentence == null){
                        System.out.println("Пожалуйста, введите предложение");
                        break;
                    }
                    System.out.print("\n\nДлина последнего слова: " + sentence.getLastWord().getLength());
                    break;
                case 3:
                    if(sentence == null){
                        System.out.println("Пожалуйста, введите предложение");
                        break;
                    }
                    int lastWordLength = sentence.getLastWord().getLength();
                    System.out.print("\n\nСлова с той же длиной, что и последнее\n\n");

                    for (Word item : sentence.getSameLength(lastWordLength)){
                        System.out.print(item.value + " ");
                    }
                    break;
              }
        }while(choice != mainMenu.exitIndex);
    }
}
