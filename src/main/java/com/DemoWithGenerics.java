package com;

public class DemoWithGenerics<T>{
    private T someData;
//    private static T member; //This is not allowed

    public T getSomeData(){
        return someData;
    }

    public void setSomeData(T someData){
        this.someData=someData;
    }
}
