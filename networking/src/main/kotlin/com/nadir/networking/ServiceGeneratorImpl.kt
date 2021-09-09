package com.nadir.networking

class ServiceGeneratorImpl: ServiceGenerator {

    private fun makeCall(url: String): String = "{$url}"

    override fun execute(url: String): String = makeCall(url)
}