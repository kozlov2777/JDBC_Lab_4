package org.example;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Телефон", 2000, 1);
        Worker worker= new Worker();
        worker.save(product);
        System.out.println(worker.get(14));
        worker.update(new Product("Часи",1200,1),13);
        System.out.println(worker.get(13));
        worker.deleteById(13);
        System.out.println(worker.get(13));

    }
}