//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.ArrayList;
public class ListMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        boolean done = false;

        do
        {

            System.out.println("*************************");
            System.out.println("***      Options      ***");
            System.out.println("*************************");
            System.out.println("A - Add item to list");
            System.out.println("D - Delete item from list");
            System.out.println("I - Insert item to list");
            System.out.println("P - Print (Display) list");
            System.out.println("Q - Quit (Exit) program");
            System.out.println("*************************");


            String choice = SafeInput.getRegExString(in, "Enter one of the above following choices", "[AaDdIiPpQq]");

            if (choice.equalsIgnoreCase("A"))
            {
                String addItem = SafeInput.getNonZeroLenString(in, "Please enter the item you want to add");
                myArrList.add(addItem);
                for (int i = 0; i < myArrList.size(); i++)
                {
                    System.out.println("(" + (i + 1) + ") " + myArrList.get(i));
                    System.out.println("");
                }
            } else if (choice.equalsIgnoreCase("D"))
            {
                int deleteItem = SafeInput.getRangedInt(in,"Indicate the location number for the item", 1, myArrList.size());
                myArrList.remove(deleteItem - 1);
                for (int i = 0; i < myArrList.size(); i++)
                {
                    System.out.println("(" + (i + 1) + ") " + myArrList.get(i));
                }
            }
            else if (choice.equalsIgnoreCase("I"))
            {
                String insertItem = SafeInput.getNonZeroLenString(in, "Please enter the item you want to insert");
                int newItem = SafeInput.getRangedInt(in, "Indicate the location number for the item", 1, myArrList.size());
                myArrList.add(newItem - 1, insertItem);
                for (int i = 0; i < myArrList.size(); i++)
                {
                    System.out.println("(" + ( i + 1) + ") " + myArrList.get(i));
                }

            }
            else if (choice.equalsIgnoreCase("P"))
            {
                System.out.println("");
                System.out.println("***************************************");
                System.out.println("***              List               ***");
                System.out.println("***************************************");

                int cnt = 0;

                for(String r : myArrList)
                {
                    System.out.printf("   Item%3d: %s%n\n", ++cnt, r);
                }
                System.out.println("");
                System.out.println("***************************************");
                System.out.println("");
                System.out.println("");
                System.out.println("");


            }
            else if (choice.equalsIgnoreCase("Q"))
            {
                if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?"))
                {

                    done = true;
                }
            }

        } while (!done);

    }
}

