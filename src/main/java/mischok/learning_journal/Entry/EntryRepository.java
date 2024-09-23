package mischok.learning_journal.Entry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Integer> {
    // Finde alle Einträge eines bestimmten Benutzers
    List<Entry> findByUserID(int userID);

    // Optional: Finde alle Einträge nach einem bestimmten Datum
    List<Entry> findByDateAfter(Date date);
}