package ru.YLab.hwThree.orgStucture;

import java.io.File;
import java.io.IOException;

public class OrgStructureTest {
    public static void main(String[] args) {
        File file = new File("YLabHomework/src/main/resources/test.csv");
        OrgStructureParserImpl parser = new OrgStructureParserImpl();
        try {
            System.out.println(parser.parseStructure(file));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
