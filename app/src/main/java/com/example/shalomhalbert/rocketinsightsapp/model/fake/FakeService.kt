package com.example.shalomhalbert.rocketinsightsapp.model.fake

import com.example.shalomhalbert.rocketinsightsapp.model.Date
import com.example.shalomhalbert.rocketinsightsapp.model.Service
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class FakeService(var configuration: FakeServiceConfigurations = FilledList()) : Service {

    override fun dates(): Deferred<List<Date>> = GlobalScope.async {
        when (configuration) {
            is FilledList -> FilledList.defaultResponse
            is EmptyList -> EmptyList.defaultResponse
            is HttpError -> HttpError.defaultResponse
            is Throw -> throw Throw.defaultResponse
        }
    }
}