package com.guilhermegaspar.jokes.features.jokes.data

import com.guilhermegaspar.jokes.features.jokes.data.remote.service.JokeService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import kotlin.time.ExperimentalTime

@ExperimentalTime
class JokeIntegrationTest {

    private val mockWebServer = MockWebServer()
    private val baseUrl = mockWebServer.url("/").toString()
    private val service = createRetrofit()

    private fun createRetrofit(): JokeService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeService::class.java)
    }

    @Test
    fun getRandomJoke_sentRequest_andReturnsSuccess() {
        runBlocking {
            // Given
            enqueueMockResponse()

            // When
            val result = service.getRandomJoke()
            val request = mockWebServer.takeRequest()

            // Then
            assertEquals("/jokes/random", request.path)
            // assertEquals(result, request.body.readUtf8())
        }
    }

    private fun enqueueMockResponse() {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream("success.json")
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charset.defaultCharset()))
            mockWebServer.enqueue(mockResponse)
        }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}