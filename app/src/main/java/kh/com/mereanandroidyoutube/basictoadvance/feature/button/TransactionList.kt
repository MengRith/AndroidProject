package kh.com.mereanandroidyoutube.basictoadvance.feature.button


val transactionList = listOf(

    TransactionModel(
        id = "TRX001",
        title = "Transfer to Sok Dara",
        amount = 120.50,
        currency = "USD",
        date = "2026-05-24 08:30",
        receiver = "Sok Dara",
        status = TransactionStatus.SUCCESS,
        type = TransactionType.BILL_PAYMENT
    ),

    TransactionModel(
        id = "TRX002",
        title = "KHQR Coffee Payment",
        amount = 3.75,
        currency = "USD",
        date = "2026-05-24 09:10",
        receiver = "Brown Coffee",
        status = TransactionStatus.SUCCESS,
        type = TransactionType.KHQR
    ),

    TransactionModel(
        id = "TRX003",
        title = "Mobile Top Up",
        amount = 5.00,
        currency = "USD",
        date = "2026-05-24 10:00",
        receiver = "Smart Axiata",
        status = TransactionStatus.SUCCESS,
        type = TransactionType.MOBILE_TOPUP
    ),

    TransactionModel(
        id = "TRX004",
        title = "Electricity Bill",
        amount = 18.25,
        currency = "USD",
        date = "2026-05-23 18:45",
        receiver = "EDC Cambodia",
        status = TransactionStatus.PENDING,
        type = TransactionType.TRANSFER
    ),

    TransactionModel(
        id = "TRX005",
        title = "ABA Bank Transfer",
        amount = 250.00,
        currency = "USD",
        date = "2026-05-23 14:20",
        receiver = "Chan Makara",
        status = TransactionStatus.SUCCESS,
        type = TransactionType.MOBILE_TOPUP
    ),

    TransactionModel(
        id = "TRX006",
        title = "Food Delivery",
        amount = 12.40,
        currency = "USD",
        date = "2026-05-22 19:15",
        receiver = "Nham24",
        status = TransactionStatus.SUCCESS,
        type = TransactionType.BILL_PAYMENT
    ),

    TransactionModel(
        id = "TRX007",
        title = "ATM Cash Withdraw",
        amount = 100.00,
        currency = "USD",
        date = "2026-05-22 11:30",
        receiver = "Chip Mong ATM",
        status = TransactionStatus.SUCCESS,
        type = TransactionType.KHQR
    ),

    TransactionModel(
        id = "TRX008",
        title = "Internet Bill",
        amount = 15.99,
        currency = "USD",
        date = "2026-05-21 20:10",
        receiver = "Metfone",
        status = TransactionStatus.FAILED,
        type = TransactionType.INTERNET
    ),

    TransactionModel(
        id = "TRX009",
        title = "School Fee Payment",
        amount = 320.00,
        currency = "USD",
        date = "2026-05-20 07:50",
        receiver = "BELTEI School",
        status = TransactionStatus.SUCCESS,
        type = TransactionType.SCHOOL_FEE
    ),

    TransactionModel(
        id = "TRX010",
        title = "Wing Transfer",
        amount = 45.00,
        currency = "USD",
        date = "2026-05-19 16:25",
        receiver = "Mom Vanna",
        status = TransactionStatus.SUCCESS,
        type = TransactionType.WING_TRANSFER
    )
)