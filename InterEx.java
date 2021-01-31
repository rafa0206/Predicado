/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aula12_mario_interex;

/**
 *
 * @author JFernandes
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Aluno {
  public final String nome;
  public final int nota;

  public Aluno(String nome, int nota){
    this.nome = nome;
    this.nota = nota;
  }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", nota=" + nota + '}';
    }
  
  
}

//x -> x > 0
/*class IsPositive implements IntPred{
  @Override
  public boolean test(int x){
    return x > 0;
  }
  //public void bla() {System.out.println("bla"); }
}

//x -> x < 0
class IsNegative implements IntPred{
  @Override
  public boolean test(int x){
    return x < 0;
  }
}

class IsEven implements IntPred {
  @Override
  public boolean test(int x) {
    return x % 2 == 0;
  }
}*/

public class InterEx {
    
    /*public static int countPos(ArrayList<Integer> list) {
    int cnt = 0;
    for (int x: list) {
      if (x > 0) ++cnt;
    }
    return cnt;
  }

  public static int countNeg(ArrayList<Integer> list){
    int cnt = 0;
    for (int x: list) {
      if (x < 0) ++cnt;
    }
    return cnt;
  }

  public static int countEven(ArrayList<Integer> list) {
    int cnt = 0;
    for (int x: list) {
      if (x % 2 == 0) ++cnt;
    }
    return cnt;
  }*/

/*public static int count(List<Integer> list, IntPred pred){
  int cnt = 0;
  for (int x: list) {
    if (pred.test(x)) ++cnt;
  }
  return cnt;
}*/

/*public static <T> int count(List<T> list, Pred<T> pred){
  int cnt = 0;
  for (T x: list) {
    if (pred.test(x)) ++cnt; //x.equals("ana")
  }
  return cnt;
}*/

/*public static void main(String [] args){
  IntPred pos = new IsPositive();
  IntPred neg = new IsNegative();

  List<Integer> list = new LinkedList<>(List.of(2, -3, 5, -6, 7, 8, -5));
  List<Integer> vec = new ArrayList<>(List.of(3, 5, -3, -6, 9, 8, -10, 11));

  System.out.println(count(vec, pos));
  System.out.println(count(list, neg));
  System.out.println(count(list, new IsEven()));
}*/

/*public static void main(String [] args){
  List<Integer> list = new LinkedList<>(List.of(2, -3, 5, -6, 7, 8, -5));
  List<Integer> vec = new ArrayList<>(List.of(3, 5, -3, -6, 9, 8, -10, 11));
  System.out.println(count(list, x -> x > 0));
  System.out.println(count(list, x -> x < 0));
  System.out.println(count(vec, y -> y % 2 == 0));
}*/

/*public static void main(String [] args) {
  List<Integer> list = new LinkedList<>(List.of(2, -3, 5, -6, 7, 8, -5));
  List<Integer> vec = new ArrayList<>(List.of(3, 5, -3, -6, 9, 8, -10, 11));
  System.out.println(count(list, x -> x > 0));
  System.out.println(count(list, x -> x < 0));
  System.out.println(count(vec, y -> y % 2 == 0));
  List<String> strs = new ArrayList<>(List.of("ana", "ana", "ana", "ana", "joana", "ana", "maria"));
  System.out.println(count(strs, (String s) -> s.equals("ana")));

  List<Aluno> alunos = new ArrayList<>(List.of(new Aluno("joao", 80),
      new Aluno("maria", 90), new Aluno("jose", 50)));
  System.out.println(count(alunos, a -> a.nota >= 70));
*/

public static <T> int count(List<T> list, Predicate<T> pred){
  int cnt = 0;
  for (T x: list) {
    if (pred.test(x)) ++cnt; //equal("ana")
  }
  return cnt;
}

public static <T> List<T> filter(List<T> list, Predicate<T> pred){
  List<T> result = new ArrayList<>();
  for (T x: list) {
    if (pred.test(x)) {
      result.add(x);
    }
  }
  return result;
}

public static <T, U> List<U> map(List<T> list, Function<T, U> fn) {
  List<U> result = new ArrayList<>();
  for (T x: list) {
    result.add(fn.apply(x));
  }
  return result;
}


public static void main(String [] args) {
  List<Integer> list = new LinkedList<>(List.of(2, -3, 5, -6, 7, 8, -5));
  List<Integer> vec = new ArrayList<>(List.of(3, 5, -3, -6, 9, 8, -10, 11));
  System.out.println(count(list, x -> x > 0));
  System.out.println(count(list, x -> x < 0));
  System.out.println(count(vec, y -> y % 2 == 0));
  List<String> strs = new ArrayList<>(List.of("ana", "ana", "ana", "ana", "joana", "ana", "maria"));
  System.out.println(count(strs, (String s) -> s.equals("ana")));


  List<Aluno> alunos = new ArrayList<>(List.of(new Aluno("joao", 65),
    new Aluno("maria", 90), new Aluno("jose", 67)));
  System.out.println(count(alunos, a -> a.nota >= 70));
  System.out.println(filter(alunos, a -> a.nota >= 70));
  System.out.println(map(list, x -> x*x));
  Function<Aluno, Aluno>altera = a ->{
    if (a.nota >= 70 || a.nota < 65) return a;
    return new Aluno(a.nome, 70);
  };
  System.out.println(map(alunos, altera));
}
}




