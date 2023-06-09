package application;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TesteListas {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        Random generator = new Random();
        for(int i = 0;i<10;i++){
            list.add(generator.nextInt(1,20));
        }
        for(int x:list){
            System.out.println(x);
        }
        int soma = list.stream().mapToInt(Integer::intValue).sum();//somar
        int pares = list.stream().filter(n-> n % 2 ==0).mapToInt(Integer::intValue).sum();
        Collections.sort(list);
        List <Integer> l2 = new ArrayList();
        l2 = list.stream().filter(n->n % 2 != 0).collect(Collectors.toList());
        System.out.println();
        System.out.println(pares);
        System.out.println(soma);
        System.out.println();
        for(int x : l2){
            System.out.println(x);
        }
    }
}
