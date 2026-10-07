package com.example.cms.entries;


import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class EntryService {

    private final Entry_repository entry_repository;

    public EntryService(Entry_repository entry_repository) {
        this.entry_repository = entry_repository;
    }

    public List<Entry> getAllEntries() {
        return entry_repository.findAll();
    }

    public Entry getEntryById(Long id) {
        return entry_repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entry not found"));
    }

    public Entry createEntry(Entry entry) {
        return entry_repository.save(entry);
    }

    public Entry updateEntry(Long id, Entry entry) {
        if (!entry_repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entry not found");
        }
        entry.setId(id);
        return entry_repository.save(entry);
    }

    public void deleteEntry(Long id) {
        if (!entry_repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entry not found");
        }
        entry_repository.deleteById(id);
    }


}
