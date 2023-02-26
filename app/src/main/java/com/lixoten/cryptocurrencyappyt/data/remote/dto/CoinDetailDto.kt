package com.lixoten.cryptocurrencyappyt.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.lixoten.cryptocurrencyappyt.domain.model.CoinDetail

data class CoinDetailDto(
    val contract: String,
    val contracts: List<Contract>,
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    val parent: Parent,
    val platform: String,
    @SerializedName("proof_type")
    val proofType: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)
// Here we map from CoinDto to Coin
fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        isActive = isActive,
        name = name,
        description = description,
        rank = rank,
        symbol = symbol,
        tags = tags.map { it.name },
        team = team
    )
}