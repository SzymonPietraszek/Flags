package application;

import application.backend.Backend;
import application.frontend.Frontend;

public class Run {

    public static void main(String[] args) {
        Frontend frontend = new Frontend(new Backend());
    }

}