package com.t2010a.hellot2010aagain.entity;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

class ValidationUtilTest {
    class Teacher {
        private String id;
        private String name;
        private int cakeCount;

        public Teacher(){

        }

        @Override
        public String toString() {
            return "Teacher{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", cakeCount=" + cakeCount +
                    '}';
        }

        public Teacher(String id, String name, int cakeCount) {
            this.id = id;
            this.name = name;
            this.cakeCount = cakeCount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCakeCount() {
            return cakeCount;
        }

        public void setCakeCount(int cakeCount) {
            this.cakeCount = cakeCount;
        }
    }




    @Test
    public void conCakeByTeacher() throws IOException{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("teachers.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        HashMap<String, Teacher> mapTeachers = new HashMap<>();
        for (String line; (line = reader.readLine()) != null;) {
            String[] splitedLine = line.split("");
            if (splitedLine.length == 4 ){
                String id = splitedLine[0];
                String name = splitedLine[1];
                int cakeCount = Integer.parseInt(splitedLine[3]);
                Teacher teacher = new Teacher(id, name, cakeCount);
                if(mapTeachers.containsKey(teacher.getId())){
                    Teacher oldTeacher = mapTeachers.get(teacher.getId());
                    oldTeacher.setCakeCount(oldTeacher.getCakeCount() + teacher.getCakeCount());
                    mapTeachers.put(oldTeacher.getId(), oldTeacher);
                } else {
                    mapTeachers.put(teacher.getId(), teacher);
                }

            }
        }
        ArrayList<Teacher> listTeacher = new ArrayList<>(mapTeachers.values());
        for(Teacher teacher :
                listTeacher) {
            System.out.println(teacher.toString());
        }
    }
}
