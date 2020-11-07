/**
 * @author Fatih OGUZ
 */
import java.util.ArrayList;

/**
 * see methods of ProblemInterface
 */
public class Test {

    public static void main(String[] args){


        Problem problem = new Problem();

        String str10 ="this function writes the sentence in reverse";
        System.out.println("reverse() Function==>>  " +str10+" ==> " + problem.reverse(str10));

/************************************************************************************************************/

        System.out.println("elfish whiteleaf "    +      problem.elfish( "whiteleaf"));
        System.out.println("elfish tasteful "     +      problem.elfish( "tasteful"));
        System.out.println("elfish unfriendly "   +      problem.elfish( "unfriendly"));
        System.out.println("elfish waffles "      +      problem.elfish( "waffles"));
        System.out.println("elfish fatih "        +      problem.elfish( "fatih"));
/**************************************************************************************************************/

        System.out.print("selecction sort ==> ");
        int arr[] = {3, 1, 5, 2, 7, 0};

        problem.recurSelectionSort(arr, arr.length, 0);

        for (int i = 0; i< arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");

/************************************************************************************************************************/

        ArrayList<Character> infix = new ArrayList<>();
        String str = "A+((B-C*D)/E)+F-G/H";
        for(int i = 0;i<str.length();i++){
            infix.add(str.charAt(i));
        }
        ArrayList<Character> res = new ArrayList<>();
        System.out.println("Evaluate postfix  A+((B-C*D)/E)+F-G/H ==> " + problem.evaluatePostfix(res,infix));

/***************************************************************************************************************************/

        ArrayList<Character> infix1 = new ArrayList<>();
        for(int i = 0;i<str.length();i++){
            infix1.add(str.charAt(i));
        }
        ArrayList<Character> res1 = new ArrayList<>();
        System.out.println("Evaluate prefix   A+((B-C*D)/E)+F-G/H ==> "  +   problem.evaluatePrefix(res1,infix1));

/***************************************************************************************************************************/
        System.out.println("************************************************************************************************");
        Integer[][] multidimentionalArray ={
                {1 ,2 ,3 ,4,1},
                {5, 6 ,7 ,8,2},
                {9 ,10 ,11 ,12,3},
                {13 ,14 ,15 ,16,4},
                {17 ,18 ,19 ,20,5},
                {17 ,18 ,19 ,20,6},
                {1 ,2 ,3 ,4,7},
                {5, 6 ,7 ,8,8},
        };
        for(int i=0;i<8;i++){
            for(int j = 0 ;j<5;j++){
                System.out.print(multidimentionalArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        problem.print(multidimentionalArray,0,0,0,5,7,0);
        System.out.println();
        System.out.println("************************************************************************************************");




        Integer[][] multidimentionalArray1 ={
                {1 ,2 ,3 ,4},
                {5, 6 ,7 ,8},
                {9 ,10 ,11 ,12},
                {13 ,14 ,15 ,16},
                {17 ,18 ,19 ,20},
                {17 ,18 ,19 ,20},

        };
        for(int i=0;i<6;i++){
            for(int j = 0 ;j<4;j++){
                System.out.print(multidimentionalArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        problem.print(multidimentionalArray1,0,0,0,4,5,0);
        System.out.println();
        System.out.println("************************************************************************************************");


        Integer[][] multidimentionalArray2 ={
                {1 ,2 ,3 ,4},
                {5, 6 ,7 ,8},
                {9 ,10 ,11 ,12},
                {13 ,14 ,15 ,16},
                {17 ,18 ,19 ,20},
        };
        for(int i=0;i<5;i++){
            for(int j = 0 ;j<4;j++){
                System.out.print(multidimentionalArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        problem.print(multidimentionalArray2,0,0,0,4,4,0);
        System.out.println();
        System.out.println("************************************************************************************************");

        String[] strings = {"24","40","6","5","*","-","5","/","+","4","+","10","2","/","-"};
        System.out.println("24 40 6 5 * - 5 / + 4 + 10 2 / -");
        System.out.println("evaluate postfix");
        problem.evaluateResultPostfix(strings,0,strings.length);
        System.out.println("************************************************************************************************");
        System.out.println("- + + 24 / - 40 * 6 5 5 4 / 10 2");
        System.out.println("evaluate prefix");
        String[] strings2 = {"-","+","+","24","/","-","40","*","6","5","5","4","/","10","2"};
        problem.evaluateResultPrefix(strings2,strings2.length-1,strings2.length);
    }


}
