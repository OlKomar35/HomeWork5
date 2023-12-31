package com.komar.views;

import com.komar.models.Table;
import com.komar.presenters.BookingPresenter;
import com.komar.presenters.View;
import com.komar.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void showTables(Collection<Table> tables){
        for (Table table: tables){
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void printReservationTableResult(int reservationNo) {
        if(reservationNo >0)
            System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        else
            System.out.println("Не удалось забронировать столик. Попробуйте выполнить операцию позже.");
    }

    public void reservationTable(Date orderDate, int tableNo, String name){
        observer.onReservationTable(orderDate,tableNo,name);
    }

    public void changeReservationTable(int oldReservation,Date reservationDate, int tableNo, String name){
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }
}
