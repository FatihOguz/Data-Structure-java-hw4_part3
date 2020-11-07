/**
 * @author Fatih OGUZ
 */

import java.util.ArrayList;

/**
 * this class has methods of homework4 part3 problems
 * and implemented PromblemInterface
 */
public class Problem implements ProblemInterface{





/*********************************start problem1 metods*****************************************************/
    /**
     * split sting
     * @param str is string
     * @return string array
     */
    public  String[] split(String str){
        String[] res = str.split(" ");
        return res;
    }

    /**
     *  recursively method
     * @param str is string array
     * @param index index of string array (word)
     * @return string array(change reverse string)
     */
    public  String[] reverseHelp(String[] str,int index){
        String temp;
        if(str.length - index == str.length/2 ){
            return str;
        }
        else{
            temp=str[index];
            str[index] = str[str.length-index-1];
            str[str.length-index-1] = temp;
            return reverseHelp(str,index+1);
        }

    }

    public String reverseHelp2(String res,String[] splitstr,int count,int splitstr_length){
        if(count==splitstr_length){
            return res;
        }
        else{
            res = res + splitstr[count] + " ";
            count++;
        }
        return reverseHelp2(res,splitstr,count,splitstr_length);
    }

    /**
     * this method combine reversehelp and split metods
     * @param str is string
     * @return reverse str
     */
    public  String reverse(String str){
        String[] splitstr = split(str);
        splitstr = reverseHelp(splitstr,0);
        String res ="";
        res = reverseHelp2(res,splitstr,0,splitstr.length);
        return res;


    }
/*****************************************************finish problem1 metods***************************************/










    /*****************************************************start problem2 metods****************************************/
    /**
     * if str is elfish return true otherwise false
     * @param str is string array
     * @return is boolean
     */
    public  boolean elfish(String str){

        return elfishHelp(str,0,0,0,0,str.length());
    }

    /**
     * str has e,l and f return true otherwise false
     * @param str is string
     * @param indexE there is e in str
     * @param indexL there is l in str
     * @param indexF there is f in str
     * @param count is index of str
     * @param str_len is size of str
     * @return boolean
     */
    public  boolean elfishHelp(String str,int indexE,int indexL,int indexF,int count,int str_len){
        if(indexE>=1 && indexF>=1 && indexL>=1){
            return true;
        }
        else if(count==str_len){
            return false;
        }
        else{
            if(str.charAt(0) == 'l'){
                indexL++;
                count++;
            }
            else if(str.charAt(0) == 'f'){
                indexF++;
                count++;
            }
            else if(str.charAt(0) == 'e'){
                indexE++;
                count++;
            }
            else{
                count++;
            }

            return elfishHelp(str.substring(1),indexE,indexL,indexF,count,str_len);
        }
    }

/*************************************************finish problem2 metods********************************************/











    /*****************************************************start problem3 metods****************************************/
    /**
     * Recursive selection sort. n is size of a[] and index
     *  is index of starting element.
     * @param a is integer array
     * @param i is index of a
     * @param j is size of a
     * @return index of min value
     */
    public  int minIndex(int a[], int i, int j)
    {
        if (i == j)
            return i;

        // Find minimum of remaining elements
        int k = minIndex(a, i + 1, j);

        // Return minimum of current and remaining.
        return (a[i] < a[k])? i : k;
    }


