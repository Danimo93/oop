public class Assignment {



    /**
     * Returns the sum of all the received numbers.
     */
    public int addThreeNumbers(int i, int j, int k) {
        return i + j + k;
    }


    /**
     * Evaluates if the received number is
     * Small (less than 100).
     * Big (greater than 1000).
     * Medium (not small or big)
     */
    public String isNumberSmallMediumOrBig(int number){

        String result;

        if(number < 100) {
            result = "Small";
        }
        else if(number > 1000) {
            result = "Big";
        }
        else{
            result = "Medium";
        }
        return result;
    }

    /**
     * Prints all Strings in received array to standard output.
     * One String on each line.
     */
    public void printAllStrings(String[] strings) {
        for (String i : strings){
            System.out.println(i);
        }
    }
    /**
     * Returns the sum of all numbers in received array.
     */
    public int arraySum(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            	sum += numbers[i];
        }
        return sum;
    }

    /**
     * Print all characters until a char is "."
     * Do not print in separate lines.
     */
    public void printFirstSentence(char[] chars) {
        String result = "";
        boolean stop = false;
        int index = 0;

        while(!stop && index < chars.length){
            result += chars[index];
            stop = (chars[index] == '.');
            index++;
        }
        System.out.print(result);

    }

    /**
     * Prints course name for provided course code.
     * PGR103 -> Objektorientert programmering
     * DB1102 -> Database
     * TK2100 -> Informasjonssikkerhet
     * or "Unknown" if none of the above.
     */
    public void printCourseName(String courseCode){
        switch (courseCode){
            case "PGR103": System.out.println("Objektorientert programmering");
            break;
            case "PGR112": System.out.println("Object Oriented Programming");
            break;
            case "DB1102": System.out.println("Database");
            break;
            case "TK2100": System.out.println("Informasjonssikkerhet");
            break;
            default: System.out.println("Unknown");
        }
    }

    /**
     * Prints all Strings in received array to standard output.
     * One String on each line.
     * But only if the String is not exactly "Corona".
     */
    public void printAllStringsNotCorona(String[] strings){
            for (int i = 0; i < strings.length; i++){
                if(!strings[i].equals("Corona")){
                System.out.println(strings[i]);
            }
        }
    }

    /**
     * Prints the provided strings in upper case letters.
     * One String on each line.
     */
    public void printUpperCaseStrings(String[] strings) {
        for (String s : strings) {
            System.out.println(s.toUpperCase());
        }
    }

    /**
     * Returns true if provided color is represented in the Norwegian flag.
     * Color input is lowercase only.
     */
    public boolean isColorInNorwegianFlag(String color){
        return  color.equalsIgnoreCase("white") ||
                color.equalsIgnoreCase("red")   ||
                color.equalsIgnoreCase("blue");
    }

    /**
     * Returns the index of the first occurrence of char c in String string.
     * Returns -1 if char is not found.
     */
    public int firstOccurrence(String string, char c){
        char[] auxStrings = string.toCharArray();
        for (int i = 0; i < string.length(); i++){
            	if (auxStrings[i] == c) {
                    return i;
                };
        }
        return -1;
    }

    /**
     * Returns the combined length of the provided Strings.
     */
    public int combinedLength(String s1, String s2){

        return s1.length() + s2.length();
    }

    /**
     * Returns the sum of all the received numbers.
     */
    public int addNumbers(int... numbers){
        int sum = 0;
        for (int number : numbers){
            	sum += number;
        }
        return sum;
    }

    /**
     * Prints all Strings in received array to standard output.
     * One String on each line.
     * But only if the String is not Corona (case insensitive).
     */
    public void printAllStringsNotCoronaCaseInsensitive(String[] strings){
        for (String str : strings){
            if(!str.equalsIgnoreCase("Corona")) System.out.println(str);

        }
    }

}
