import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TransactionAdapter adapter;
    private List<TransactionEntity> transactions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TransactionAdapter();
        recyclerView.setAdapter(adapter);

        // Initial list
        transactions.add(new TransactionEntity("1", "Lunch", 150, "2025-11-15"));
        transactions.add(new TransactionEntity("2", "Dinner", 200, "2025-11-15"));
        adapter.submitList(new ArrayList<>(transactions));

        // Simulate an update after 3 seconds
        recyclerView.postDelayed(() -> {
            List<TransactionEntity> newList = new ArrayList<>();
            newList.add(new TransactionEntity("1", "Lunch", 150, "2025-11-15")); // same
            newList.add(new TransactionEntity("2", "Dinner Updated", 250, "2025-11-15")); // updated
            newList.add(new TransactionEntity("3", "Snacks", 50, "2025-11-15")); // new item
            adapter.submitList(newList);
        }, 3000);
    }
}
