package com.nadir.networking

interface ServiceGenerator<T> {

    fun execute(url: String): FlowT

}