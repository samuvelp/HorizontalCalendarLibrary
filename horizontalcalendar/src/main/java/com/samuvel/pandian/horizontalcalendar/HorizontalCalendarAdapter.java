package com.samuvel.pandian.horizontalcalendar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HorizontalCalendarAdapter extends RecyclerView.Adapter<HorizontalCalendarViewHolder> {
    ArrayList<DayDateMonthModel> mDayDateMonthList = new ArrayList<>();
    Context mContext;
    OnDaySelectedListener mOnDaySelectedListener;

    public void setCalendar(Context context, ArrayList<DayDateMonthModel> dayDateMonthList) {
        this.mContext = context;
        this.mDayDateMonthList = dayDateMonthList;
    }

    public void setOnDaySelectedListener(OnDaySelectedListener daySelectedListener) {
        this.mOnDaySelectedListener = daySelectedListener;
    }

    @NonNull
    @Override
    public HorizontalCalendarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_calendar_week, viewGroup, false);
        return new HorizontalCalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HorizontalCalendarViewHolder holder, int position) {
        int i = position * 7;
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

        holder.dayOneMonth.setText(mDayDateMonthList.get(i).month.substring(0, 3));
        holder.dayTwoMonth.setText(mDayDateMonthList.get(i + 1).month.substring(0, 3));
        holder.dayThreeMonth.setText(mDayDateMonthList.get(i + 2).month.substring(0, 3));
        holder.dayFourMonth.setText(mDayDateMonthList.get(i + 3).month.substring(0, 3));
        holder.dayFiveMonth.setText(mDayDateMonthList.get(i + 4).month.substring(0, 3));
        holder.daySixMonth.setText(mDayDateMonthList.get(i + 5).month.substring(0, 3));
        holder.daySevenMonth.setText(mDayDateMonthList.get(i + 6).month.substring(0, 3));
        try {
            if (mDayDateMonthList.get(finalI).isSelected) {
                holder.dayOneHl.setVisibility(View.VISIBLE);
            } else {
                holder.dayOneHl.setVisibility(View.INVISIBLE);
            }
            if (mDayDateMonthList.get(finalI + 1).isSelected) {
                holder.dayTwoHl.setVisibility(View.VISIBLE);
            } else {
                holder.dayTwoHl.setVisibility(View.INVISIBLE);
            }
            if (mDayDateMonthList.get(finalI + 2).isSelected) {
                holder.dayThreeHl.setVisibility(View.VISIBLE);
            } else {
                holder.dayThreeHl.setVisibility(View.INVISIBLE);
            }
            if (mDayDateMonthList.get(finalI + 3).isSelected) {
                holder.dayFourHl.setVisibility(View.VISIBLE);
            } else {
                holder.dayFourHl.setVisibility(View.INVISIBLE);
            }
            if (mDayDateMonthList.get(finalI + 4).isSelected) {
                holder.dayFiveHl.setVisibility(View.VISIBLE);
            } else {
                holder.dayFiveHl.setVisibility(View.INVISIBLE);
            }
            if (mDayDateMonthList.get(finalI + 5).isSelected) {
                holder.daySixHl.setVisibility(View.VISIBLE);
            } else {
                holder.daySixHl.setVisibility(View.INVISIBLE);
            }
            if (mDayDateMonthList.get(finalI + 6).isSelected) {
                holder.daySevenHl.setVisibility(View.VISIBLE);
            } else {
                holder.daySevenHl.setVisibility(View.INVISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.dayOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDaySelectedListener != null)
                    mOnDaySelectedListener.onDaySelected(mDayDateMonthList.get(finalI));

                onItemSelected(finalI);

//                holder.dayOneHl.setVisibility(View.VISIBLE);
//                holder.dayTwoHl.setVisibility(View.INVISIBLE);
//                holder.dayThreeHl.setVisibility(View.INVISIBLE);
//                holder.dayFourHl.setVisibility(View.INVISIBLE);
//                holder.dayFiveHl.setVisibility(View.INVISIBLE);
//                holder.daySixHl.setVisibility(View.INVISIBLE);
//                holder.daySevenHl.setVisibility(View.INVISIBLE);
            }
        });
        holder.dayTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDaySelectedListener != null)
                    mOnDaySelectedListener.onDaySelected((mDayDateMonthList.get(finalI + 1)));
                onItemSelected(finalI + 1);
