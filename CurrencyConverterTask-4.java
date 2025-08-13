import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mock exchange rates (relative to INR)
        Map<String, Double> rates = new HashMap<>();
        rates.put("INR", 1.0);     // Base
        rates.put("USD", 0.012);   // 1 INR = 0.012 USD
        rates.put("EUR", 0.011);   // 1 INR = 0.011 EUR
        rates.put("GBP", 0.0095);  // 1 INR = 0.0095 GBP
        rates.put("JPY", 1.75);    // 1 INR = 1.75 JPY

        System.out.println("💱 Welcome to Currency Converter");

        System.out.print("Enter base currency (INR, USD, EUR, GBP, JPY): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (INR, USD, EUR, GBP, JPY): ");
        String targetCurrency = scanner.next().toUpperCase();

        if (!rates.containsKey(baseCurrency) || !rates.containsKey(targetCurrency)) {
            System.out.println("❌ Invalid currency code. Please enter valid options.");
            return;
        }

        System.out.print("Enter amount to convert: ");
        double amount = 0;
        try {
            amount = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("❌ Invalid amount.");
            return;
        }

        if (amount <= 0) {
            System.out.println("❌ Please enter a positive amount.");
            return;
        }

        // Convert base currency to INR, then to target currency
        double amountInINR = amount / rates.get(baseCurrency);
        double convertedAmount = amountInINR * rates.get(targetCurrency);

        System.out.printf("✅ %.2f %s = %.2f %s\n",
                amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }
}