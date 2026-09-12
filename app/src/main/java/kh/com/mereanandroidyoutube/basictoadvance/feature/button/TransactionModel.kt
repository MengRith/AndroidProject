package kh.com.mereanandroidyoutube.basictoadvance.feature.button

data class TransactionModel(
    val id: String,
    val title: String,
    val amount: Double,
    val currency: String,
    val date: String,
    val receiver: String,
    val status: TransactionStatus,
    val type: TransactionType,
)
