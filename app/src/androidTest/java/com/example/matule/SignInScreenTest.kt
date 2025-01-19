package com.example.matule

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.matule.presentation.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class SignInScreenTest {
    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private fun initTest() {
        composeTestRule.waitUntil {
            composeTestRule
                .onAllNodesWithTag("sign_in")
                .fetchSemanticsNodes().size == 1
        }
    }

    @Test
    fun isNotValidEmail_modalShowed() {
        initTest()
        composeTestRule.onNodeWithTag("email").performTextInput("mail")
        composeTestRule.onNodeWithTag("password").performTextInput("Qw123%rty")
        composeTestRule.onNodeWithTag("sign_in").performClick()

        composeTestRule.onNodeWithTag("not_valid_email_modal").assertIsDisplayed()
    }

    @Test
    fun isNotValidPassword_modalShowed() {
        initTest()
        composeTestRule.onNodeWithTag("email").performTextInput("mail@mail.com")
        composeTestRule.onNodeWithTag("password").performTextInput("pass")
        composeTestRule.onNodeWithTag("sign_in").performClick()

        composeTestRule.onNodeWithTag("not_valid_password_modal").assertIsDisplayed()
    }

    @Test
    fun authorization_isSuccess() {
        initTest()
        composeTestRule.onNodeWithTag("email").performTextInput("mail@mail.com")
        composeTestRule.onNodeWithTag("password").performTextInput("Qw123%rty")
        composeTestRule.onNodeWithTag("sign_in").performClick()
        composeTestRule.waitUntil {
            composeTestRule
                .onAllNodesWithTag("home_screen")
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithTag("home_screen").assertIsDisplayed()
    }

    @Test
    fun authorization_isFail() {
        initTest()
        composeTestRule.waitUntil {
            composeTestRule
                .onAllNodesWithTag("sign_in")
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithTag("email").performTextInput("mail@mail.com")
        composeTestRule.onNodeWithTag("password").performTextInput("Qw123%rty56")
        composeTestRule.onNodeWithTag("sign_in").performClick()
        composeTestRule.onNodeWithTag("authorization_failed").assertIsDisplayed()
    }
}