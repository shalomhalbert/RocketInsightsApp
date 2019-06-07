package com.example.shalomhalbert.rocketinsightsapp.model.fake

import com.example.shalomhalbert.rocketinsightsapp.model.Date
import retrofit2.HttpException
import retrofit2.Response

sealed class FakeServiceConfigurations
data class FilledList(val filledList: List<Date> = defaultResponse) : FakeServiceConfigurations() {
    companion object {
        val defaultResponse = listOf(Date("2017-02-12"), Date("2017-02-11"),
            Date("2017-02-10"), Date("2017-02-09"), Date("2017-02-08"))
    }
}
data class EmptyList(val emptyList: List<Date> = defaultResponse): FakeServiceConfigurations() {
    companion object {
        val defaultResponse = emptyList<Date>()
    }
}
data class HttpError(val httpException: HttpException = HttpException(Response.success(""))): FakeServiceConfigurations() {
    companion object {
        val defaultResponse = emptyList<Date>()
        //Todo: You can add specific HttpExceptions so they are tested for as well
    }
}
data class Throw(val throwable: Throwable = defaultResponse): FakeServiceConfigurations() {
    companion object {
        val defaultResponse = Throwable()
        //Todo: You can add specific Throwables so they are tested
    }
}