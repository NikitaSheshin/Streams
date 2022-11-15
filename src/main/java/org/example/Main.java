package org.example;

import City.District;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        List<District> districts = ReadClass.readFromXML("A:\\untitled\\xml.txt");
        //print(districts);
        var names = getDistrictsName(districts);

        var districtsWith2Houses = getDistrictsWithGivenCountOfHouses(districts, 2);
        var sortedDistricts = sortByCountOfHouses(districts);
        var sortedByName = sortByDistrictName(districts);

        print(sortedByName);

    }

    private static List<District> sortByDistrictName(List<District> districts){
        return districts.stream().sorted(Comparator.comparing(x -> x.getName())).collect(Collectors.toList());
    }

    private static List<District> sortByCountOfHouses(List<District> districts){
        return districts.stream().sorted(Comparator.comparing(x -> x.getHouses().size())).collect(Collectors.toList());
    }

    private static List<District> getDistrictsWithGivenCountOfHouses(List<District> districts, int countOfHouses){
        return districts.stream().filter(x -> x.getHouses().size() == countOfHouses).collect(Collectors.toList());
    }

    private static void print(List<District> districts){
        districts.stream().map(x -> x.getName()).forEach(out::println);
    }

    private static List<String> getDistrictsName(List<District> districts){
        return districts.stream().map(x -> x.getName()).collect(Collectors.toList());
    }
}