package com;

public class DemoDaoImpl implements DemoDao<String, Integer>
{
    public Integer doSomeOperation(String t)
    {
        return Integer.parseInt(t);
    }
    public String doReverseOperation(Integer t)
    {
        return t.toString();
    }
}
