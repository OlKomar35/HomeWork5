package com.komar.models;

import com.komar.presenters.Model;

import java.util.*;
import java.util.stream.Collectors;

public class TableModel implements Model {
    private Collection<Table> tables;

    /**
     * Получить список всех столиков
     *
     * @return коллекция столиков
     */

    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate дата
     * @param tableNo         номер столика
     * @param name            имя клиента
     * @return номер брони
     */
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        Optional<Table> table = loadTables().stream().filter(t -> t.getNo() == tableNo).findFirst();
        if (table.isPresent()) {
            Reservation reservation = new Reservation(reservationDate, name);
            table.get().getReservations().add(reservation);
            return reservation.getId();
        }
        return -1;
        //throw  new RuntimeException("Некорректный номер столика");
    }

    public int changeReservation(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : loadTables()) {
            Collection<Reservation> reservations = table.getReservations();
            for (Reservation reservation : reservations) {
                if (reservation.getId() == oldReservation) {
                    reservations.remove(reservation);
                    return reservationTable(reservationDate, tableNo, name);
                }
            }
        }
        return -1;
    }
}
