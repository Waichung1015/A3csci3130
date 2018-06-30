package com.acme.a3csci3130;
import android.support.test.rule.ActivityTestRule;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.AllOf.allOf;
import org.junit.Rule;
import org.junit.Test;

public class EraseTest {
    @Rule
    public ActivityTestRule<MainActivity> myact = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void remove() throws Exception{
        Thread.sleep(5000);
        onData(anything()).inAdapterView(allOf(withId(R.id.listView), isCompletelyDisplayed())).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());

    }
}

