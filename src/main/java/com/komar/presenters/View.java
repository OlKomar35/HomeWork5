package com.komar.presenters;

import com.komar.models.Table;

import java.util.Collection;

public interface View {
    void showTables(Collection<Table> tables);
    void setObserver(ViewObserver observer);
    void printReservationTableResult(int reservationNo);
}
