package com.ratmir.onelab;

import com.ratmir.onelab.config.SpringConfig;
import com.ratmir.onelab.service.LibraryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        LibraryService libraryService = context.getBean(LibraryService.class);

        System.out.println("Список всех книг:");
        libraryService.listAllBooks().forEach(System.out::println);

        System.out.println("\nСписок всех пользователей:");
        libraryService.listAllUsers().forEach(System.out::println);

        System.out.println("\nСоздаем заказ...");
        libraryService.createOrder(1L, 1L);

        System.out.println("\nСписок всех заказов:");
        libraryService.listAllOrders().forEach(System.out::println);

        context.close();
    }
}
