package ru.YLab.hwThree.orgStucture;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrgStructureParserImpl implements OrgStructureParser {

    @Override
    public Employee parseStructure(File csvFile) throws IOException {
        List<Employee> employees = new ArrayList<>();
        Employee show = null;
        try (Scanner scanner = new Scanner(csvFile)) {
            while (scanner.hasNextLine()) {
                employees.add(parse(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Employee employee : employees) {
            if (employee.getBossId() == 0) {
                show = employee;
            }
        }
        return show;
    }
    public Employee parse(String line) {
        Employee employee = new Employee();
        try (Scanner scanner = new Scanner(line)) {
            scanner.useDelimiter(";");
            Long id = scanner.nextLong();
            String bossId = scanner.next();
            String name = scanner.next();
            String position = scanner.next();

            employee.setId(id);
            employee.setBossId(bossId.equals("") ? 0L : Long.parseLong(bossId));
            employee.setName(name);
            employee.setPosition(position);
        }
        return employee;
    }
}
