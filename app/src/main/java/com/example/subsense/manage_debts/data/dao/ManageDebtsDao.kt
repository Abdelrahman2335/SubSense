import androidx.room.Dao
import androidx.room.Upsert
import com.example.subsense.debts.data.model.DebtModel


@Dao
interface ManageDebtsDao {

    @Upsert
    fun upsertDebt(debt: DebtModel)
}