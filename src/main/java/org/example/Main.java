package org.example;

import City.District;

import java.util.List;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        List<District> districts = ReadClass.readFromXML("A:\\untitled\\xml.txt");

        System.out.println("Список считанных районов:");
        assert districts != null;
        Streams.printDistrictsNames(districts);
        System.out.println("\n\n");

        System.out.println("Получение списка с названиями районов:");
        var names = Streams.getDistrictsName(districts);
        names.forEach(out::println);
        System.out.println("\n\n");

        out.println("Выборка районов с заданным количеством домов(2):");
        var districtsWith2Houses = Streams.getDistrictsWithGivenCountOfHouses(districts, 2);
        Streams.printDistrictsNames(districtsWith2Houses);
        System.out.println("\n\n");

        out.println("Сортировка районов по возрастанию количества домов:");
        var sortedByCountOfHouses = Streams.sortByCountOfHouses(districts);
        Streams.printDistrictsNames(sortedByCountOfHouses);
        System.out.println("\n\n");

        out.println("Сортировка районов по названию:");
        var sortedByName = Streams.sortByDistrictName(districts);
        Streams.printDistrictsNames(sortedByName);
        System.out.println("\n\n");
    }
}