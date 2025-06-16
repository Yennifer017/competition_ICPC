
package igriega.competition_icpc;

import java.util.HashMap;

/**
 *
 * @author blue-dragon
 */
public class Anagrama {
    
    public static void main(String args[]){
        
        Anagrama anagrama = new Anagrama();
        System.out.println("Las palabras son anagramas?");
        System.out.println("Espada y pesada: " + anagrama.isAnagrama("espada", "pesada")); //true
        System.out.println("Hola y cola: " + anagrama.isAnagrama("hola", "cola")); //false
        System.out.println("amor y roma: " + anagrama.isAnagrama("amor", "roma")); //true
        System.out.println("piedras y pietras: " + anagrama.isAnagrama("piedras", "pietras")); //false
    
    }
    
    private boolean isAnagrama(String firstWord, String secondWord){
        firstWord = firstWord.replace(" ", "");
        secondWord = secondWord.replace(" ", "");
        if(firstWord.length() != secondWord.length()){
            return false;
        }
        
        firstWord = firstWord.toLowerCase();
        secondWord = secondWord.toLowerCase();
        
        HashMap<Character, Integer> dictionary = new HashMap<>();
        //first word
        for(int i = 0; i < firstWord.length(); i++){
            char currentLetter = firstWord.charAt(i);
            if(dictionary.containsKey(currentLetter)){
                Integer value = dictionary.get(currentLetter);
                dictionary.put(currentLetter, value + 1);
            } else {
                dictionary.put(currentLetter, 1);
            }
        }
        
        //second word
        for(int i = 0; i < firstWord.length();  i++){
            char currentLetter = secondWord.charAt(i);
            if(dictionary.containsKey(currentLetter)){
                Integer value = dictionary.get(currentLetter);
                if(value > 1){
                    dictionary.put(currentLetter, value - 1);
                } else {
                    dictionary.remove(currentLetter);
                }
            } else {
                return false;
            }
        }
        return dictionary.isEmpty();
    }
}
