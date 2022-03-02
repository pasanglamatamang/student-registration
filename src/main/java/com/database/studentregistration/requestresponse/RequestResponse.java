package com.database.studentregistration.requestresponse;

import com.database.studentregistration.students.Student;

public class RequestResponse {

    private String message;
    private int status;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RequestResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", student=" + student +
                '}';
    }
}
