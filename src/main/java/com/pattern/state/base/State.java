package com.pattern.state.base;

//抽象状态类
abstract class State
{
    public abstract void Handle(Context context);
}
