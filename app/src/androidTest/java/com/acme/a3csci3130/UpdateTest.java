package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.AllOf.allOf;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.clearText;


import static android.support.test.espresso.action.ViewActions.typeText;
public class UpdateTest {
    @Rule
    public ActivityTestRule<MainActivity> myact = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void update()throws Exception {
        Thread.sleep(5000);
        onData(anything()).inAdapterView(allOf(withId(R.id.listView), isCompletelyDisplayed())).atPosition(0).perform(click());
        onView(withId(R.id.name)).perform(clearText());
        onView(withId(R.id.name)).perform(typeText("Ben"),closeSoftKeyboard());
        onView(withId(R.id.businessType)).perform(clearText());
        onView(withId(R.id.businessType)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());


    }
}