    /**
     * sort from min to max
     * @param a is integer array
     * @param n is size of a
     * @param index is index of a
     */
    public  void recurSelectionSort(int a[], int n, int index)
    {

        // Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = minIndex(a, index, n-1);

        // Swapping when index nd minimum index are not same
        if (k != index){
            // swap
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        // Recursively calling selection sort function
        recurSelectionSort(a, n, index + 1);
    }


    /*****************************************************finish problem3 metods****************************************/









    /*****************************************************start problem4 metods****************************************/
    /**
     * convert arrayLİst to stirng
     * @param ret is string . this string return
     * @param res res is infix string
     * @param count is index of res
     * @param resSize is size of res
     * @return ret string
     */
    public String evaluatePostfixOrPrefixHelp(String ret,ArrayList res,int count,int resSize){
        if(count==resSize){
            return ret;
        }
        else
        {
            ret = ret + res.get(count);
            count++;
        }
        return evaluatePostfixOrPrefixHelp(ret,res,count,resSize);
    }

    /**
     * main metod infix -> postfix
     * @param res is arrayList and result
     * @param infix is arrayList (infix statement)
     * @return is string (postfix)
     */
    public String evaluatePostfix(ArrayList res, ArrayList infix){
        //int sonuc=0;

        ArrayList<Character> stack = new ArrayList<>();
        ArrayList<Character> result = new ArrayList<>();
        res = evaluatePostfix(res,stack,infix);
        //System.out.println("_____>>>> " + evaluate(res,0,sonuc));
        String ret = "";
        ret = evaluatePostfixOrPrefixHelp(ret,res,0,res.size());
        return ret;
    }

    /**
     * infix-->postfix
     * @param res is arrayList
     * @param stack is arrayList .stack hold on operators
     * @param infix is infix statement
     * @return is postfix arrayList
     */
    public  ArrayList evaluatePostfix(ArrayList res, ArrayList stack, ArrayList infix){
        if(infix.size()==0){
            /**
             * remove infix every step
             */

            if(stack.size()>0){
                for(int i = 0;i<stack.size();i++){
                    res.add(stack.get(i));
                }
            }
            /**
             * base case
             */
            return res;

        }
        else if(infix.get(0).equals('+')  || infix.get(0).equals('-')){
            /** add in stack*/
            stack.add(0,infix.get(0));


            if(stack.size()>1)
            {
                if(stack.get(1).equals('(') || stack.get(1).equals(')')){

                }
                else{
                    if(stack.size()>1){
                        res.add(stack.get(1));
                        stack.remove(1);
                    }
                }

            }


        }


        else if(infix.get(0).equals('*')  || infix.get(0).equals('/')){
            /**add in stack*/
            stack.add(0,infix.get(0));


            if(stack.size()>1){
                if(stack.get(1).equals('+') || stack.get(1).equals('-') || stack.get(1).equals('(') || stack.get(1).equals(')') ){

                }
                else{
                    if(stack.size()>1){
                        res.add(stack.get(1));
                        stack.remove(1);
                    }

                }
            }

        }



        else if(infix.get(0).equals('(')) {
            stack.add(0,'(');

        }
        else if(infix.get(0).equals(')')){
            int paranthesisIndex = -1;
            for(int i = 0;i<stack.size();i++){
                if(stack.get(i).equals('(')){
                    paranthesisIndex=i;

                    if(paranthesisIndex>-1){
                        for(int j = 0;j<paranthesisIndex;j++){
                            res.add(stack.get(j));
                        }
                        for(int k=0;k<=paranthesisIndex;k++){
                            stack.remove(0);
                        }

                        infix.remove(0);
                        return evaluatePostfix(res,stack,infix);
                    }
                }
            }


        }
        else{
            /* infix is digit*/
            res.add(infix.get(0));
        }

        infix.remove(0);
/**
 System.out.println("stack: " + stack);
 System.out.println("res : " + res);
 System.out.println("infix : " + infix);
 System.out.println("---------------------------------");
 */
        return evaluatePostfix(res,stack,infix);
    }



    /*************************************************finish problem4 metods********************************************/












    /****************************************************start problem5 metods***********************************************/
    /**
     * infix-->prefix
     * @param res is arrayList
     * @param infix is infix statement
     * @return is prefix statement
     */
    public  String evaluatePrefix(ArrayList res,ArrayList infix){
        ArrayList<Character> stack = new ArrayList<>();
        ArrayList<Character> result = new ArrayList<>();
        res = evaluatePrefix(res,stack,infix);
        String ret = "";
        ret = evaluatePostfixOrPrefixHelp(ret,res,0,res.size());
        return ret;
    }

    /**
     * infix-->prefix
     * @param res is arrayList
     * @param stack hold on operators
     * @param infix is infix statement
     * @return is prefix statement
     */

    public ArrayList evaluatePrefix(ArrayList res, ArrayList stack, ArrayList infix){
        if(infix.size()==0){
            /**
             *remove infix every step
             */

            if(stack.size()>0){
                for(int i = 0;i<stack.size();i++){
                    res.add(0,stack.get(i));
                }
            }
            /**
             * base case
             */
            return res;

        }
        else if(infix.get(infix.size()-1).equals('+')  || infix.get(infix.size()-1).equals('-')){
            /** add in stack*/
            stack.add(0,infix.get(infix.size()-1));


            if(stack.size()>1){
                if(stack.get(1).equals('+') || stack.get(1).equals('-') || stack.get(1).equals(')') || stack.get(1).equals('(')){

                }
                else{

                    res.add(0,stack.get(1));
                    stack.remove(1);
                }
            }


        }




        else if(infix.get(infix.size()-1).equals('*')  || infix.get(infix.size()-1).equals('/')){
            /** add in stack*/
            stack.add(0,infix.get(infix.size()-1));


            if(stack.size()>1){
                if(stack.get(1).equals('(') || stack.get(1).equals(')') || stack.get(1).equals('+') || stack.get(1).equals('-') || stack.get(1).equals('*') || stack.get(1).equals('/')){

                }
                else
                {
                    res.add(0,stack.get(1));
                    stack.remove(1);
                }
            }

        }

        else if(infix.get(infix.size()-1).equals(')')) {
            stack.add(0,'(');

        }
        else if(infix.get(infix.size()-1).equals('(')){
            int paranthesisIndex = -1;
            for(int i = 0;i<stack.size();i++){
                if(stack.get(i).equals('(')){
                    paranthesisIndex=i;

                    if(paranthesisIndex>-1){
                        for(int j = 0;j<paranthesisIndex;j++){
                            res.add(0,stack.get(j));
                        }
                        for(int k=0;k<=paranthesisIndex;k++){
                            stack.remove(0);
                        }

                        infix.remove(infix.size()-1);
                        return evaluatePrefix(res,stack,infix);
                    }
                }
            }


        }
        else{
            /* infix is digit*/
            res.add(0,infix.get(infix.size()-1));
        }

        infix.remove(infix.size()-1);
/**
 System.out.println("stack: " + stack);
 System.out.println("res : " + res);
 System.out.println("infix : " + infix);
 System.out.println("---------------------------------");
 */
        return evaluatePrefix(res,stack,infix);
    }

/*****************************finish problem5*******************************************************************************/


/****************************start problem6***********************************************************************************/
    /**
     *
     * @param array is multidimentional array m*n
     * @param row_index  row position
     * @param column_index colum position
     * @param aspect right 0  / down  1/ left 2  / up 3
     * @param frekans_row  how many units will the row advance
     * @param frekans_column how many units will the column advance
     * @param frekans_control  for update frekanses
     */
    public  void print(Integer[][] array,int row_index,int column_index,int aspect,int frekans_row,int frekans_column,int frekans_control){
        int temp = 0;
        if(aspect>3){
            aspect=0;
            column_index++;
        }

        if(frekans_row==0){
            System.out.println();
            return;
        }
        if(frekans_control%2==0 && frekans_control!=0){
            frekans_row--;
            frekans_column--;
        }
        if(aspect==0){
            for(int i=0;i<frekans_row;i++){
                System.out.print(array[row_index][i+column_index]);
                System.out.print(" ");
                temp=i+column_index;
            }
            print(array,row_index,temp,aspect+1,frekans_row,frekans_column,frekans_control+1);
        }
        else if(aspect==1){
            for(int i=0; i<frekans_column;i++){
                System.out.print(array[i+row_index+1][column_index]);
                System.out.print(" ");
                temp=i+row_index+1;
            }
            print(array,temp,column_index,aspect+1,frekans_row,frekans_column,frekans_control+1);
        }
        else if(aspect==2){
            for(int i =0;i<frekans_row;i++){
                System.out.print(array[row_index][column_index-i-1]);
                System.out.print(" ");
                temp = column_index-i-1;
            }
            print(array,row_index,temp,aspect+1,frekans_row,frekans_column,frekans_control+1);
        }

        else if(aspect==3){
            for(int i = 0;i<frekans_column;i++){
                System.out.print(array[row_index-i-1][column_index]);
                System.out.print(" ");
                temp=row_index-i-1;
            }
            print(array,temp,column_index,aspect+1,frekans_row,frekans_column,frekans_control+1);
        }

    }

    /**
     * calculate / evaluate postfix statement
     * @param str is postfix statement
     * @param count is index of str(postfix statement)
     * @param str_length is size of str
     */

public void evaluateResultPostfix(String[] str, int count,int str_length){
        int res;
        if(str_length==1){
            return ;
        }
        if(str.length>=3){
            if(str[count].equals("+")){
                res = Integer.parseInt(str[count-2]) + Integer.parseInt(str[count-1]);
                System.out.println(Integer.parseInt(str[count-2]) + " + " +  Integer.parseInt(str[count-1]) + " = " + res);
                for(int i = count-1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                for(int i = count-1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                str[count-2] = String.valueOf(res);
                str_length=str_length-2;
                evaluateResultPostfix(str,0,str_length);
            }
            else if(str[count].equals("-")){
                res = Integer.parseInt(str[count-2]) - Integer.parseInt(str[count-1]);
                System.out.println(Integer.parseInt(str[count-2]) + " - " +  Integer.parseInt(str[count-1]) + " = " + res);
                for(int i = count-1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                for(int i = count-1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                str[count-2] = String.valueOf(res);
                str_length=str_length-2;
                evaluateResultPostfix(str,0,str_length);

            }
            else if(str[count].equals("*")){
                res = Integer.parseInt(str[count-2]) * Integer.parseInt(str[count-1]);
                System.out.println(Integer.parseInt(str[count-2]) + " * " +  Integer.parseInt(str[count-1]) + " = " + res);
                for(int i = count-1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                for(int i = count-1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                str[count-2] = String.valueOf(res);
                str_length=str_length-2;
                evaluateResultPostfix(str,0,str_length);
            }
            else if(str[count].equals("/")){
                res = Integer.parseInt(str[count-2]) / Integer.parseInt(str[count-1]);
                System.out.println(Integer.parseInt(str[count-2]) + " / " +  Integer.parseInt(str[count-1]) + " = " + res);
                for(int i = count-1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                for(int i = count-1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                str[count-2] = String.valueOf(res);
                str_length=str_length-2;
                evaluateResultPostfix(str,0,str_length);
            }
            else{
                evaluateResultPostfix(str,count+1,str_length);
            }
        }


}
    /**
     * calculate / evaluate prefix statement
     * @param str is prefix statement
     * @param count is index of str(prefix statement)
     * @param str_length is size of str
     */
    public void evaluateResultPrefix(String[] str, int count,int str_length){
        int res;
        if(str_length==1){
            return ;
        }
        if(str.length>=3){
            if(str[count].equals("+")){
                res = Integer.parseInt(str[count+2]) + Integer.parseInt(str[count+1]);
                System.out.println(Integer.parseInt(str[count+2]) + " + " +  Integer.parseInt(str[count+1]) + " = " + res);
                for(int i = count+1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                for(int i = count+1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                str[count] = String.valueOf(res);
                str_length=str_length-2;
                evaluateResultPrefix(str,str_length,str_length);
            }
            else if(str[count].equals("-")){
                res = Integer.parseInt(str[count+1]) - Integer.parseInt(str[count+2]);
                System.out.println(Integer.parseInt(str[count+1]) + " - " +  Integer.parseInt(str[count+2]) + " = " + res);
                for(int i = count+1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                for(int i = count+1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                str[count] = String.valueOf(res);
                str_length=str_length-2;
                evaluateResultPrefix(str,str_length,str_length);

            }
            else if(str[count].equals("*")){
                res = Integer.parseInt(str[count+1]) * Integer.parseInt(str[count+2]);
                System.out.println(Integer.parseInt(str[count+1]) + " * " +  Integer.parseInt(str[count+2]) + " = " + res);
                for(int i = count+1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                for(int i = count+1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                str[count] = String.valueOf(res);
                str_length=str_length-2;
                evaluateResultPrefix(str,str_length,str_length);
            }
            else if(str[count].equals("/")){
                res = Integer.parseInt(str[count+1]) / Integer.parseInt(str[count+2]);
                System.out.println(Integer.parseInt(str[count+1]) + " / " +  Integer.parseInt(str[count+2]) + " = " + res);
                for(int i = count+1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                for(int i = count+1;i<str_length-1;i++){
                    str[i] = str[i+1];
                }
                str[count] = String.valueOf(res);
                str_length=str_length-2;
                evaluateResultPrefix(str,str_length,str_length);
            }
            else{
                evaluateResultPrefix(str,count-1,str_length);
            }
        }


    }


}
