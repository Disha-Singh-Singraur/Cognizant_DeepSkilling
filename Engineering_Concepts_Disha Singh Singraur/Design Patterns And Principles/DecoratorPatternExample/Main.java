public class Main {
    public static void main(String[] args) {
        System.out.println("--- Decorator Pattern Test ---");

        // 1. Send via basic Email Notifier
        System.out.println("Scenario A: Basic Email Notification");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("System updates at 10 PM.");

        System.out.println();

        // 2. Send via Email + SMS Notifier
        System.out.println("Scenario B: Email and SMS Notification");
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Transaction #4081 successful.");

        System.out.println();

        // 3. Send via Email + SMS + Slack Notifier (Fully decorated)
        System.out.println("Scenario C: Email, SMS, and Slack Notification");
        Notifier fullyDecoratedNotifier = new SlackNotifierDecorator(
                                                new SMSNotifierDecorator(
                                                    new EmailNotifier()
                                                )
                                            );
        fullyDecoratedNotifier.send("CRITICAL: Server load exceeded 95%!");
    }
}
