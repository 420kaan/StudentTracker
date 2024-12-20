import java.util.ArrayList;
import java.util.List;

public class DataStore<T> { // Generic Class
    private List<T> records = new ArrayList<>();

    public void addRecord(T record) {
        records.add(record);
    }

    public List<T> getRecords() {
        return records;
    }

    public void removeRecord(T record) {
        records.remove(record);
    }
}
