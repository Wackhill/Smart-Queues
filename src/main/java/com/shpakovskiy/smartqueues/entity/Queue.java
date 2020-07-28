package com.shpakovskiy.smartqueues.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
public class Queue {

    private int id;
    private String title;
    private long registrationStartNanoseconds;
    private List<String> users;
    private String accessLink;

    public static class Builder {
        private final Queue newQueue;

        public Builder() {
            newQueue = new Queue();
        }

        public Builder title(String title) {
            newQueue.title = title;
            return this;
        }

        public Builder registrationStart(long registrationStartNanoseconds) {
            newQueue.registrationStartNanoseconds = registrationStartNanoseconds;
            return this;
        }

        public Builder usersNumber(int usersNumber) {
            newQueue.users = Arrays.asList(new String[usersNumber]);
            return this;
        }

        public Queue build() {
            newQueue.accessLink = generateAccessLink();
            return newQueue;
        }

        public String generateAccessLink() {
            StringBuilder sequenceBuilder = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                sequenceBuilder.append(((char) (new Random().nextInt('z' - 'a' + 1) + 'a')));
            }
            return sequenceBuilder.toString();
        }
    }
}