//                holder.dayOneHl.setVisibility(View.INVISIBLE);
//                holder.dayTwoHl.setVisibility(View.VISIBLE);
//                holder.dayThreeHl.setVisibility(View.INVISIBLE);
//                holder.dayFourHl.setVisibility(View.INVISIBLE);
//                holder.dayFiveHl.setVisibility(View.INVISIBLE);
//                holder.daySixHl.setVisibility(View.INVISIBLE);
//                holder.daySevenHl.setVisibility(View.INVISIBLE);
            }
        });
        holder.dayThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDaySelectedListener != null)
                    mOnDaySelectedListener.onDaySelected((mDayDateMonthList.get(finalI + 2)));
                onItemSelected(finalI + 2);
//                holder.dayOneHl.setVisibility(View.INVISIBLE);
//                holder.dayTwoHl.setVisibility(View.INVISIBLE);
//                holder.dayThreeHl.setVisibility(View.VISIBLE);
//                holder.dayFourHl.setVisibility(View.INVISIBLE);
//                holder.dayFiveHl.setVisibility(View.INVISIBLE);
//                holder.daySixHl.setVisibility(View.INVISIBLE);
//                holder.daySevenHl.setVisibility(View.INVISIBLE);
            }
        });
        holder.dayFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDaySelectedListener != null)
                    mOnDaySelectedListener.onDaySelected((mDayDateMonthList.get(finalI + 3)));
                onItemSelected(finalI + 3);
//                holder.dayOneHl.setVisibility(View.INVISIBLE);
//                holder.dayTwoHl.setVisibility(View.INVISIBLE);
//                holder.dayThreeHl.setVisibility(View.INVISIBLE);
//                holder.dayFourHl.setVisibility(View.VISIBLE);
//                holder.dayFiveHl.setVisibility(View.INVISIBLE);
//                holder.daySixHl.setVisibility(View.INVISIBLE);
//                holder.daySevenHl.setVisibility(View.INVISIBLE);
            }
        });
        holder.dayFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDaySelectedListener != null)
                    mOnDaySelectedListener.onDaySelected((mDayDateMonthList.get(finalI + 4)));
                onItemSelected(finalI + 4);
//                holder.dayOneHl.setVisibility(View.INVISIBLE);
//                holder.dayTwoHl.setVisibility(View.INVISIBLE);
//                holder.dayThreeHl.setVisibility(View.INVISIBLE);
//                holder.dayFourHl.setVisibility(View.INVISIBLE);
//                holder.dayFiveHl.setVisibility(View.VISIBLE);
//                holder.daySixHl.setVisibility(View.INVISIBLE);
//                holder.daySevenHl.setVisibility(View.INVISIBLE);
            }
        });
        holder.daySix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDaySelectedListener != null)
                    mOnDaySelectedListener.onDaySelected((mDayDateMonthList.get(finalI + 5)));
                onItemSelected(finalI + 5);
//                holder.dayOneHl.setVisibility(View.INVISIBLE);
//                holder.dayTwoHl.setVisibility(View.INVISIBLE);
//                holder.dayThreeHl.setVisibility(View.INVISIBLE);
//                holder.dayFourHl.setVisibility(View.INVISIBLE);
//                holder.dayFiveHl.setVisibility(View.INVISIBLE);
//                holder.daySixHl.setVisibility(View.VISIBLE);
//                holder.daySevenHl.setVisibility(View.INVISIBLE);
            }
        });
        holder.daySeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDaySelectedListener != null)
                    mOnDaySelectedListener.onDaySelected((mDayDateMonthList.get(finalI + 6)));
                onItemSelected(finalI + 6);
//                holder.dayOneHl.setVisibility(View.INVISIBLE);
//                holder.dayTwoHl.setVisibility(View.INVISIBLE);
//                holder.dayThreeHl.setVisibility(View.INVISIBLE);
//                holder.dayFourHl.setVisibility(View.INVISIBLE);
//                holder.dayFiveHl.setVisibility(View.INVISIBLE);
//                holder.daySixHl.setVisibility(View.INVISIBLE);
//                holder.daySevenHl.setVisibility(View.VISIBLE);
            }
        });
    }

    private void onItemSelected(int position) {
        for (DayDateMonthModel dayDateMonthModel : mDayDateMonthList) {
            dayDateMonthModel.isSelected = false;
        }
        mDayDateMonthList.get(position).isSelected = true;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDayDateMonthList.size() / 7;
    }

    public interface OnDaySelectedListener {
        void onDaySelected(DayDateMonthModel dayDateMonthModel);
    }
}
