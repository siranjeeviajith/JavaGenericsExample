package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainClass {
    public static void main(String[] args){
        /*Before Generics*/
        DemoWithoutGenerics object = new DemoWithoutGenerics();
        object.setSomeData(23);// any type of data
        object.setSomeData("hello there");
        /* But need type castig each time */
        String welcome = (String) object.getSomeData(); // type casting to string

        /*After Generics*/
        DemoWithGenerics<String> instance = new DemoWithGenerics<>();//ensures type safety
        instance.setSomeData("hello lokesh");   //Correct usage
        //instance.setSomeData(1);        //This will raise compile time error
        welcome = instance.getSomeData(); // no type casting needed
        System.out.println(welcome);

        /*Before Generic to use Array*/


        Object[] array = new String[10];
        array[0] = "lokesh";
        //array[1] = 10;      //This will throw ArrayStoreException


        /*Wildcard boundary*/
        /*Upper bound wildcards*/
        //List of Integers
        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        System.out.println(sum(ints));

        //List of Doubles
        List<Double> doubles = Arrays.asList(1.5d,2d,3d);
        System.out.println(sum(doubles));

        List<String> strings = Arrays.asList("1","2");//This will give compilation error as :: The method sum(List<? extends Number>) in the
        //type GenericsExample<T> is not applicable for the arguments (List<String>)
        //System.out.println(sum(strings));

        /*lower bound wildcards*/
        //List of grand children
        List<GrandChildClass> grandChildren = new ArrayList<GrandChildClass>();
        grandChildren.add(new GrandChildClass());
        addGrandChildren(grandChildren);

        //List of grand childs
        List<ChildClass> childs = new ArrayList<ChildClass>();
        childs.add(new ChildClass());
        addGrandChildren(childs);

        //List of grand supers
        List<SuperClass> supers = new ArrayList<SuperClass>();
        supers.add(new SuperClass());
        addGrandChildren(supers);
        //result
        /*
        [com.GrandChildClass@4617c264, com.GrandChildClass@36baf30c]
        [com.ChildClass@7a81197d, com.GrandChildClass@5ca881b5]
        [com.SuperClass@24d46ca6, com.GrandChildClass@4517d9a3]*/
    }

    //this method will only accept super classes of grandchildclass
    public static void addGrandChildren(List<? super GrandChildClass> grandChildren)
    {
        grandChildren.add(new GrandChildClass());
        System.out.println(grandChildren);
    }





    //Method will accept class which extends number
    private static Number sum (List<? extends Number> numbers){
        double s = 0.0;
        for (Number n : numbers)
            s += n.doubleValue();
        return s;

    }
}

