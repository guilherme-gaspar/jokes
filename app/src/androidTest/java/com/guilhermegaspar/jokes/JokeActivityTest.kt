package com.guilhermegaspar.jokes

import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.activity.JokeActivity
import com.guilhermegaspar.jokes.features.jokes.presentation.model.JokeState
import com.guilhermegaspar.jokes.features.jokes.presentation.viewmodel.JokeViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JokeActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(JokeActivity::class.java)

    private val viewModel: JokeViewModel = mockk()
    private val state = MutableStateFlow(JokeState())

    @Before
    fun setup() {
        every { viewModel.state } returns state
    }

    @Test
    fun whenActivityCreate_shouldDisplauLoadingView() {
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
    }

}