package za.co.sintez.black.jack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.sintez.black.jack.model.Student;

public class Response {
    private String id;
    private String name;
    private Student.Gender gender;
    private int grade;

    public String getId() {
        return id;
    }

    @JsonProperty
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    public Student.Gender getGender() {
        return gender;
    }

    @JsonProperty
    public void setGender(Student.Gender gender) {
        this.gender = gender;
    }

    public int getGrade() {
        return grade;
    }

    @JsonProperty
    public void setGrade(int grade) {
        this.grade = grade;
    }
}