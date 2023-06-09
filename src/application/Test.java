package application;
import entities.Employee;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List <Employee> list = new ArrayList();
        int n;
        System.out.println("Quantos usuários serão inseridos?");
        n = sc.nextInt();

        for(int i = 0;i<n;i++){
            System.out.println();
            System.out.println("Insira o ID:");
            Integer id = sc.nextInt();
            while(hasId(list,id)){
                System.out.println("ID já existente!Insira um diferente:");
                id = sc.nextInt();
            }
            sc.nextLine();
            System.out.println("Nome:");
            String nome = sc.nextLine();
            System.out.println("Salário:");
            Double salario = sc.nextDouble();
            Employee e = new Employee(id,nome,salario);
            list.add(e);
        }
        System.out.println("Insira o ID o para aumentar o salário:");
        int idSalario = sc.nextInt();
        Employee emp = list.stream().filter(x -> x.getId() == idSalario).findFirst().orElse(null);

        if(emp==null){
            System.out.println("ID Inexistente!");
        }else{
            System.out.println("Insira a porcentagem para aumento:");
            Double porcentagem = sc.nextDouble();
            emp.increaseSalary(porcentagem);
        }
        for(Employee e : list){
            System.out.println(e.getName()+ "\n" + e.getSalary());
        }
    }

    public static Boolean idVerific(List <Employee> list, int id){
        for(int i =0;i<list.size();i++){
            if(list.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
    public static Integer getPosition(List <Employee> list, int id){
        for(int i =0;i<list.size();i++){
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }
    public static boolean hasId(List <Employee> list, int id){
        Employee e = list.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
        return e!=null;
    }
}
