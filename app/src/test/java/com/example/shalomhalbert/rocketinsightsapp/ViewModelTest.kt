package com.example.shalomhalbert.rocketinsightsapp

import com.example.shalomhalbert.rocketinsightsapp.model.Service
import com.example.shalomhalbert.rocketinsightsapp.model.fake.*
import com.example.shalomhalbert.rocketinsightsapp.viewmodel.MainViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertFailsWith

class ViewModelTest : KoinTest {

    private val viewModel: MainViewModel by inject()
    private val service: Service by inject()

    @Before
    fun before() {
        //Replaces Service with FakeService, and changes ViewModel CoroutineContext to Unconfined
        val testModule = module {
            single<Service>(override = true) { FakeService() }
            single(override = true) { Dispatchers.Unconfined }
        }

        startKoin { modules(listOf(modelModules, viewModelModules, testModule)) }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `Dates returns filled list`() = runBlocking {
        updateServiceConfig(FilledList())

        //Join removes the need for using CourtineScope
        viewModel.onUpdateList().join()

        val dates = viewModel.dates.get()
        val expected = FilledList.defaultResponse
        assertEquals(expected, dates)
    }

    @Test
    fun `Date returns empty list`() = runBlocking {
        updateServiceConfig(EmptyList())

        viewModel.onUpdateList().join()

        val dates = viewModel.dates.get()
        val expected = EmptyList.defaultResponse
        assertEquals(expected, dates)

    }

    @Test
    fun `Date throws HttpException and returns an empty list`() = runBlocking {
        updateServiceConfig(HttpError())

        viewModel.onUpdateList().join()

        val dates = viewModel.dates.get()
        val expected = HttpError.defaultResponse
        assertEquals(expected, dates)
    }

    @Test(expected = Throwable::class)
    fun `Date throws Throwable`() = runBlocking {
        updateServiceConfig(Throw())

        viewModel.onUpdateList().join()

        assertFailsWith<Throwable> { viewModel.dates.get() }
        Unit
    }

    private fun updateServiceConfig(newConfig: FakeServiceConfigurations) {
        val fakeService = service as FakeService
        fakeService.configuration = newConfig
    }
}