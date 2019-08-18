package com.samuvel.pandian.horizontalcalendar;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HorizontalCalendarView extends LinearLayout implements HorizontalCalendarAdapter.OnDaySelectedListener {
    RecyclerView mCalendarRecyclerView;
    ArrayList<DayDateMonthModel> calendarList;
    int lastPosition = -1;
    Calendar cal;
    Calendar calPrevious;
    DateFormat dateFormat;
    Date date;
    private int loadCount = 7;
    private int maxWeek = 2;
    private int weekNo = 1;
    private int currentPosition = 1;
    HorizontalCalendarListener mHorizontalCalendarListener;
    LinearLayout mPreviousButton, mNextButton;

    public HorizontalCalendarView(Context context) {
        super(context);
        init();
    }

    public HorizontalCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalCalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setHorizontalCalendarListener(HorizontalCalendarListener horizontalCalendarListener) {
        this.mHorizontalCalendarListener = horizontalCalendarListener;
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.horizontal_calendar_view, this);
        mCalendarRecyclerView = view.findViewById(R.id.horizontalCalendarRv);
        mPreviousButton = view.findViewById(R.id.swipe_left);
        mNextButton = view.findViewById(R.id.swipe_right);
        prepareData();
        setRecyclerView();
        setScrollListener();
        setClickListeners();
    }

    private void setClickListeners() {
        mPreviousButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPosition > 0)
                    mCalendarRecyclerView.smoothScrollToPosition(currentPosition - 1);
            }
        });
        mNextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPosition < (calendarList.size() / 7))
                    mCalendarRecyclerView.smoothScrollToPosition(currentPosition + 1);
            }
        });
    }

    private void setRecyclerView() {
        HorizontalCalendarAdapter horizontalCalendarAdapter = new HorizontalCalendarAdapter();
        horizontalCalendarAdapter.setCalendar(getContext(), calendarList);
        horizontalCalendarAdapter.setOnDaySelectedListener(this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), HORIZONTAL, false);
        mCalendarRecyclerView.setLayoutManager(linearLayoutManager);
        SnapHelper snapHelperOneByOne = new SnapHelperOneByOne();
        snapHelperOneByOne.attachToRecyclerView(mCalendarRecyclerView);
        mCalendarRecyclerView.setAdapter(horizontalCalendarAdapter);
        mCalendarRecyclerView.smoothScrollToPosition(1);
        horizontalCalendarAdapter.notifyDataSetChanged();
    }

    private void setScrollListener() {
        mCalendarRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int myCellWidth = mCalendarRecyclerView.getChildAt(0).getWidth();
                final int offset = mCalendarRecyclerView.computeHorizontalScrollOffset();
                if (offset % myCellWidth == 0) {
                    final int position = offset / myCellWidth;
                    if (lastPosition != position) {
                        lastPosition = position;
                        currentPosition = position;
                        if (mHorizontalCalendarListener != null) {
                            mHorizontalCalendarListener.onCalendarSwiped(getDates(position + 1));
                        }
                    }
                }
            }
        });
    }

    private ArrayList<String> getDates(int weekNo) {
        this.weekNo = weekNo;
        ArrayList<String> dates = new ArrayList<>();
        int lastDayInSet = weekNo * 7;
        int previousDate = lastDayInSet - 8;
        int lastDate = lastDayInSet;
        if ((lastDayInSet - 8) > 0) {
            String pd = calendarList.get(previousDate).year
                    + calendarList.get(previousDate).monthNumeric
                    + calendarList.get(previousDate).date;
            dates.add(pd);
            Log.d("HorizontalCalendarDate", pd);
        }
        for (int i = lastDayInSet - 7; i < lastDayInSet; i++) {
            String day = calendarList.get(i).year
                    + calendarList.get(i).monthNumeric
                    + calendarList.get(i).date;
            dates.add(day);
            Log.d("HorizontalCalendarDate", day);
        }
        if (lastDate < calendarList.size()) {
            String ld = calendarList.get(lastDate).year
                    + calendarList.get(lastDate).monthNumeric
                    + calendarList.get(lastDate).date;
            dates.add(ld);
            Log.d("HorizontalCalendarDate", ld);
        }
        return dates;
    }

    private void prepareData() {
        int previousWeekDayCount = 7;
        int lastWeekDayCount = 1;
        calendarList = new ArrayList<>();
        dateFormat = new SimpleDateFormat("MMMM-EEE-yyyy-MM-dd");
        date = new Date();
        DayDateMonthModel currentDayModel = new DayDateMonthModel();
        String currentDate = dateFormat.format(date).toString();
        String[] parts = currentDate.split(" ");
        String[] partsDate = currentDate.split("-");
        currentDayModel.month = partsDate[0];
        currentDayModel.date = partsDate[4];
        currentDayModel.day = partsDate[1];
        currentDayModel.year = partsDate[2];
        currentDayModel.monthNumeric = partsDate[3];
        currentDayModel.isSelected = true;
        currentDayModel.isToday = true;
        calPrevious = Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.setTime(date);
        calPrevious.setTime(date);

        if (currentDayModel.day.equalsIgnoreCase("mon")) {
            previousWeekDayCount = 7;
            lastWeekDayCount = 1;
        } else if (currentDayModel.day.equalsIgnoreCase("tue")) {
            previousWeekDayCount = 8;
            lastWeekDayCount = 2;
        } else if (currentDayModel.day.equalsIgnoreCase("wed")) {
            previousWeekDayCount = 9;
            lastWeekDayCount = 3;
        } else if (currentDayModel.day.equalsIgnoreCase("thu")) {
            previousWeekDayCount = 10;
            lastWeekDayCount = 4;
        } else if (currentDayModel.day.equalsIgnoreCase("fri")) {
            previousWeekDayCount = 11;
            lastWeekDayCount = 5;
        } else if (currentDayModel.day.equalsIgnoreCase("sat")) {
            previousWeekDayCount = 12;
            lastWeekDayCount = 6;
        } else if (currentDayModel.day.equalsIgnoreCase("sun")) {
            previousWeekDayCount = 13;
            lastWeekDayCount = 7;
        }


        for (int i = 0; i < previousWeekDayCount; i++) {
            calPrevious.add(Calendar.DAY_OF_WEEK, -1);
            String nextDate = dateFormat.format(calPrevious.getTime());
            DayDateMonthModel previousDayMode = new DayDateMonthModel();
            String[] partsNextDate = nextDate.split("-");
            previousDayMode.month = partsNextDate[0];
            previousDayMode.date = partsNextDate[4];
            previousDayMode.day = partsNextDate[1];
            previousDayMode.year = partsNextDate[2];
            previousDayMode.monthNumeric = partsNextDate[3];
            previousDayMode.isToday = false;
            calendarList.add(0, previousDayMode);
        }
        calendarList.add(currentDayModel);

        for (int i = 0; i < ((loadCount * maxWeek) - lastWeekDayCount); i++) {
            cal.add(Calendar.DAY_OF_WEEK, 1);
            String nextDate = dateFormat.format(cal.getTime());
            DayDateMonthModel currentDayMode = new DayDateMonthModel();
            String[] partsNextDate = nextDate.split("-");
            currentDayMode.month = partsNextDate[0];
            currentDayMode.date = partsNextDate[4];
            currentDayMode.day = partsNextDate[1];
            currentDayMode.year = partsNextDate[2];
            currentDayMode.monthNumeric = partsNextDate[3];
            currentDayMode.isToday = false;
            calendarList.add(currentDayMode);

        }

    }

    @Override
    public void onDaySelected(DayDateMonthModel dayDateMonthModel) {
        if (mHorizontalCalendarListener != null)
            mHorizontalCalendarListener.onDaySelected(dayDateMonthModel);
    }

    public interface HorizontalCalendarListener {
        void onCalendarSwiped(ArrayList<String> dates);

        void onDaySelected(DayDateMonthModel dayDateMonthModel);
    }
}
