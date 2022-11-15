package org.example;

import City.District;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Streams {
    public static List<District> sortByDistrictName(List<District> districts){
        return districts.stream().sorted(Comparator.comparing(District::getName)).collect(Collectors.toList());
    }

    public static List<District> sortByCountOfHouses(List<District> districts){
        return districts.stream().sorted(Comparator.comparing(x -> x.getHouses().size())).collect(Collectors.toList());
    }

    public static List<District> getDistrictsWithGivenCountOfHouses(List<District> districts, int countOfHouses){
        return districts.stream().filter(x -> x.getHouses().size() == countOfHouses).collect(Collectors.toList());
    }

    public static void printDistrictsNames(List<District> districts){
        districts.stream().map(District::getName).forEach(out::println);
    }

    public static List<String> getDistrictsName(List<District> districts){
        return districts.stream().map(District::getName).collect(Collectors.toList());
    }
}
