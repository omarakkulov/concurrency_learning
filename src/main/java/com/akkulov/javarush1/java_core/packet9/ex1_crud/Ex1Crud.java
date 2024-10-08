package com.akkulov.javarush1.java_core.packet9.ex1_crud;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture10; CRUD
 */
public class Ex1Crud {

  public static final SimpleDateFormat SIMPLE_DATE_FORMATTER = new SimpleDateFormat("dd-MMM-yyyy",
      Locale.ENGLISH);
  public static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  public static List<Person> allPeople = new ArrayList<>();

  static {
    allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился id=0
    allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился id=1
  }

  public static void main(String[] args) {
    String command = "-u 1 Миронов m 15/04/1990";

    String[] splitResult = command.split(" ");

    Sex sex;
    LocalDate localDate;
    Date date;
    int personId;

    switch (splitResult[0]) {
      case "-c":

        if (splitResult[2].equals("m")) {
          sex = Sex.MALE;
        } else {
          sex = Sex.FEMALE;
        }

        localDate = LocalDate.parse(splitResult[3], INPUT_FORMATTER);
        date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        personId = createPerson(splitResult[1], sex, date);

        System.out.println(personId);
        break;
      case "-r":
        System.out.println(getPersonById(Integer.parseInt(splitResult[1])));
        break;
      case "-u":
        if (splitResult[3].equals("m")) {
          sex = Sex.MALE;
        } else {
          sex = Sex.FEMALE;
        }

        localDate = LocalDate.parse(splitResult[4], INPUT_FORMATTER);
        date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        personId = Integer.parseInt(splitResult[1]);
        updatePerson(personId, splitResult[2], sex, date);
        break;
      case "-d":
        personId = Integer.parseInt(splitResult[1]);
        deletePerson(personId);
        break;
      default:
        throw new RuntimeException();
    }
  }

  public static int createPerson(String name, Sex sex, Date birthday) {
    Person newPerson;
    switch (sex) {
      case MALE:
        newPerson = Person.createMale(name, birthday);
        break;
      case FEMALE:
        newPerson = Person.createFemale(name, birthday);
        break;
      default:
        throw new RuntimeException();
    }

    allPeople.add(newPerson);

    return allPeople.size() - 1;
  }

  public static String getPersonById(int personId) {
    Person person = allPeople.get(personId);
    return String.format("%s %s %s", person.getName(), person.getSex(),
        SIMPLE_DATE_FORMATTER.format(person.getBirthDate()));
  }

  public static void updatePerson(int personId, String name, Sex sex, Date birthday) {
    Person person = allPeople.get(personId);
    person.setName(name);
    person.setSex(sex);
    person.setBirthDate(birthday);
  }

  public static void deletePerson(int personId) {
    allPeople.remove(personId);
  }
}
