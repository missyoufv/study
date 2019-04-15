package com.pattern.memento.base;

//管理者
public class Caretaker
{
    private Memento memento;
    public void setMemento(Memento m)
    {
        memento=m;
    }
    public Memento getMemento()
    {
        return memento;
    }
}
