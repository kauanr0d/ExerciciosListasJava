package application;

import entities.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Teste3ListasDeObjetosComComparacoes {
    public static void main(String[] args){
        List <Employee> l1 = new ArrayList();

        Employee e1 = new Employee(1,"Kauan",1000);
        Employee e2 = new Employee(2, "Kateriny",1202);
        Employee e3 = new Employee(3,"Armando",1500);
        Employee e4 = new Employee(4,"Kaio",2003);
        Employee e5 = new Employee(10,"Bashar",2500);

        l1.add(e1);
        l1.add(e2);
        l1.add(e3);
        l1.add(e4);
        l1.add(e5);

        Comparator<Employee> compararPorNome = Comparator.comparing(Employee::getName);
        Comparator<Employee> compararPorSalario = Comparator.comparing(Employee::getSalary);
        Collections.sort(l1,compararPorNome);

        for(Employee e: l1){
            System.out.println(e.getName());
        }
        System.out.println();
        Collections.sort(l1,compararPorSalario);
        System.out.println("Ordenado:");
        for(Employee e: l1){
            System.out.println("Nome:"+e.getName()+"\n"+"Salário:"+e.getSalary());
            System.out.println();
        }

        List <Employee> l2 = new ArrayList();
        //pegar dados da lista 1 que possuem salario maior que 1300 e passando para a lista 2
        System.out.println("dados da lista 1 que possuem salario maior que 1300 e passando para a lista 2");
        l2 = l1.stream().filter(n->n.getSalary()>1300).collect(Collectors.toList());
        for(Employee e: l2){
            System.out.println("Nome:"+e.getName()+"\n"+"Salário:"+e.getSalary());
            System.out.println();
        }
        /*usar um predicado para remover todos empregados com inicial 'K' e passar para outra lista */
        System.out.println("Com inicial diferente K:");
        l2 = l1.stream().filter(n->n.getName().charAt(0)!='K').collect(Collectors.toList());

        for(Employee e: l2){
            System.out.println("Nome:"+e.getName()+"\n"+"Salário:"+e.getSalary());
            System.out.println();
        }
        /*remoevendo com predicado
        l1.removeIf(n -> n.getName().charAt(0)=='K');
        */
        Collections.sort(l1,compararPorNome);/*saída: kaio*/
        l1.sort(compararPorSalario);/*saída: kauan*/
        Employee nome1 = l1.stream().filter(n -> n.getName().charAt(0)=='K').findFirst().orElse(null);
        System.out.println(nome1.getName());

    }
}
