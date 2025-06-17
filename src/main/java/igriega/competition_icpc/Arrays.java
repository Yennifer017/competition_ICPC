
package igriega.competition_icpc;

import java.util.LinkedList;

/**
 *
 * @author blue-dragon
 */
public class Arrays {
    public static void main(String args[]){
        Arrays a = new Arrays();
        Object[] array = {1, 2, new Object[] {"\"3\"", "\"4\""}};
        System.out.println(java.util.Arrays.toString(a.convertArray(array)));
        
        Object[] array1 = {1, 2, new Object[] {"a", "b", new Object[] {5, 6}}};
        System.out.println(java.util.Arrays.toString(a.convertArray(array1)));
        
        Object[] array2 = {1, 2, new Object[] {3, 4, new Object[] {5, 6, new Object[]{7, 8, new Object[] {9, 10}}}}};
        System.out.println(java.util.Arrays.toString(a.convertArray(array2)));
    }
    
    private Object[] convertArray(Object[] array, LinkedList<Object> list){
        for(int i = 0; i < array.length ; i++){
            Object current = array[i];
            if(current.getClass().isArray()){
                convertArray((Object[]) current, list);
            } else {
                list.add(current);
            }
        }
        return list.toArray();
    }
    
    private Object[] convertArray(Object[] array){
        LinkedList<Object> outputList = new LinkedList<>();
        return convertArray(array, outputList);
    }
}
