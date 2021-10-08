public class Wrappers {
    Wrappers(){
        crearWrappers();
    }

    private void crearWrappers(){
        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt.intValue());
        System.out.println(myDouble.doubleValue());
        System.out.println(myChar.charValue());
        
        Integer myIntToString = 100;
        String myString = myIntToString.toString();
        System.out.println(myString.length());
        
        Character chWrapped = 'a'; //Autoboxing
        System.out.println(chWrapped.getClass());
        char ch = 'a';
        System.out.println(((Object) ch).getClass());
    }
}