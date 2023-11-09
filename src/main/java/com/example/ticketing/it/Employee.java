package com.example.ticketing.it;

public class Employee {

    private Printer printer;

    public void createTicket() {
        printer.printTicket();
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
