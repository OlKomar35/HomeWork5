package com.komar.presenters;

import com.komar.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    Collection<Table> loadTables();
    int reservationTable(Date reservationDate, int tableNo, String name);
    int changeReservation(int oldReservation, Date reservationDate, int tableNo, String name);
}
