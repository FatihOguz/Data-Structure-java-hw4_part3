/**
 * @author Fatih OGUZ
 */
import java.util.ArrayList;

/**
 * this interface has methods of homework4 part3's problems.
 */
public interface ProblemInterface {

    /**
     * statement -> words  (split words)
     * @param str is string(statement)
     * @return string array.every index hold word
     */
    public abstract String[] split(String str);

    /**
     * reverse string array (0->size-1,  1->size-2, 2->size-3 ..etc)
     * @param str is statement. every word stay node of string array
     * @param index is index of str (Str is string array)
     * @return reverse string array
     */
    public abstract String[] reverseHelp(String[] str,int index);

    /**
     * reverse string
     * @param str is statement
     * @return reversed string
     */
    public abstract String reverse(String str);

    /**
     * is elfish str?
     * @param str is string
     * @return if str elfish return true,otherwise false
     */
    public abstract boolean elfish(String str);

    /**
     * is elfish str
     * @param str is statement
     * @param indexE  counted e charactar
     * @param indexL  counted  l character
     * @param indexF counted f character
     * @param count is index of str
     * @param str_len size of str
     * @return if str elfish return true otherwise false
     */
    public abstract boolean elfishHelp(String str,int indexE,int indexL,int indexF,int count,int str_len);

    /**
     * what is minimum value of a array
     * @param a is integer array
     * @param i is index of integer array
     * @param j size of integer array
     * @return minimum value
     */
    public abstract int minIndex(int a[], int i, int j);

    /**
     * selection sort  a array
     * @param a is integer array
     * @param n is size of a array
     * @param index is index of a array
     */
    public abstract void recurSelectionSort(int a[], int n, int index);

    /**
     * infix-->postfix
     * @param res is arraylist (change from infix to postfix)
     * @param infix is infix statement
     * @return postfix statement
     */
    public abstract String evaluatePostfix(ArrayList res, ArrayList infix);

    /**
     *infix-->postfix
     * @param res changed from infix to postfix
     * @param stack hold on operators
     * @param infix is infix statement
     * @return postfix statement
     */
    public abstract ArrayList evaluatePostfix(ArrayList res, ArrayList stack, ArrayList infix);

    /**
     *infix--> prefix
     * @param res changed from infix to prefix
     * @param infix is infix statement
     * @return is prefix statement
     */
    public abstract String evaluatePrefix(ArrayList res,ArrayList infix);

    /**
     * infix-->prefix
     * @param res changed from infix to prefix
     * @param stack hold on operators
     * @param infix is infix statements
     * @return is prefix statement
     *
     */
    public abstract ArrayList evaluatePrefix(ArrayList res, ArrayList stack, ArrayList infix);

    /**
     * printing spiral
     * @param array is ınteger multidimetional array
     * @param row_index is index of row of array
     * @param column_index is index of column of array
     * @param aspect which move aspect
     * @param frekans_row  how much move in row
     * @param frekans_column  how much move in column
     * @param frekans_control update frekans_row and frekans_colum
     */
    public abstract void print(Integer[][] array,int row_index,int column_index,int aspect,int frekans_row,int frekans_column,int frekans_control);

    /**
     * reverse string
     * @param res reversed string
     * @param splitstr splited string
     * @param count index of str
     * @param splitstr_length size of splited str
     * @return reversed string
     */
    public abstract String reverseHelp2(String res,String[] splitstr,int count,int splitstr_length);

    /**
     *convert from arrayList to string
     * @param ret is string
     * @param res  is arrayList
     * @param count index of res ArrayList
     * @param resSize is size of res
     * @return is string
     */

    public abstract String evaluatePostfixOrPrefixHelp(String ret,ArrayList res,int count,int resSize);

    /**
     * give result of postfix
     * @param str is postfix statement
     * @param count is index of str(postfix statement)
     * @param str_length is size of str
     */
    public abstract void evaluateResultPostfix(String[] str, int count,int str_length);

    /**
     * calculate / evaluate prefix statement
     * @param str is prefix statement
     * @param count is index of str(prefix statement)
     * @param str_length is size of str
     */
    public abstract void evaluateResultPrefix(String[] str, int count,int str_length);
}
