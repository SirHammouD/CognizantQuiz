package com.project.alihammoud.myapplication;

import java.util.Arrays;
import java.util.List;

public class data  {

    List<String> options;
    String title;
    String answer;


    public data(List<String> options, String title, String answer) {
        this.options = options;
        this.title = title;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "data{" +
                "options=" + options +
                ", title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
