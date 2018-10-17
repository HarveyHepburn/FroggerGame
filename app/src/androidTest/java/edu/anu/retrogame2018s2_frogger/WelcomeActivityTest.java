package edu.anu.retrogame2018s2_frogger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class WelcomeActivityTest {
    @Rule
    public ActivityTestRule rule = new ActivityTestRule(WelcomeActivity.class, true, false);
    @Test
    public void shouldVenderView() throws Exception{
        rule.launchActivity(new Intent());
        onView(withText("Welcome, please sign up")).check(matches(isDisplayed()));
        onView(withId(R.id.toast)).check(matches(isDisplayed()));
    }
}