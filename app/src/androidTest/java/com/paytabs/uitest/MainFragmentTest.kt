package com.paytabs.uitest

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.paytabs.uitest.custom_matchers.ToastMatcher
import org.hamcrest.CoreMatchers.not
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainFragmentTest {

    @Test
    fun test_TvIsVisible() {
        val launchFragmentInContainer =
            launchFragmentInContainer<MainFragment>(fragmentArgs = bundleOf(ARG_PARAM1 to "tt"))
        launchFragmentInContainer.moveToState(Lifecycle.State.STARTED)
        onView(withId(R.id.tv_hello_blank)).check(matches(isDisplayed()))
    }

    @Test
    fun test_argumentsTextDisplayed() {
        val launchFragmentInContainer =
            launchFragmentInContainer<MainFragment>(fragmentArgs = bundleOf(ARG_PARAM1 to "tt"))
        launchFragmentInContainer.moveToState(Lifecycle.State.RESUMED)
        onView(withId(R.id.tv_hello_blank)).check(matches(withText("tt")))
    }

    @Test
    fun test_toastIsDisplayed() {
        val launchFragmentInContainer =
            launchFragmentInContainer<MainFragment>()
        onView(withId(R.id.btn_showToast)).perform(click())
        onView(withText(R.string.toast_msg)).inRoot(ToastMatcher()).check(matches(isDisplayed()))

    }

    @Test
    fun test_dialogIsDisplayed() {
        val launchFragmentInContainer =
            launchFragmentInContainer<MainFragment>()
        onView(withId(R.id.btn_showDialog)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
        onView(withText(R.string.text_enter_name)).perform(typeText("Ola"))
        onView(withText(R.string.text_ok)).perform(click())
        onView(withId(R.id.tv_hello_blank)).check(matches(withText("Ola")))
    }

    @Test
    fun test_checkbox() {
        val launchFragmentInContainer =
            launchFragmentInContainer<MainFragment>()
        onView(withId(R.id.chb_disappear)).perform(click())
        onView(withId(R.id.tv_hello_blank)).check(matches(not(isDisplayed())))
        onView(withId(R.id.btn_showDialog)).check(matches(not(isDisplayed())))
        onView(withId(R.id.btn_showToast)).check(matches(not(isDisplayed())))
    }


}