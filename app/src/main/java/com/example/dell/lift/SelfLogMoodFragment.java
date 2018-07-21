package com.example.dell.lift;

/**
 * Created by Dell on 04-Aug-17.
 */

public enum SelfLogMoodFragment {
    First(R.string.first,R.layout.fragment_first_mood_log),
    Second(R.string.second, R.layout.fragment_second_mood_log),
    Third(R.string.third, R.layout.fragment_third_mood_log),
    Fourth(R.string.fourth, R.layout.fragment_fourth_mood_log);

    private int mTitleResId;
    private int mLayoutResId;

    SelfLogMoodFragment(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}

