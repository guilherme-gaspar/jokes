package com.guilhermegaspar.jokes

import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.presentation.JokeActivity
import com.guilhermegaspar.jokes.features.jokes.presentation.JokeState
import com.guilhermegaspar.jokes.features.jokes.presentation.JokeViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.ext.android.viewModel

@RunWith(AndroidJUnit4::class)
class JokeActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(JokeActivity::class.java)

    private val viewModel: JokeViewModel = mockk()
    private val jokeLiveData = MutableLiveData<JokeState>()

    @Before
    fun setup() {
        every { viewModel.state } returns jokeLiveData
    }

    @Test
    fun whenActivityCreate_shouldDisplauLoadingView() {
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
    }

}