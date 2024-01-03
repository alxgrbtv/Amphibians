package com.alxgrbdev.amphibians.fake

import com.alxgrbdev.amphibians.model.Amphibian

object FakeDataSource {
    const val nameOne = "name1"
    const val nameTwo = "name2"
    const val typeOne = "type1"
    const val typeTwo = "type2"
    const val descriptionOne = "desc1"
    const val descriptionTwo = "desc2"
    const val imgOne = "url.1"
    const val imgTwo = "url.2"

    val amphibiansList = listOf(
        Amphibian(nameOne, typeOne, descriptionOne, imgOne),
        Amphibian(nameTwo, typeTwo, descriptionTwo, imgTwo)
    )
}