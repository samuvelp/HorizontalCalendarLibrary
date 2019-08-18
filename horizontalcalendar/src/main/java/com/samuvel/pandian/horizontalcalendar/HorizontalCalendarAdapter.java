package com.samuvel.pandian.horizontalcalendar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class HorizontalCalendarAdapter extends RecyclerView.Adapter<HorizontalCalendarViewHolder> {
    ArrayList<DayDateMonthModel> mDayDateMonthList = new ArrayList<>();
    Context mContext;

    public void setCalendar(Context context, ArrayList<DayDateMonthModel> dayDateMonthList) {
        this.mContext = context;
        this.mDayDateMonthList = dayDateMonthList;
    }

    @NonNull
    @Override
    public HorizontalCalendarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_calendar_week, viewGroup, false);
        return new HorizontalCalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalCalendarViewHolder holder, int i) {
        showToast(""+i);
        i = i * 7;
        final int finalI = i;
        holder.dayOneDate.setText(mDayDateMonthList.get(i).date);
        holder.dayTwoDate.setText(mDayDateMonthList.get(i + 1).date);
        holder.dayThreeDate.setText(mDayDateMonthList.get(i + 2).date);
        holder.dayFourDate.setText(mDayDateMonthList.get(i + 3).date);
        holder.dayFiveDate.setText(mDayDateMonthList.get(i + 4).date);
        holder.daySixDate.setText(mDayDateMonthList.get(i + 5).date);
        holder.daySevenDate.setText(mDayDateMonthList.get(i + 6).date);

        holder.dayOneDay.setText(mDayDateMonthList.get(i).day);
        holder.dayTwoDay.setText(mDayDateMonthList.get(i + 1).day);
        holder.dayThreeDay.setText(mDayDateMonthList.get(i + 2).day);
        holder.dayFourDay.setText(mDayDateMonthList.get(i + 3).day);
        holder.dayFiveDay.setText(mDayDateMonthList.get(i + 4).day);
        holder.daySixDay.setText(mDayDateMonthList.get(i + 5).day);
        holder.daySevenDay.setText(mDayDateMonthList.get(i + 6).day);

        holder.dayOneMonth.setText(mDayDateMonthList.get(i).month.substring(0,3));
        holder.dayTwoMonth.setText(mDayDateMonthList.get(i + 1).month.substring(0,3));
        holder.dayThreeMonth.setText(mDayDateMonthList.get(i + 2).month.substring(0,3));
        holder.dayFourMonth.setText(mDayDateMonthList.get(i + 3).month.substring(0,3));
        holder.dayFiveMonth.setText(mDayDateMonthList.get(i + 4).month.substring(0,3));
        holder.daySixMonth.setText(mDayDateMonthList.get(i + 5).month.substring(0,3));
        holder.daySevenMonth.setText(mDayDateMonthList.get(i + 6).month.substring(0,3));

        holder.dayOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(mDayDateMonthList.get(finalI).date);
            }
        });
        holder.dayTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(mDayDateMonthList.get(finalI + 1).date);
            }
        });
        holder.dayThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(mDayDateMonthList.get(finalI + 2).date);
            }
        });
        holder.dayFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(mDayDateMonthList.get(finalI + 3).date);
            }
        });
        holder.dayFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(mDayDateMonthList.get(finalI + 4).date);
            }
        });
        holder.daySix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(mDayDateMonthList.get(finalI + 5).date);
            }
        });
        holder.daySeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(mDayDateMonthList.get(finalI + 6).date);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDayDateMonthList.size() / 7;
    }

    private void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
