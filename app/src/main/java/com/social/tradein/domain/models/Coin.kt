package com.social.tradein.domain.models

import com.social.tradein.data.models.Tag
import com.social.tradein.data.models.Team

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val logo: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val description: String
)
