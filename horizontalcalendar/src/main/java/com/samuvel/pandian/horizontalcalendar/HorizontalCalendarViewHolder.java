package com.samuvel.pandian.horizontalcalendar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HorizontalCalendarViewHolder extends RecyclerView.ViewHolder {
    TextView dayOneDate, dayTwoDate, dayThreeDate, dayFourDate, dayFiveDate, daySixDate, daySevenDate;
    TextView dayOneDay, dayTwoDay, dayThreeDay, dayFourDay, dayFiveDay, daySixDay, daySevenDay;
    TextView dayOneMonth, dayTwoMonth, dayThreeMonth, dayFourMonth, dayFiveMonth, daySixMonth, daySevenMonth;
    LinearLayout dayOne, dayTwo, dayThree, dayFour, dayFive, daySix, daySeven;
    View dayOneHl, dayTwoHl, dayThreeHl, dayFourHl, dayFiveHl, daySixHl, daySevenHl;

    public HorizontalCalendarViewHolder(@NonNull View itemView) {
        super(itemView);
        dayOneDate = itemView.findViewById(R.id.dayOneDate);
        dayTwoDate = itemView.findViewById(R.id.dayTwoDate);
        dayThreeDate = itemView.findViewById(R.id.dayThreeDate);
        dayFourDate = itemView.findViewById(R.id.dayFourDate);
        dayFiveDate = itemView.findViewById(R.id.dayFiveDate);
        daySixDate = itemView.findViewById(R.id.daySixDate);
        daySevenDate = itemView.findViewById(R.id.daySevenDate);

        dayOneDay = itemView.findViewById(R.id.dayOneDay);
        dayTwoDay = itemView.findViewById(R.id.dayTwoDay);
        dayThreeDay = itemView.findViewById(R.id.dayThreeDay);
        dayFourDay = itemView.findViewById(R.id.dayFourDay);
        dayFiveDay = itemView.findViewById(R.id.dayFiveDay);
        daySixDay = itemView.findViewById(R.id.daySixDay);
        daySevenDay = itemView.findViewById(R.id.daySevenDay);

        dayOneMonth = itemView.findViewById(R.id.dayOneMonth);
        dayTwoMonth = itemView.findViewById(R.id.dayTwoMonth);
        dayThreeMonth = itemView.findViewById(R.id.dayThreeMonth);
        dayFourMonth = itemView.findViewById(R.id.dayFourMonth);
        dayFiveMonth = itemView.findViewById(R.id.dayFiveMonth);
        daySixMonth = itemView.findViewById(R.id.daySixMonth);
        daySevenMonth = itemView.findViewById(R.id.daySevenMonth);

        dayOne = itemView.findViewById(R.id.dayOne);
        dayTwo = itemView.findViewById(R.id.dayTwo);
        dayThree = itemView.findViewById(R.id.dayThree);
        dayFour = itemView.findViewById(R.id.dayFour);
        dayFive = itemView.findViewById(R.id.dayFive);
        daySix = itemView.findViewById(R.id.daySix);
        daySeven = itemView.findViewById(R.id.daySeven);

        dayOneHl = itemView.findViewById(R.id.dayOneHighLight);
        dayTwoHl = itemView.findViewById(R.id.dayTwoHighLight);
        dayThreeHl = itemView.findViewById(R.id.dayThreeHighLight);
        dayFourHl = itemView.findViewById(R.id.dayFourHighLight);
        dayFiveHl = itemView.findViewById(R.id.dayFiveHighLight);
        daySixHl = itemView.findViewById(R.id.daySixHighLight);
        daySevenHl = itemView.findViewById(R.id.daySevenHighLight);
    }
}
