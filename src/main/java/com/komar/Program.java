package com.komar;

import com.komar.models.TableModel;
import com.komar.presenters.BookingPresenter;
import com.komar.views.BookingView;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);

        bookingPresenter.updateTablesUI();

        System.out.println();
        view.reservationTable(new Date(),2, "Olga");
        view.reservationTable(new Date(),3, "Pavel");
        view.reservationTable(new Date(),5, "Viktoria");
        view.reservationTable(new Date(),2, "Marina");

        System.out.println();
        view.changeReservationTable(101, new Date(),1,"Olga");
    }
}
