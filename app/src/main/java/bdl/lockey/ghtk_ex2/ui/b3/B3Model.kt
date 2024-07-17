package bdl.lockey.ghtk_ex2.ui.b3

import com.google.gson.annotations.SerializedName

data class B3Model(
    val success: Boolean,
    val message: String,
    @SerializedName("full_name") val fullName: String,
    val position: String,
    val history: List<HistoryModel>
) {
}