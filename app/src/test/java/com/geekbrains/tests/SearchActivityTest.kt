package com.geekbrains.tests

import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.view.search.MainActivity
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SearchActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun `recyclerView attached`() {
        scenario.onActivity {
            val recyclerView: RecyclerView = it.attachView(it.findViewById(R.id.recyclerView))
            TestCase.assertNotNull(recyclerView)
        }
    }

    @Test
    fun `recyclerView detached`() {
        scenario.onActivity {
            var totalCountTextView: RecyclerView? = it.findViewById<RecyclerView>(R.id.recyclerView)
            totalCountTextView = it.detachView() as RecyclerView?
            TestCase.assertNull(totalCountTextView)
        }
    }

    @After
    fun close() {
        scenario.close()
    }
}