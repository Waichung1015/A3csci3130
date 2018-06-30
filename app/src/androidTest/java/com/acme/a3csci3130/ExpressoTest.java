package com.acme.a3csci3130;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.typeText;
import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;

public class ExpressoTest {
    @Rule
    public ActivityTestRule<MainActivity> myact = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void enterCorrect(){// correct case
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.businessNum)).perform(typeText("123456789"),closeSoftKeyboard());
        onView(withId(R.id.name)).perform(typeText("Ivy"),closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("ivywu808@ymail.com"),closeSoftKeyboard());
        onView(withId(R.id.businessType)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("6050 University Avenue"),closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("NS"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());

    }
    @Test
    public void enterFalse(){// false entry, wrong business num
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.businessNum)).perform(typeText("1234567890"),closeSoftKeyboard());
        onView(withId(R.id.name)).perform(typeText("Amy"),closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("Amy.F@ymail.com"),closeSoftKeyboard());
        onView(withId(R.id.businessType)).perform(typeText("Fish Monger"),closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("6050 University Avenue"),closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("AB"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());

    }
}
