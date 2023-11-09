package com.example.ticketing.it;

public class TicketOffice {

    private Employee employee;

    public void printTickets() {
        for (int i = 0; i < 5; i++) {
            employee.createTicket();
        }
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
