package com.example.popularlibs

import com.example.popularlibs.exponentiation.ExponentiationPresenter
import org.junit.Assert
import org.junit.Test

class LoginParserTest {

    private val presenter = ExponentiationPresenter()

    @Test
    fun exponentiationPresenter_checkNumberIsNotEmpty_Exception() {
        presenter.checkNumberIsNotEmpty("")
            .test()
            .assertError(Exception::class.java)
            .assertNoValues()
    }

    @Test
    fun exponentiationPresenter_checkNumberIsNotEmpty_NotNull() {
        presenter.checkNumberIsNotEmpty("123")
            .test()
            .assertComplete()
            .assertValue { str: String ->
                Assert.assertNotNull(str)
                true
            }
    }

    @Test
    fun exponentiationPresenter_checkNumberIsNotEmpty_EqualsSuccess() {
        presenter.checkNumberIsNotEmpty("123")
            .test()
            .assertComplete()
            .assertValue { str: String ->
                Assert.assertEquals("123", str)
                true
            }
    }

    @Test
    fun exponentiationPresenter_checkNumberIsInt_Exception() {
        presenter.checkNumberIsInt("ten")
            .test()
            .assertError(Exception::class.java)
            .assertNoValues()
    }

    @Test
    fun exponentiationPresenter_checkNumberIsInt_Success() {
        presenter.checkNumberIsInt("11")
            .test()
            .assertComplete()
            .assertValue { int: Int ->
                Assert.assertNotNull(int)
                true
            }
    }

    @Test
    fun exponentiationPresenter_checkNumberIsInt_EqualsSuccess() {
        presenter.checkNumberIsInt("11")
            .test()
            .assertComplete()
            .assertValue { int: Int ->
                Assert.assertEquals(11, int)
                true
            }
    }

    @Test
    fun exponentiationPresenter_exponentiationNumber_NotNull() {
        presenter.exponentiationNumber(2)
            .test()
            .assertComplete()
            .assertValue { int: Int ->
                Assert.assertNotNull(int)
                true
            }
    }

    @Test
    fun exponentiationPresenter_exponentiationNumber_EqualsSuccess() {
        presenter.exponentiationNumber(2)
            .test()
            .assertComplete()
            .assertValue { int: Int ->
                Assert.assertEquals(4, int)
                true
            }
    }
}