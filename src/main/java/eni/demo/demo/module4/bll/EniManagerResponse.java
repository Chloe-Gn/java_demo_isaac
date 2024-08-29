package eni.demo.demo.module4.bll;

import eni.demo.demo.module4.Aliment;

import java.util.List;

public class EniManagerResponse<T> {

    public String code;
    public String message;
    public T data;
}