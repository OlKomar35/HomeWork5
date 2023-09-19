package com.komar.presenters;


import com.komar.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private Model tableModel;
    private View bookingView;

    public BookingPresenter(Model tableModel, View bookingView) {
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this); //инициализация наблюдателя
    }

    public Collection<Table> loadTables() {
        return tableModel.loadTables();
    }

    public void updateTablesUI() {
        bookingView.showTables(loadTables());
    }

    public void updateReservationResultUI(int reservationId) {
        bookingView.printReservationTableResult(reservationId);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = tableModel.reservationTable(orderDate, tableNo, name);
        updateReservationResultUI(reservationNo);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationNo = tableModel.changeReservation(oldReservation, reservationDate, tableNo, name);
        updateReservationResultUI(reservationNo);
    }
}
