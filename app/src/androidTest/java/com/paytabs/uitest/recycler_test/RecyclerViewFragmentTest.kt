package com.paytabs.uitest.recycler_test

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.paytabs.uitest.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerViewFragmentTest {

    @Test
    fun test_RvIsVisible() {
        val launchFragmentInContainer =
            launchFragmentInContainer<RecyclerViewFragment>()
        onView(withId(R.id.rv_names))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_openDetails() {
        val launchFragmentInContainer =
            launchFragmentInContainer<RecyclerViewFragment>()

        onView(withId(R.id.rv_names))
            .perform(actionOnItemAtPosition<VH>(1, click()))

        onView(withId(R.id.tv_det))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tv_det))
            .check(matches(withText("mohamed details")))


    }

}