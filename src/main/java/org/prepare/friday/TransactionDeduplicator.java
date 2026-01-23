package org.prepare.friday;

/**
 * Class Using JDk17, for Given a list of transactions, detect duplicates and return unique entries.
 *
 */
import java.util.*;
import java.util.stream.Collectors;

public class TransactionDeduplicator {

    // Transaction record (immutable, concise)
    public record Transaction(String id, double amount, String type) {}

    // Imperative approach: using Set
    public static List<Transaction> uniqueTransactions(List<Transaction> transactions) {
        Set<Transaction> seen = new HashSet<>();
        List<Transaction> unique = new ArrayList<>();

        for (Transaction tx : transactions) {
            if (seen.add(tx)) { // add returns false if duplicate
                unique.add(tx);
            }
        }

        return unique;
    }

    // Functional approach: using Streams
    public static List<Transaction> uniqueTransactionsStream(List<Transaction> transactions) {
        return transactions.stream()
                .distinct() // relies on equals/hashCode from record
                .collect(Collectors.toList());
    }

    // Demo
    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction("T1", 100.0, "DEPOSIT"),
                new Transaction("T2", 200.0, "WITHDRAW"),
                new Transaction("T1", 100.0, "DEPOSIT"), // duplicate
                new Transaction("T3", 150.0, "DEPOSIT")
        );

        System.out.println("Imperative unique:");
        uniqueTransactions(new ArrayList<>(transactions))
                .forEach(System.out::println);

        System.out.println("\nStream unique:");
        uniqueTransactionsStream(transactions)
                .forEach(System.out::println);
    }
}
