import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import java.util.*

data class LedgerActivityDetail(

    @set:JsonProperty("TransactionType")
    var loanType: String? = null,

    @set:JsonProperty("Amount")
    var amount: String? = null
)


@JsonRootName("LedgerActivityObject")
data class LedgerActivity(

    @set:JsonProperty("LedgerTransactionDate")
    var LedgerTransactionDate: String? = null,

    @set:JsonProperty("Amount")
    var amount: String? = null,

    // HERE IS WHERE THE MAGIC HAPPENS!!!
    @set:JsonAlias("LedgerTransactionDetails", "LedgerActivityDetailObject")
    var LedgerActivityDetails: List<LedgerActivityDetail> = ArrayList()
)


@JsonRootName("ArrayOfLedgerActivityObject")
data class LedgerActivities(

    @set:JsonProperty("LedgerActivityObject")
    var ledgerActivities: List<LedgerActivity> = ArrayList()
)