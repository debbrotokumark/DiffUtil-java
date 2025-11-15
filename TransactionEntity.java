import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class TransactionEntity {

    @PrimaryKey
    @NonNull
    private String id;
    private String title;
    private int amount;
    private String date;

    public TransactionEntity(@NonNull String id, String title, int amount, String date) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
